public int[] getNSR(int[] height) {
    int n = height.length;

    Stack<Integer> stack = new Stack<>();
    int[] NSR = new int[n];

    for (int i = n - 1; i >= 0; i--) {
        if (stack.isEmpty()) {
            NSR[i] = n;
        } else {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                NSR[i] = n;
            } else {
                NSR[i] = stack.peek();
            }
        }

        stack.push(i);
    }

    return NSR;
}