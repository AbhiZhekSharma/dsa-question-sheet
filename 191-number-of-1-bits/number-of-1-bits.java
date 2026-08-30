class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count+=n&1;//check bit
            n=n>>>1;//shift
        }
        return count;
    }
}