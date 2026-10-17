class Solution{  //aukat ke bhr
    public int kConcatenationMaxSum(int[] arr,int k){
        long MOD=1000000007L,sum=0,cur=0,best=0;
        for(int x:arr){
            sum+=x;
            cur=Math.max(0,cur+x);
            best=Math.max(best,cur);
        }
        if(k==1)return (int)(best%MOD);
        long cur2=0,best2=0;
        for(int i=0;i<2*arr.length;i++){
            cur2=Math.max(0,cur2+arr[i%arr.length]);
            best2=Math.max(best2,cur2);
        }
        long ans=best2;
        if(sum>0)ans+=(k-2)*sum;
        return (int)(ans%MOD);
    }
}