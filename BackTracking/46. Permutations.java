class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }
    public void solve(int ind,int[] nums,List<List<Integer>>ans){
        if(ind==nums.length){
            ArrayList<Integer>arr=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                arr.add(nums[i]);
            }
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            solve(ind+1,nums,ans);
            swap(i,ind,nums);//backtrack
        }
    }

    public void swap(int i,int j,int[]nums){
        // System.out.println(nums[i]+" "+nums[j]);
        if(i == j)return;
        nums[i] = nums[i] ^ nums[j]; 
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
        // System.out.println(nums[i]+" "+nums[j]);
    }

}
