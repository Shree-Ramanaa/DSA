/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node[] hs = new Node[101]; 
    public Node cloneGraph(Node node) {
       if(node == null)return node;
       Node n = dfs(node);
       return n;
    }

    private Node dfs(Node node){
        if(hs[node.val]==null)
        {
        Node n = new Node(node.val);
        hs[node.val]=n;
        for(Node no:node.neighbors){
            n.neighbors.add(dfs(no));
        }
        return n;
        }
        return hs[node.val];
    }
}
