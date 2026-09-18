/*class Solution{
    static int dp[][];
    public int longest(int[] s1,int[] s2,int i, int j) {
        int n1 = s1.length, n2.lengthth;
        if (i == n1 || j == n2)
        return 0;
        if (dp [i][j] != -1) return dp[i][j];
        
}
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {*/


    class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) { 
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[n1][n2];
    }
}