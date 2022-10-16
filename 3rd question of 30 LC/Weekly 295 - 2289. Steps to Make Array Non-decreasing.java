class Solution {
    public int totalSteps(int[] nums) {
        int steps=0,N=nums.length,top=N;
        int[] minStack=new int[N],count=new int[N];
        for(int i=nums.length-1;i>-1;i--){
            int ctr=0;
            while(top<N&&nums[minStack[top]]<nums[i])
                ctr=Math.max(ctr+1,count[minStack[top++]]);
            minStack[--top]=i;
            count[i]=ctr;
            if(ctr>steps) steps=ctr;
        }
        return steps;
    }
}
