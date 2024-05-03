class Solution {
    public int compareVersion(String version1, String version2) {
        List<String> v1 = getToken(version1);
        List<String> v2 = getToken(version2);

        int i = v1.size();
        int j = v2.size();

        int k = 0;

        while (k < i || k < j) {
            int a = k < v1.size() ? Integer.parseInt(v1.get(k)) : 0;
            int b = k < v2.size() ? Integer.parseInt(v2.get(k)) : 0;

            if (a < b)
                return -1;
            if (a > b)
                return 1;
            else
                k++;
        }

        return 0;
    }

    public List<String> getToken(String str) {
        String[] token = str.split("\\.");

        List<String> list = new ArrayList<>();
        for (String tok : token) {
            list.add(tok);
        }

        return list;
    }
}