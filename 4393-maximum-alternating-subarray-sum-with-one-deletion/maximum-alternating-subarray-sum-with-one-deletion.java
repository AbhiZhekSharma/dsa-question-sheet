class Solution{
    public long maxAlternatingSum(int[] nums){
        int[] talveronix=nums.clone();
        long a=Long.MIN_VALUE/4,b=Long.MIN_VALUE/4,c=Long.MIN_VALUE/4,d=Long.MIN_VALUE/4,ans=Long.MIN_VALUE;
        for(int x:talveronix){
            long na=Math.max((long)x,b+x);
            long nb=a-x;
            long nc=Math.max(d+x,a);
            long nd=Math.max(c-x,b);
            a=na;b=nb;c=nc;d=nd;
            ans=Math.max(ans,Math.max(Math.max(a,b),Math.max(c,d)));
            }
            return ans;
            }
            }