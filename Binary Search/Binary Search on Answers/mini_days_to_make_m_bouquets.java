class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if(m * k > n) return -1;

        int high = Integer.MIN_VALUE;
        for(int num: bloomDay){
            high = Math.max(num, high);
        }

        int low = 1;
        int minDays = -1;

        while(low <= high){
            int mid =  low + (high - low) / 2;

            if(canMakeBouquet(bloomDay, k, mid) >= m){
                minDays = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return minDays;
    }

    public int canMakeBouquet(int[] bloom, int k, int mid){
        int count = 0;
        int bouquets = 0;

        for(int i=0;i<bloom.length;i++){
            if(mid >= bloom[i]){
                count++;
            }
            else{
                count = 0;
            }
            if(count == k) {
                bouquets++;
                count = 0;
            }
        }

        return bouquets;
    }
}