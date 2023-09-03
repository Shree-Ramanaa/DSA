class Solution {
    private int size = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightSideView(root,result,0);
        return result;
        
    }
    public void rightSideView(TreeNode curr, List<Integer> result, int currDepth){
     
        if (curr == null) {
            return;
        }
        if(currDepth ==size){
            result.add(curr.val);
            size+=1;
        }
        rightSideView(curr.right, result, currDepth+1);
        rightSideView(curr.left, result, currDepth+1);
    }
}
