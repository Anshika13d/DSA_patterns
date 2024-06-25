class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0;
        int h = n;

        int part = (m + n + 1) / 2;
        double median = 0.00000;

        while (l <= h) {
            int mid1 = l + (h - l) / 2;
            int mid2 = part - mid1;

            int l1 = mid1 > 0 ? nums1[mid1 - 1] : -1;
            int l2 = mid2 > 0 ? nums2[mid2 - 1] : -1;
            int r1 = (mid1 < n) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 > r2)
                h = mid1 - 1;
            else if (l2 > r1)
                l = mid1 + 1;

            else if ((n + m) % 2 == 0) {
                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            } else {
                return (double) Math.max(l1, l2);
            }
        }

        return -1;
    }
}