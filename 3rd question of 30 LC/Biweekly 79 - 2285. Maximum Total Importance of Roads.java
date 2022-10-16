class Solution {
  public long maximumImportance(int n, int[][] roads) {
    // degree edges of nodes
    final int[] degree = new int[n];
    for (int[] road : roads) {
      degree[road[0]]++;
      degree[road[1]]++;
    }

    // assign larger value to larger degree node
    Arrays.sort(degree);
    long result = 0;
    for (int i = 0; i < n; i++) {
      result += (long) degree[i] * (i + 1);
    }
    return result;
  }
}
