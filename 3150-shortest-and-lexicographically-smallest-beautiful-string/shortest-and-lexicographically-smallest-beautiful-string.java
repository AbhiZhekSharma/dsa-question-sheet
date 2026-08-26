class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        int count = 0;
        String ans = "";

        for (int j = 0; j < s.length(); j++) {

            if (s.charAt(j) == '1')
                count++;

            while (count > k) {
                if (s.charAt(i) == '1')
                    count--;
                i++;
            }

            while (count == k && s.charAt(i) == '0')
                i++;

            if (count == k) {
                String temp = s.substring(i, j + 1);

                if (ans.equals("") ||
                    temp.length() < ans.length() ||
                    (temp.length() == ans.length() &&
                     temp.compareTo(ans) < 0)) {

                    ans = temp;
                }
            }
        }

        return ans;
    }
}