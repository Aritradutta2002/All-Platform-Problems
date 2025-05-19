import os
import time
import shutil
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler

# Path configurations
BASE_DIR = r"c:\Users\aritr\OneDrive\Desktop\All-Platform-Problems"
PLATFORMS = ["AtCoder", "CodeChef", "CodeForces", "CSESProblems", "LeetCode"]

# Dictionary to map platforms to their problem and testcase directories
PLATFORM_DIRS = {
    "AtCoder": {
        "problems": os.path.join(BASE_DIR, "AtCoder", "AtCoder_Problems"),
        "testcases": os.path.join(BASE_DIR, "AtCoder", "Atcoder_TestCases")
    },
    "CodeChef": {
        "problems": os.path.join(BASE_DIR, "CodeChef", "CodeChef_Problems"),
        "testcases": os.path.join(BASE_DIR, "CodeChef", "CodeChef_TestCases")
    },
    "CodeForces": {
        "problems": os.path.join(BASE_DIR, "CodeForces", "CodeForces_Problems"),
        "testcases": os.path.join(BASE_DIR, "CodeForces", "CodeForces_TestCases")
    },
    "CSESProblems": {
        "problems": os.path.join(BASE_DIR, "CSESProblems", "CSESProblems_Problems"),
        "testcases": os.path.join(BASE_DIR, "CSESProblems", "CSESProblems_TestCases")
    },
    "LeetCode": {
        "problems": os.path.join(BASE_DIR, "LeetCode", "LeetCode_Problems"),
        "testcases": os.path.join(BASE_DIR, "LeetCode", "LeetCode_TestCases")
    }
}

# Function to identify testcase files based on naming pattern or content
def is_testcase_file(file_path):
    # You can customize this function based on how you identify testcase files
    filename = os.path.basename(file_path).lower()
    
    # Common test file patterns
    test_patterns = [
        "test", "case", "sample", "example", "input", "output", 
        "spec", "fixture", "mock", "stub", "assert"
    ]
    
    # Check if filename contains test patterns
    for pattern in test_patterns:
        if pattern in filename:
            return True
    
    # Check for common test file extensions
    if filename.endswith((".in", ".out", ".txt", ".json", ".csv", ".xml")):
        return True
    
    # Check for Java/JUnit test files
    if filename.endswith(".java") and ("test" in filename.lower() or "spec" in filename.lower() or "assert" in filename.lower()):
        return True
    
    # Check file content for test frameworks for Java files
    if filename.endswith(".java"):
        try:
            with open(file_path, 'r', encoding='utf-8') as f:
                content = f.read(1000)  # Read only first 1000 chars for performance
                if any(framework in content for framework in ["@Test", "junit", "TestCase", "Assert", "org.junit"]):
                    return True
        except:
            pass  # Ignore errors when reading files
    
    return False

# Function to move a testcase file from problems dir to testcases dir
def move_testcase_file(src_path, platform):
    problems_dir = PLATFORM_DIRS[platform]["problems"]
    testcases_dir = PLATFORM_DIRS[platform]["testcases"]
    
    # Get the relative path from the problems directory
    rel_path = os.path.relpath(src_path, problems_dir)
    problem_dir = os.path.dirname(rel_path)
    
    # Create the corresponding directory in testcases if it doesn't exist
    dest_dir = os.path.join(testcases_dir, problem_dir)
    os.makedirs(dest_dir, exist_ok=True)
    
    # Move the file
    dest_path = os.path.join(testcases_dir, rel_path)
    print(f"Moving {src_path} to {dest_path}")
    shutil.move(src_path, dest_path)
    return dest_path

# Function to scan and move existing testcase files
def scan_and_move_existing_testcases():
    print("Scanning for existing test files...")
    moved_files = []
    
    for platform in PLATFORMS:
        problems_dir = PLATFORM_DIRS[platform]["problems"]
        if not os.path.exists(problems_dir):
            continue
            
        print(f"Scanning {problems_dir}...")
        
        # Walk through all files in the problems directory
        for root, dirs, files in os.walk(problems_dir):
            for file in files:
                file_path = os.path.join(root, file)
                
                # Check if it's a testcase file
                if is_testcase_file(file_path):
                    try:
                        dest_path = move_testcase_file(file_path, platform)
                        moved_files.append(dest_path)
                    except Exception as e:
                        print(f"Error moving {file_path}: {e}")
    
    if moved_files:
        print(f"Moved {len(moved_files)} existing test files to their testcase directories.")
    else:
        print("No existing test files found to move.")
    
    return moved_files

class TestcaseHandler(FileSystemEventHandler):
    def __init__(self, platform):
        self.platform = platform
        self.problems_dir = PLATFORM_DIRS[platform]["problems"]
        self.testcases_dir = PLATFORM_DIRS[platform]["testcases"]
        
    def on_created(self, event):
        if event.is_directory:
            return
        
        self.process_file(event.src_path)
    
    def on_modified(self, event):
        if event.is_directory:
            return
        
        self.process_file(event.src_path)
        
    def process_file(self, src_path):
        # Check if the file is in the problems directory and is a testcase file
        if self.problems_dir in src_path and is_testcase_file(src_path):
            try:
                move_testcase_file(src_path, self.platform)
            except Exception as e:
                print(f"Error moving {src_path}: {e}")

def main():
    # First, scan and move existing testcase files
    scan_and_move_existing_testcases()
    
    # Create observers for each platform
    observers = []
    
    for platform in PLATFORMS:
        problems_dir = PLATFORM_DIRS[platform]["problems"]
        testcases_dir = PLATFORM_DIRS[platform]["testcases"]
        
        # Check if problems directory exists
        if not os.path.exists(problems_dir):
            print(f"Warning: Problems directory {problems_dir} does not exist. Skipping.")
            continue
            
        # Ensure testcases directory exists
        os.makedirs(testcases_dir, exist_ok=True)
        
        # Set up the event handler and observer
        event_handler = TestcaseHandler(platform)
        observer = Observer()
        observer.schedule(event_handler, problems_dir, recursive=True)
        observers.append(observer)
        
        print(f"Monitoring {problems_dir} for testcase files...")
    
    # Start all observers
    for observer in observers:
        observer.start()
    
    try:
        # Keep the script running
        print("Testcase organizer is running. Press Ctrl+C to stop.")
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        # Stop all observers on keyboard interrupt
        for observer in observers:
            observer.stop()
    
    # Wait for all observer threads to finish
    for observer in observers:
        observer.join()

if __name__ == "__main__":
    main()
