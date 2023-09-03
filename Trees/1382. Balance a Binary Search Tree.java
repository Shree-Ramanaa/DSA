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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        bstToList(root,l);
        int size = l.size();
        TreeNode r = ct(0,size-1,l);
        return r;
    }

    private void bstToList(TreeNode root, List<Integer> l){
        if(root==null)return;

        bstToList(root.left,l);
        l.add(root.val);
        bstToList(root.right,l);
        return;
    }

    private TreeNode ct(int s, int e, List<Integer> l){
        if(s>e){
            return null;
        }

        int mid = s+(e-s)/2;
        int val = l.get(mid);
        
        TreeNode left = ct(s,mid-1,l);
        TreeNode right = ct(mid+1,e,l);

        TreeNode node = new TreeNode(val,left,right);
        return node;
    }
}
