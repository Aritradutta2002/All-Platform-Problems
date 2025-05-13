package LeetCode;
@SuppressWarnings("unused")
public class Lowest_Common_Ancestor_Of_BinaryTree_Leetcode236 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        // Example usage:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
