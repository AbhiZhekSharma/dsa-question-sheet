
class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return check(s1, s2, s3, 0, 0);
    }

    boolean check(String a, String b, String c, int i, int j) {
        if (i == a.length() && j == b.length()) return true;
        if (dp[i][j] != null) return dp[i][j];

        int k = i + j;
        boolean ans = false;
        if (i < a.length() && a.charAt(i) == c.charAt(k))
            ans = check(a, b, c, i + 1, j);
        if (!ans && j < b.length() && b.charAt(j) == c.charAt(k))
            ans = check(a, b, c, i, j + 1);
        return dp[i][j] = ans;
    }
}
