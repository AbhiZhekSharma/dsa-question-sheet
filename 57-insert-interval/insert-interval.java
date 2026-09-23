import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        
        //Adding all intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        //Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        //Adding the single, final merged interval
        result.add(newInterval);
        
        //Adding all remaining intervals that come after the merged interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        // Convert the dynamic list back to a primitive 2D array
        return result.toArray(new int[result.size()][]);
    }
}
