class Remove_last_setBit{
    public int last(int n){
        return n & (n - 1);
    }
}