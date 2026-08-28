class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];

        // Count characters
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // More than one odd frequency -> palindrome impossible
        int odd = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1)
            return "";

        // We only need half of every character
        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        int n = s.length();
        int half = n / 2;

        char[] ans = new char[n];

        int pos = 0;

        // Match target's left half
        while (pos < half) {
            int x = target.charAt(pos) - 'a';

            if (freq[x] == 0)
                break;

            ans[pos] = target.charAt(pos);
            freq[x]--;
            pos++;
        }

        // If complete left half matched
        if (pos == half) {

            if (mid != -1)
                ans[half] = (char) ('a' + mid);

            // Create right half
            for (int i = 0; i < half; i++) {
                ans[n - 1 - i] = ans[i];
            }

            String result = new String(ans);

            // It must be STRICTLY greater
            if (result.compareTo(target) > 0)
                return result;
        }

        // Backtrack
        while (true) {

            // Try a character greater than target[pos]
            if (pos < half) {

                int x = target.charAt(pos) - 'a';

                for (int c = x + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        ans[pos] = (char) ('a' + c);
                        freq[c]--;

                        // Fill remaining half in smallest order
                        int index = pos + 1;

                        for (int j = 0; j < 26; j++) {
                            while (freq[j] > 0) {
                                ans[index++] = (char) ('a' + j);
                                freq[j]--;
                            }
                        }

                        // Middle character
                        if (mid != -1)
                            ans[half] = (char) ('a' + mid);

                        // Mirror left half
                        for (int j = 0; j < half; j++) {
                            ans[n - 1 - j] = ans[j];
                        }

                        return new String(ans);
                    }
                }
            }

            // Cannot increase current position
            if (pos == 0)
                return "";

            // Backtrack
            pos--;

            int x = target.charAt(pos) - 'a';
            freq[x]++;
        }
    }
}