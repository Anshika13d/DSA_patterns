class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = getSum(weights);

        while(low <= high){
            int mid = (low + high)/2;

            if(isPossible(weights, mid) <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    public int isPossible(int[] weights, int mid){
        int load = 0;
        int days = 1;

        for(int i=0;i<weights.length;i++){
            if(load + weights[i] > mid){
                days++;
                load = 0;
                load += weights[i];
            }
            else{
                load += weights[i];
            }
        }

        return days;
    }

    public int getMax(int[] weights){
        int maxi = Integer.MIN_VALUE;

        for(int num: weights){
            maxi = Math.max(maxi, num);
        }

        return maxi;
    }

    public int getSum(int[] w){
        int sum = 0;

        for(int num: w){
            sum += num;
        }

        return sum;
    }
}