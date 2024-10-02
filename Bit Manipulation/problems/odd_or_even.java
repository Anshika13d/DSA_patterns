class Solution {
    static String oddEven(int n) {
        // code here
        int getBit = n & 1;
        if(getBit == 0) return "even";
        return "odd";
    }
}