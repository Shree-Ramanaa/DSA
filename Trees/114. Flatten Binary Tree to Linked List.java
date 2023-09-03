/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        solve(root);
    }

    private TreeNode solve(TreeNode root){
        if(root==null)return null;
        if(root.left == root.right && root.left==null)return root;
        TreeNode lt = solve(root.left);
        TreeNode rt = solve(root.right);
        if(lt !=null){
        lt.right = root.right;
        root.right = root.left;
        root.left = null;
        }
        return rt!=null ? rt:lt;
    }
}
