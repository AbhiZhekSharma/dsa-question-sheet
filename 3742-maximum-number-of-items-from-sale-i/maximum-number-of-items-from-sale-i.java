//Nov 28
class Solution {
    int[][] dp;
    int[] gain;
    int min = Integer.MAX_VALUE;
    
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        gain = new int[n];
        dp = new int[n][budget + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            min = Math.min(min, items[i][1]);
            gain[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0)
                    gain[i]++;
            }
        }
        return solve(0, budget, items);
    }
    int solve(int i, int b, int[][] items) {
        if (i == items.length)
            return b / min;
        if (dp[i][b] != -1)
            return dp[i][b];

        int notTake = solve(i + 1, b, items);
        int take = 0;
        if (items[i][1] <= b)
            take = gain[i] + solve(i + 1, b - items[i][1], items);

        return dp[i][b] = Math.max(take, notTake);
    }
}