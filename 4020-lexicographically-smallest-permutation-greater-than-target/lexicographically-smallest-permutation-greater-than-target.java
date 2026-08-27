class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int i = 0;

        while (i < s.length() && freq[target.charAt(i) - 'a'] > 0) {
            freq[target.charAt(i) - 'a']--;
            i++;
        }

        while (true) {

            if (i < s.length()) {
                int x = target.charAt(i) - 'a';

                for (int c = x + 1; c < 26; c++) {

                    if (freq[c] > 0) {
                        StringBuilder ans = new StringBuilder();

                        ans.append(target, 0, i);
                        ans.append((char) ('a' + c));

                        freq[c]--;

                        for (int j = 0; j < 26; j++) {
                            while (freq[j] > 0) {
                                ans.append((char) ('a' + j));
                                freq[j]--;
                            }
                        }

                        return ans.toString();
                    }
                }
            }

            if (i == 0)
                break;

            i--;
            freq[target.charAt(i) - 'a']++;
        }

        return "";
    }
}