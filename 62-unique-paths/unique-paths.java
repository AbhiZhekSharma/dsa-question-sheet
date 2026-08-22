class Solution {
    static int dp[][];
    public int fun(int m,int n){
        if(m < 0 || n < 0) return 0;
        if(m == 0 && n == 0) return 1;
        if(dp[m][n] != -1) return dp[m][n];
        int rightWay = fun(m,n-1);
        int downWay = fun(m-1,n);
        return dp[m][n] = rightWay + downWay;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int ele[]:dp){
            Arrays.fill(ele,-1);
        }
        return fun(m-1,n-1);
    }
}