//Bottom Up

class Solution{
    public long maximumTotalDamage(int[] power){
        Map<Integer,Integer> map=new TreeMap<>();
        for(int x:power)map.put(x,map.getOrDefault(x,0)+1);

        List<Integer> a=new ArrayList<>(map.keySet());
        int n=a.size();
        long[] dp=new long[n+1];

        for(int i=1;i<=n;i++){
            int x=a.get(i-1);
            long take=(long)x*map.get(x);
            int j=i-1;

            while(j>0&&a.get(j-1)>=x-2)j--;

            take+=dp[j];
            dp[i]=Math.max(dp[i-1],take);
        }

        return dp[n];
    }
}
/*Class Solution{
    public long maximum
}
*/


