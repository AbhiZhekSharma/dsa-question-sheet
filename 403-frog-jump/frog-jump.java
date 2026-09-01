import java.util.*;

class Solution {
    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean canCross(int[] stones) {
        return solve(stones, 0, 0);
    }

    boolean solve(int[] stones, int pos, int jump) {
        if (pos == stones.length - 1)
            return true;

        String key = pos + "," + jump;

        if (dp.containsKey(key))
            return dp.get(key);

        for (int i = pos + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[pos];

            if (gap >= jump - 1 && gap <= jump + 1) {
                if (solve(stones, i, gap)) {
                    dp.put(key, true);
                    return true;
                }
            }
        }

        dp.put(key, false);
        return false;
    }
}