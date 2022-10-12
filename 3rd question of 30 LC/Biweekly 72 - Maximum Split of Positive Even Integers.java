class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> s = new ArrayList<>();
        if(finalSum%2==1)return s;
        Long  i = 2L;
        Long sum = 0L;
        while(sum<=finalSum)
        {
            sum+=i;
            s.add(i);
            i+=2L;
        }
        s.remove(sum-finalSum);
        return s;
    }
}
