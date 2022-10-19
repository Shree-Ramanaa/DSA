class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack();
        HashMap<Integer,Integer> m = new HashMap<>();
        
        for(int i:nums2){
            while(!s.isEmpty() && i > s.peek()){
                m.put(s.pop(),i);
            }
            s.add(i);
        }
        int i = 0;
        int[] a = new int[nums1.length];
        
        for(int io : nums1){
                     a[i]=m.getOrDefault(io,-1);
                     i+=1;
        }
        return a;
    }
}
