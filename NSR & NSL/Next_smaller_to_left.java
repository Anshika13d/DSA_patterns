public int[] getNSL(int[] height) {
    int n = height.length;

    Stack<Integer> stack = new Stack<>();
    int[] NSL = new int[n];

    for (int i = 0; i < n; i++) {
        if (stack.isEmpty()) {
            NSL[i] = -1;
        } else {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = stack.peek();
            }
        }

        stack.push(i);
    }

    return NSL;
}