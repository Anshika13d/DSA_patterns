class Solution {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if (arr1.length > arr2.length) {
            return kthElement(arr2, arr1, m, n, k);
        }

        int l = Math.max(k - m, 0);
        int h = Math.min(k, n);

        while (l <= h) {
            int mid1 = l + (h - l) / 2;
            int mid2 = k - mid1;

            int l1 = mid1 > 0 ? arr1[mid1 - 1] : -1;
            int l2 = mid2 > 0 ? arr2[mid2 - 1] : -1;
            int r1 = mid1 < n ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < m ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 > r2)
                h = mid1 - 1;
            else if (l2 > r1)
                l = mid1 + 1;

            else {
                return (long) Math.max(l1, l2);
            }
        }

        return -1;
    }
}