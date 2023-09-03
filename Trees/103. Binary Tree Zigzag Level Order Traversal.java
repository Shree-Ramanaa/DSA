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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        int i = 0;
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            while(size>0){
                TreeNode n = q.poll();
                l.add(n.val);
                if(n.left!=null)q.add(n.left);
                if(n.right!=null)q.add(n.right);
                size--;
            }
            if(i%2==1)Collections.reverse(l);
            ans.add(l);
            i++;
        }
        return ans;
    }
}
