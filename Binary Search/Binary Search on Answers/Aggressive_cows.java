class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        
        int l = 1;
        int h = stalls[n-1] - stalls[0];
        int ans = Integer.MIN_VALUE;
        
        while(l <= h){
            int m = l + (h - l)/ 2;
            
            if(isPossible(stalls, k, m)){
                ans = Math.max(m, ans);
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        
        return ans;
    }
    
    public static boolean isPossible(int[] stalls, int k, int m){
        int cows = 1;
        int lastCow = 0;
        
        for(int i=1;i<stalls.length;i++){
            if(stalls[i] - stalls[lastCow] >= m){
                cows++;
                lastCow = i;
            }
            if(cows == k) return true;
        }
        
        return false;
    }
}