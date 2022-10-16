class Solution {
    int arr[] = new int[1000001];
    
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        for(int i = 0;i<nums.length;i+=1){
            arr[nums[i]]=i;
        }
        for(int[] i : operations){
            nums[arr[i[0]]]=i[1];
            arr[i[1]]=arr[i[0]];
        }
        return nums;
    }
}
