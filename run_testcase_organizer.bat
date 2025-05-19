@echo off
echo Starting Testcase Organizer...
echo.

REM Check if pip is installed
where pip >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo Error: Python pip is not installed or not in PATH.
    echo Please install Python from https://www.python.org/downloads/
    echo Make sure to check "Add Python to PATH" during installation.
    pause
    exit /b 1
)

REM Install watchdog directly
echo Installing watchdog module...
pip install watchdog
echo.

REM Run the Python script
echo Starting file monitoring system...
echo (Press Ctrl+C to stop the process)
echo.
python "%~dp0testcase_organizer.py"

pause
