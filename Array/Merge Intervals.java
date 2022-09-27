class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> result = new ArrayList();
        
        for(int i = 1; i < intervals.length; ++i){
            if(intervals[i][0] <= end){
                end = intervals[i][1] > end ? intervals[i][1] : end;
            }
            else{
                result.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start,end});
        
        return result.toArray(new int[result.size()][]);
    }
}
