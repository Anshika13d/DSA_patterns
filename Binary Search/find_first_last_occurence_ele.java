class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = {-1, -1};

        int start = search(nums, target, true);
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;        
    }

    public int search(int[] nums, int target, boolean leftright){
        int s = 0;
        int e = nums.length - 1;
        int ind = -1;

        while(s <= e){

            int mid = s + (e - s) / 2;

            if(nums[mid] < target){
                s = mid + 1;
            }
            else if(nums[mid] > target){
                e = mid - 1;
            }
            else{
                if(leftright){
                    ind = mid;
                    e = mid - 1;
                }
                else{
                    ind = mid;
                    s = mid + 1;
                }
            }
        }

        return ind;
    }
}