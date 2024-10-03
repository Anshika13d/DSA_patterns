class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        int subsets = 1 << n;
        for(int i=0;i<subsets;i++){
            List<Integer> res = new ArrayList<>();
            int j = 0;
            while(j < n){
                int sith = i & (1 << j);
                
                if (sith != 0){
                    res.add(nums[j]);
                }

                j++;
            }

            list.add(res);
        }

        return list;
    }
}
