class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;

        int[] leftMax = getLeftMax(height, n);
        int[] rightMax = getRightMax(height, n);

        for (int i = 0; i < n; i++) {
            int h = Math.min(leftMax[i], rightMax[i]) - height[i];
            sum += h;
        }

        return sum;
    }

    public int[] getLeftMax(int[] height, int n) {
        int[] getMax = new int[n];
        getMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            getMax[i] = Math.max(getMax[i - 1], height[i]);
        }

        return getMax;
    }

    public int[] getRightMax(int[] height, int n) {
        int[] getMax = new int[n];
        getMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            getMax[i] = Math.max(getMax[i + 1], height[i]);
        }

        return getMax;
    }
}