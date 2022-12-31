class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> gr = new HashMap<>();
        for(int i=0; i<values.length; i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            gr.putIfAbsent(a,new HashMap<>());
            gr.get(a).put(b,values[i]);
            gr.putIfAbsent(b,new HashMap<>());
            gr.get(b).put(a,1.0/values[i]);
        }

        double[] res = new double[queries.size()];

        for(int i=0;i<res.length;i++){
            String s = queries.get(i).get(0);
            String e = queries.get(i).get(1);
            res[i] = getWeight(s, e, gr, new HashSet<>());
        }
        return res;
    }

    private double getWeight(String s, String e, Map<String,Map<String,Double>> gr, Set<String> visited){
        if(!gr.containsKey(s)) return -1;
        if(gr.get(s).containsKey(e))return gr.get(s).get(e);

        visited.add(s);
        for(String neigh : gr.get(s).keySet()){
            if(!visited.contains(neigh)){
                double pro = getWeight(neigh,e,gr,visited);
                if(pro!=-1.0)return pro*gr.get(s).get(neigh);
            }
        }
        return -1.0;
    }
}
