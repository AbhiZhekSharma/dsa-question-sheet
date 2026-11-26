//Nov 26
class Solution {
    public boolean canAliceWin(int n) {
        int stonesNeeded = 10;
        int turns = 0;
        
        while (n >= stonesNeeded) {
            n -= stonesNeeded;
            stonesNeeded--;
            turns++;
        }
        
        return turns % 2 == 1;
    }
}
