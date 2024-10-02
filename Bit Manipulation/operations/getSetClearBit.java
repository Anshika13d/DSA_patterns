class Solution {
    static void bitManipulation(int num, int i) {
        // code here
        //get ith bit
        int getBit = (num >> (i)) & 1;
        System.out.print(getBit + " ");
        
        //set ith bit
        int setBit = num | (1 << (i));
        System.out.print(setBit + " ");
        
        //clear ith bit
        int clearBit = num & ~(1 << (i));
        System.out.print(clearBit);
    }
}
