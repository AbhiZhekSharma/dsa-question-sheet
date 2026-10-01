/*class Solution{
    int m,n;
    boolean solve(char[][] grid,int i,int j,int bal){
        if(i>=m||j>=n||bal<0)
            return false; // base case
             if(grid[i][j]=='(')
            bal++;
        else
            bal--;
            if(bal<0)
            return false; // base case
            if(i==m-1&&j==n-1)
            return bal==0; // base case
             boolean right=solve(grid,i,j+1,bal); // right
        boolean down=solve(grid,i+1,j,bal); // down
        return right||down; // answer
    }
    public boolean hasValidPath(char[][] grid){
        m=grid.length;
        n=grid[0].length;
         if(grid[0][0]==')')
            return false;
            if(grid[m-1][n-1]=='(')
            return false;
            if((m+n-1)%2!=0)
            return false;
            return solve(grid,0,0,0);
    }
}*/
//tle^//
//DP//

class Solution{
    int m,n;
    Boolean[][][] dp;

    boolean solve(char[][] grid,int i,int j,int bal){

        if(i>=m||j>=n||bal<0)
            return false;

        if(grid[i][j]=='(')
            bal++;
        else
            bal--;

        if(bal<0)
            return false;

        if(i==m-1&&j==n-1)
            return bal==0;

        if(dp[i][j][bal]!=null)
            return dp[i][j][bal];

        boolean right=solve(grid,i,j+1,bal);
        boolean down=solve(grid,i+1,j,bal);

        return dp[i][j][bal]=right||down;
    }

    public boolean hasValidPath(char[][] grid){

        m=grid.length;
        n=grid[0].length;

        if(grid[0][0]==')')
            return false;

        if(grid[m-1][n-1]=='(')
            return false;

        if((m+n-1)%2!=0)
            return false;

        dp=new Boolean[m][n][m+n];

        return solve(grid,0,0,0);
    }
}