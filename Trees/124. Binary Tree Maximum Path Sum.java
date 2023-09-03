class Solution {
    //private int result = -1000;

    public int maxPathSum(TreeNode root) {
        if(root == null)return -1;
        int result = Integer.MIN_VALUE;
        solve(root,result);
        return result;
    }

    private int solve(TreeNode root,int result){
        if(root==null)return 0;
        int left = root.val + solve(root.left,result);
        int right = root.val + solve(root.right,result);

        int maxSum = Math.max(root.val,Math.max(left,right));
        result = Math.max(Math.max(left+right-root.val,root.val),Math.max(result,maxSum));

        return maxSum;
    }
}
