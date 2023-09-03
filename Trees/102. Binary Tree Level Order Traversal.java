class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        bfs(root,ans);
        return ans;
    }

    private void bfs(TreeNode root, List<List<Integer>> ans){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            while(size-- > 0){
                TreeNode r = q.poll();
                if(r.left != null)q.add(r.left);
                if(r.right != null)q.add(r.right);
                row.add(r.val);
            }
            ans.add(row);
        }
    }
}
