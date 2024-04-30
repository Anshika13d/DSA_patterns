class Solution {
    public long wonderfulSubstrings(String word) {
        long result = 0;

        HashMap<Long, Integer> map = new HashMap<>();

        long cum_xor = 0;
        map.put(cum_xor, 1);

        for (char ch : word.toCharArray()) {
            int shift = ch - 'a';
            cum_xor ^= 1L << shift;

            result += map.getOrDefault(cum_xor, 0);

            for (int ch1 = 'a'; ch1 <= 'j'; ch1++) {
                shift = ch1 - 'a';
                long num = (cum_xor ^ (1L << shift));

                result += map.getOrDefault(num, 0);
            }

            map.put(cum_xor, map.getOrDefault(cum_xor, 0) + 1);
        }

        return result;
    }
}