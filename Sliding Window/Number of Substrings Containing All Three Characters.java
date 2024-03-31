class Solution {
    public int numberOfSubstrings(String s) {

        int[] lastSeen = new int[s.length()];
        Arrays.fill(lastSeen, -1);
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a')
                lastSeen[0] = i;
            if (c == 'b')
                lastSeen[1] = i;
            if (c == 'c')
                lastSeen[2] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                res += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
        }

        return res;
    }
}