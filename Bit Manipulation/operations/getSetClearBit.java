class Solution {
    static void bitManipulation(int num, int i) {
        // code here
        //get ith bit
        int getBit = (num >> (i - 1)) & 1;
        System.out.print(getBit + " ");
        
        int setBit = num | (1 << (i - 1));
        System.out.print(setBit + " ");
        
        int clearBit = num & ~(1 << (i - 1));
        System.out.print(clearBit);
    }
}
