class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        map<int,int>m1;

        for(auto a:nums){
            m1[a]++;
        }

        for(int i=1;i<=200;i++){
            if(m1.find(i)==m1.end() && i%k==0) return i;
        }
        return -1;
    }
};