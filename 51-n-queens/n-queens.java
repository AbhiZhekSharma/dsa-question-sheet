class Solution{
    List<List<String>> ans=new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n){
        char[][] board=new char[n][n];         //n*n chess board
        for(char[] row:board)
            Arrays.fill(row,'.');              //fill . to evry cell

        solve(board,0,n);                      // (fun) board ke 0 se strt kro
        return ans;                            //  valid board 
    }
    void solve(char[][] board,int row,int n){
        if(row==n){                                //
            List<String> temp=new ArrayList<>();

            for(char[] r:board)
                temp.add(new String(r));          
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++){                //check evry col of curr row
            if(isSafe(board,row,col,n)){           //checking evry row and col for placing queen
                board[row][col]='Q';               //queen placed
                solve(board,row+1,n);              // again check for anthr queen
                board[row][col]='.';               //if not then put . and place the queen in next col
            }
        }
    }
        boolean isSafe(char[][] board,int row,int col,int n){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q')
                return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')
                return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q')
                return false;
        }

        return true;
    }
}