//ssssssss
class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int k = 1024;

        boolean[][] prev = new boolean[n][k];
        boolean[][] curr = new boolean[n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curr[j] = new boolean[k];

                if (i == 0 && j == 0) {
                    curr[j][grid[i][j]] = true;
                    continue;
                }

                if (i > 0) {
                    for (int x = 0; x < k; x++) {
                        if (prev[j][x])
                            curr[j][x ^ grid[i][j]] = true;
                    }
                }

                if (j > 0) {
                    for (int x = 0; x < k; x++) {
                        if (curr[j - 1][x])
                            curr[j][x ^ grid[i][j]] = true;
                    }
                }
            }

            boolean[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        for (int x = 0; x < k; x++) {
            if (prev[n - 1][x])
                return x;
        }

        return -1;
    }
}
