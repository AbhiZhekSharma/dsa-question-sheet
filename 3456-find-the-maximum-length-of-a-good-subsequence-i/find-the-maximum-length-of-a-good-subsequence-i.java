class Solution{
    public int maximumLength(int[] nums,int k){
        int n=nums.length,ans=1;            // n= [array size], ans= [maximum length]
        int[][] dp=new int[n][k+1];         // dp[i][x] = length ending at i with x changes
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],1);           // every single element forms length 

        for(int i=0;i<n;i++){               // choose current element
            for(int j=0;j<i;j++){           // check all previous elements
                for(int x=0;x<=k;x++){      // try x allowed changes
                    if(nums[i]==nums[j])


                        dp[i][x]=Math.max(dp[i][x],dp[j][x]+1);      // same value = no new change

                    else if(x>0)
                    
                        dp[i][x]=Math.max(dp[i][x],dp[j][x-1]+1);    // different value = use 1 change
                    ans=Math.max(ans,dp[i][x]);                      // update maximum answer
                }
            }
        }
        return ans;                                                  // return longest good subsequence
    }
}