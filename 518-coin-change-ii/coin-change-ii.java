/*class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount +1];
        for(int = 0; i < coins.length;i++)
 {
    return fun(0,0, amount,coins);
   }     

    int fun(int i,int k,int sum,int[] arr)  {
        if(sum==k)                return 1;
    }
    if(sum>k || i>=arr.length)    return 0;
    if(dp[i][sum] != -1)          return dp[i][sum];
    
    int c1 =fun(i,sum + arr[i] ,k ,arr);
    int c2 =fun(i+1 , sum , k , arr);
        
    dp[i][sum] = c1+c2;
        return dp[i][sum];


    }
    
}*/

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}