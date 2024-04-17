class Solution {
    int count(int[] arr, int n, int x) {
        int start = -1;
        int end = -1;

        start = helper(arr, true, x);
        end = helper(arr, false, x);

        if (start == -1)
            return 0;

        return end - start + 1;
    }

    int helper(int[] arr, boolean is, int x) {
        int l = 0;
        int r = arr.length - 1;

        int ind = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                if (is) {
                    ind = mid;
                    r = mid - 1;
                } else {
                    ind = mid;
                    l = mid + 1;
                }
            }

            else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ind;
    }
}