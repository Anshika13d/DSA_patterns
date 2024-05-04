class Queue {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    /* The method pop which return the element poped out of the stack */
    int dequeue() {
        // Your code here
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                int num = input.pop();
                output.push(num);
            }
        }

        if (output.isEmpty())
            return -1;
        return output.pop();
    }

    /* The method push to push element into the stack */
    void enqueue(int x) {
        // Your code here
        input.push(x);
    }
}
