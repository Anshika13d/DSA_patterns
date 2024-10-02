class toggle_ith_bit{
    public int toggle(int n){
        return n & (n - 1);
    }
}