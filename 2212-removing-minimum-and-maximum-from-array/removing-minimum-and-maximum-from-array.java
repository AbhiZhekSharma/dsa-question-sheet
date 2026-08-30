class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=0,max=0;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[min])
                min=i;//min index
            if(nums[i]>nums[max])
                max=i;//max index
        }
        int a=Math.min(min,max);
        int b=Math.max(min,max);
        int left=b+1;//left removal
        int right=n-a;//right removal
        int both=(a+1)+(n-b);//both sides

        return Math.min(left,Math.min(right,both));
    }
}