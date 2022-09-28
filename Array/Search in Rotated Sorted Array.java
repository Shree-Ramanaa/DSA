/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1
*/

class Solution {
    public int search(int[] arr, int target) {
       int peak = findPeak(arr,target);
       if( arr[peak]==target || peak == -1)
       {
           return peak;
       }
       else if(arr[0]>target)
       {
           return binsearch(arr,target,peak+1,arr.length-1);
       }
       else
       {
           return binsearch(arr,target,0,peak);
       }
    }
    
    public int findPeak(int[] arr, int target) {
      int start =0,end=arr.length-1;
      
        while(start<=end)
        {
          int mid = (start+end)/2;
            
          if(start==mid&&mid==end)return mid;
            
          if(mid<end && arr[mid]>arr[mid+1])return mid;
          
          else if(mid>start && arr[mid-1]>arr[mid])return mid-1;
            
          else if(arr[start]<=arr[mid])start=mid+1;
            
          else if(arr[mid]<=arr[end])end=mid-1;  
        }
        return -1;
        }
    
    public int binsearch(int[] arr, int target,int start, int end) {
        
        while(start<=end)
        {
          int mid = (start+end)/2;
          
          if(arr[mid]==target)return mid; 
          if(arr[start]==target)return start;
          if(arr[end]==target)return end;
            
          if(arr[mid]>target)end=end-1;
          else start=start+1;  
        }return -1;
    }
}
