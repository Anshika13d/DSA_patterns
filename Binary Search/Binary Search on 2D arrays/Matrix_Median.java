class Solution {
    int median(int mat[][], int R, int C) {
        // code here 
        
        int low = getLow(mat);
        int high = getHigh(mat);
        int total = R * C;
        int median = total/2;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            int smallerElements = getSmallerElements(mat, mid);
            
            if(smallerElements > median) high = mid - 1;
            else low = mid + 1;
        }
        
        return low;
    }
    
    public int getSmallerElements(int mat[][], int mid){
        int smallerElements = 0;
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] <= mid){
                    smallerElements++;
                }
            }
        }
        return smallerElements;
    }
    
    public int getLow(int[][] mat){
        int mini = Integer.MAX_VALUE;
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mini = Math.min(mini, mat[i][j]);
            }
        }
        return mini;
    }
    
    public int getHigh(int[][] mat){
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                maxi = Math.max(maxi, mat[i][j]);
            }
        }
        return maxi;
    }
}