class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;

        long xor = 0;
        for(int num: nums){
            xor ^= num;
        }

        int n1 = 0, n2 = 0;
        //mask without shifting and just anding the xor with 2's complement of xor
        long mask = xor & -xor;

        //to create a mask by shifting
        //long cnt = 0;

        // while(xor > 0){
        //     if((xor & 1) == 0){
        //         cnt++;
        //         xor = xor >> 1;
        //     }
        //     else{
        //         break;
        //     }
        // }

        //long mask = 1 << cnt;

        for(int i = 0; i < n; i++){
            if((nums[i] & mask) == 0){
                n1 ^= nums[i];
            }
            else{
                n2 ^= nums[i];
            }
        }

        return new int[]{n1, n2};
    }
}
