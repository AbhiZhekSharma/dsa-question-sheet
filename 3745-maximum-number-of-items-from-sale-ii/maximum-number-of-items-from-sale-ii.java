class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int[] gain = new int[n + 1];

        for (int[] item : items)
            freq[item[0]]++;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i)
                gain[i] += freq[j];

            gain[i]--;
        }
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        int min = items[0][1];
        int ans = 0;

        for (int[] item : items) {
            int f = item[0];
            int p = item[1];
            if (p >= 2L * min)
                break;

            int take = Math.min(gain[f], budget / p);
            ans += 2 * take;
            budget -= take * p;
        }

        return ans + budget / min;
    }
}