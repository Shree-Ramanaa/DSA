class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Map<Integer, Double>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new HashMap<>());
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).put(edges[i][1], succProb[i]);
            list.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        Set<Integer> visited = new HashSet<>();
        pq.offer(new double[]{start, 1});
        
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int node = (int)cur[0];
            double prob = cur[1];
            if (node == end) return prob;
            
            if (!visited.add(node)) continue;
            
            for (Map.Entry<Integer, Double> next: list.get(node).entrySet()) {
                pq.offer(new double[]{next.getKey(), prob * next.getValue()});
            }
        }
        
        return 0;
    }
}
