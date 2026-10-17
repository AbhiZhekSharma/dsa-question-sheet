class Solution{
    int ans=0,empty=0;
    public int uniquePathsIII(int[][] grid){
        int sx=0,sy=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)empty++;
                if(grid[i][j]==1){
                    sx=i;
                    sy=j;
                }
            }
        }
        dfs(grid,sx,sy,empty+1);
        return ans;
    }
    void dfs(int[][] grid,int i,int j,int remain){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==-1)return;
        if(grid[i][j]==2){
            if(remain==0)ans++;
            return;
        }
        int temp=grid[i][j];
        grid[i][j]=-1;
        dfs(grid,i+1,j,remain-1);
        dfs(grid,i-1,j,remain-1);
        dfs(grid,i,j+1,remain-1);
        dfs(grid,i,j-1,remain-1);
        grid[i][j]=temp;
    }
}