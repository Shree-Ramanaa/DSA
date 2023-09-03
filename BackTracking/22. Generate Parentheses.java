class Solution {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(n,0,0,sb,0);
        return res;
    }

    private void solve(int n, int l, int r, StringBuilder sb, int i){
        if(l==n && r==n){
            res.add(sb.toString());
            return;
        }
        if(l<n){
        sb.append('(');
        solve(n,l+1,r,sb,i+1);
        sb.deleteCharAt(i);
        }
        if(r<l)
        {
        sb.append(')');
        solve(n,l,r+1,sb,i+1);
        sb.deleteCharAt(i);
        }

    }
}
