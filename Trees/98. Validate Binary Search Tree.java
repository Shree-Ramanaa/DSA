class Solution {
    public boolean isValidBST(TreeNode root) {
       return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long minVal, long maxVal){
        if(root == null)return true;
        if(root.val<=minVal || root.val>=maxVal)return false;
        return dfs(root.left,minVal,root.val) && dfs(root.right,root.val,maxVal);
    }
}
