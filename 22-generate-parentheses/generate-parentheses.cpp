class Solution {
public:
    void fun(string s, int a, int b, int n, vector<string>& ans) {
        if (a > n || b > a)
            return;
        if (s.size() == 2 * n) {
            ans.push_back(s);
            return;
        }
        fun(s + "(", a + 1, b, n, ans);
        fun(s + ")", a, b + 1, n, ans);
    }

    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        fun("", 0, 0, n, ans);
        return ans;
    }
};