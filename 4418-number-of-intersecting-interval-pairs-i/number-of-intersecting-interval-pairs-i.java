class Solution{
     public int countIntersectingIntervals(int[][] intervals) {
        int n=intervals.length,
        ans=0;                    // size 
        for(int i=0;i<n;i++){                            // first interval
            for(int j=i+1;j<n;j++){                      // second interval

                if(Math.max(intervals[i][0],intervals[j][0])<=
                   Math.min(intervals[i][1],intervals[j][1])){
                    ans++;                               // intersecting pair
                }
            }
        }

        return ans; 
    }
}