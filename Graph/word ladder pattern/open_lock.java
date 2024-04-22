class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for (String str : deadends) {
            set.add(str);
        }

        String start = "0000";
        if (set.contains(start))
            return -1;

        Queue<String> q = new LinkedList<>();
        q.offer(start);

        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            while (n != 0) {
                String curr = q.poll();

                if (curr.equals(target))
                    return level;

                StringBuilder currBuilder = new StringBuilder(curr);
                findNeighbour(q, currBuilder, set);
                n--;
            }
            level++;

        }

        return -1;
    }

    void findNeighbour(Queue<String> q, StringBuilder curr, HashSet<String> set) {

        for (int i = 0; i < 4; i++) {
            char ch = curr.charAt(i);

            char dec = ch == '0' ? '9' : (char) (ch - 1);
            curr.setCharAt(i, dec);
            String modified = curr.toString();
            if (!set.contains(modified)) {
                q.offer(modified);
                set.add(modified);
            }

            char inc = ch == '9' ? '0' : (char) (ch + 1);
            curr.setCharAt(i, inc);
            String modified2 = curr.toString();
            if (!set.contains(modified2)) {
                q.offer(modified2);
                set.add(modified2);
            }

            curr.setCharAt(i, ch);
        }
    }
}