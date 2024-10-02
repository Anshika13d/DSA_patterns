//way - 1;
//time - O(log n)
//worst - O(31)
class Solution{
    public static int count(int n){
        int cnt = 0;
        
        while(n > 1){
            cnt += (n & 1); // this means we are checking for even or odd basically if (n % 2 != 0 or == 0)
            n = n >> 1; // right shift of any number n = n / 2 ^ k; so here we are divinding n by 2 each time so n/2 => n >> 1, right shift by 1 because 2 ^ 0 is 1
        }
        
        if(n == 1) cnt++;
        return cnt;
    }
}

//way - 2
//time - O(no. of 1's)
public static int count(int n){
    int cnt = 0;
    
    //this will keep removing the rightmost bit which is set so this loop will run till there are 1's
    while(n > 0){
        n = n & (n - 1);
        cnt++;
    }
    
    if(n == 1) cnt++;
    return cnt;
}