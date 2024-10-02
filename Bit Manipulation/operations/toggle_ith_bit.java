class toggle_ith_bit{
    public int toggle(int n, int i){
        return n ^ (1 << i);
    }
}