class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        if (n < m)
            return -1;
        // Your code here
        long l = getMin(arr); // 12
        long h = getSum(arr); // 203
        long ans = Long.MAX_VALUE;

        while (l <= h) {
            long mid = l + (h - l) / 2; // 107

            if (isPossible(mid, arr, m)) {
                h = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    public static long getMin(int[] arr) {
        long mini = Long.MAX_VALUE;

        for (int num : arr) {
            mini = Math.min(mini, num);
        }

        return mini;
    }

    public static long getSum(int[] arr) {
        long sum = 0;

        for (long num : arr) {
            sum += num;
        }

        return sum;
    }

    public static boolean isPossible(long mid, int[] arr, int m) {
        int students = 1;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid)
                return false;
            sum += arr[i];
            if (sum > mid) {
                students++;
                sum = arr[i];
            }

            if (students > m)
                return false;
        }

        return true;
    }
};