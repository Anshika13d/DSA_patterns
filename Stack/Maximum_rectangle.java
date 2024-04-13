class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[] height = new int[m];
        for(int i=0;i<m;i++){
            height[i] = matrix[0][i] == '1' ? 1 : 0;
        }

        int maxArea = findMaxArea(height);

        for(int row = 1; row < n; row++){
            for(int col = 0; col < m; col++){
                if(matrix[row][col] == '0'){
                    height[col] = 0;
                }
                else{
                    height[col] += 1;
                }
            }

            maxArea = Math.max(maxArea, findMaxArea(height));
        }

        return maxArea;
    }

    public int findMaxArea(int[] height){
        int n = height.length;

        int[] NSL = getNSL(height);
        int[] NSR = getNSR(height);
        int[] width = new int[n];

        for(int i=0;i<n;i++){
            width[i] = NSR[i] - NSL[i] - 1;
        }

        int maxArea = 0;

        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea, height[i] * width[i]);
        }

        return maxArea;
    }

    public int[] getNSR(int[] height){
        int n = height.length;

        Stack<Integer> stack = new Stack<>();
        int[] NSR = new int[n];

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                NSR[i] = n;
            }else{
                while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    NSR[i] = n;
                }
                else{
                    NSR[i] = stack.peek();
                }
            }

            stack.push(i);
        }

        return NSR;
    }

    public int[] getNSL(int[] height){
        int n = height.length;

        Stack<Integer> stack = new Stack<>();
        int[] NSL = new int[n];

        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                NSL[i] = -1;
            }else{
                while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    NSL[i] = -1;
                }
                else{
                    NSL[i] = stack.peek();
                }
            }

            stack.push(i);
        }

        return NSL;
    }
}