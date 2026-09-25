class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[1]-b[1]);

        int ans = 0;
        int last = Integer.MIN_VALUE;

        for(int[] p : pairs) {
            if(p[0] > last) {
                ans++;
                last = p[1];
            }
        }

        return ans;
    }
}