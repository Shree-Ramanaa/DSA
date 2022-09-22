class Solution {
   public int[][] kClosest(int[][] points, int K) {
  Arrays.sort(points, (p1, p2) -> {  
    return (p1[0]*p1[0] + p1[1]*p1[1]) - (p2[0]*p2[0]+p2[1]*p2[1]); 
  });
  int[][] result = new int[K][];
  for (int i = 0; i < K; ++i) {
    result[i] = new int[] { points[i][0], points[i][1] };
  }
  return result;
    }
}
// can be also solved by quick select :)
