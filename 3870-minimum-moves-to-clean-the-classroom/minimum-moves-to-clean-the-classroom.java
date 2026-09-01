class Solution{
    public int minMoves(String[] classroom,int energy){
        int m=classroom.length,n=classroom[0].length(),sr=0,sc=0,cnt=0;
        int[][] id=new int[m][n];
        for(int[] x:id)Arrays.fill(x,-1);
        for(int i=0;i<m;i++)for(int j=0;j<n;j++){
            if(classroom[i].charAt(j)=='S'){sr=i;sc=j;}
            if(classroom[i].charAt(j)=='L')id[i][j]=cnt++;
        }
        int full=(1<<cnt)-1;
        boolean[][][][] vis=new boolean[m][n][energy+1][1<<cnt];
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{sr,sc,energy,0});
        vis[sr][sc][energy][0]=true;
        int[] dr={1,-1,0,0},dc={0,0,1,-1};
        int moves=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[]cur=q.poll();
                int r=cur[0],c=cur[1],e=cur[2],mask=cur[3];
                if(mask==full)return moves;
                for(int d=0;d<4;d++){
                    int nr=r+dr[d],nc=c+dc[d];
                    if(nr<0||nr>=m||nc<0||nc>=n||classroom[nr].charAt(nc)=='X'||e==0)continue;
                    int ne=e-1,nm=mask;
                    char ch=classroom[nr].charAt(nc);
                    if(ch=='L')nm|=1<<id[nr][nc];
                    if(ch=='R')ne=energy;
                    if(!vis[nr][nc][ne][nm]){
                        vis[nr][nc][ne][nm]=true;
                        q.offer(new int[]{nr,nc,ne,nm});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}