class Solution {
    public List<List<Integer>> fourSum(int[] nums, int sum) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        int n= nums.length;
        int a = sum/4;
        if(a<nums[0])return ans;
        for(int i = 0; i<n-3; ++i){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                for(int j = i+1; j<n-2; j++){
                    if(j==i+1 || (j>i+1 && nums[j]!=nums[j-1])){
                    int l = j+1 , r = n-1;
                
                    while(l<r){
                        //System.out.println(i+" "+j+" "+l+" "+r);
                        int s = nums[i]+nums[j]+nums[l]+nums[r];
                        if(s == sum){
                            List<Integer> list = Arrays.asList(nums[i],nums[j],nums[l],nums[r]);
                            ans.add(list);
                            r--;
                            l++;
                            while(l<r && nums[l]==nums[l-1])l++;
                            while(l<r && nums[r]==nums[r+1])r--;
                        }
                        else if(s>sum){
                            r--;
                        }
                        else{
                            l++;
                        }
                    }
                  }
                }
            }
        }
        
        return ans;
    }
}
