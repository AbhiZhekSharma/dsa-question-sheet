//Nov 24
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 2;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                boolean valid = true;

                for(int k = i; k < j; k++) {
                    if(gcd(nums[k], nums[j]) != 1) {
                        valid = false;
                        break;
                    }
                }
                if(!valid) break;

                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}