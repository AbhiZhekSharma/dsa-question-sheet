class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();         //finding no of rows
        int[][] dp=new int[n][n];      //dp for storing min val
        for(int j=0;j<n;j++)
            dp[n-1][j]=triangle.get(n-1).get(j);

        for(int i=n-2;i>=0;i--){        //moving feom 2nd last row to first row
            for(int j=0;j<=i;j++){      // Visit each valid element in the current row
                int down=dp[i+1][j];    // Same column in the next row
                int right=dp[i+1][j+1];
                dp[i][j]=triangle.get(i).get(j)+Math.min(down,right);     
                // Add current value to the minimum of the two possible paths
            }
        }

        return dp[0][0];
    }
}