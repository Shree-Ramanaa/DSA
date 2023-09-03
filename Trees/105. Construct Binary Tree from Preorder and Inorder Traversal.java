class Solution {

    private static int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode root = helper(new TreeNode(), preorder, inorder, preIndex, 0, preorder.length);
        return root;
    }

    private TreeNode helper(TreeNode root, int[] preorder, int[] inorder, int preIndex, int start, int end){
        if(start >= end || preIndex == preorder.length)return null;
        int inIndex = start;
        while(inIndex < end && preorder[preIndex] != inorder[inIndex]){
            inIndex++;
        }
        root.val = inorder[inIndex];
        root.left = helper(new TreeNode(), preorder, inorder, preIndex + 1, start, inIndex);
        root.right = helper(new TreeNode(), preorder, inorder, preIndex + inIndex + 1 - start, inIndex + 1, end);
        return root;
    }
}
