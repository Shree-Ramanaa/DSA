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
    private int c = 0;
    
    public int goodNodes(TreeNode root) {
        int max = root.val;
        dfs(root,max);
        return c;
    }
    
    private void dfs(TreeNode root, int max){
        if(root.val >= max){
            c+=1;
            max=root.val;
        }
        if(root.left==root.right)return;
        if(root.left!=null)dfs(root.left,max);
        if(root.right!=null)dfs(root.right,max);
        return;
    }
}
