//way - 1
class CheckBit {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k) {
        // Your code here
        int set = n & (1 << k);
        if(set != 0) return true;
        return false;
    }
}

//way - 2
class CheckBit {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k) {
        // Your code here
        int set = n | (1 << k);
        if(set == n) return true;
        return false;
    }
}

//way - 3
class CheckBit{
    static boolean checkKthBit(int n, int k){
        int set = 1 & (n >> k);
        if(set == 1) return true;
        return false;
    }
}