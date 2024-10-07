class Solution
{
    public int[] AllPrimeFactors(int n)
    {
        // code here
        List<Integer> list = new ArrayList<>();
        
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                list.add(i);
                while(n % i == 0){
                    n /= i;
                }
            }
        }
        
        if(n != 1) list.add(n);
        
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
