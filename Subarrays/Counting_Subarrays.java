class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }

        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        int odd = 0;

        if (k < 0)
            return 0;

        while (r < nums.length) {
            odd += nums[r];

            while (odd > k) {
                odd -= nums[l];
                l++;
            }

            cnt += r - l + 1;
            r++;
        }

        return cnt;
    }
}