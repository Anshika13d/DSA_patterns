class Solution {

    //dfs approach
    int ans = 0;

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int[] delR = { 1, 0, -1, 0 };
        int[] delC = { 0, 1, 0, -1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    dfs(grid, i, j, vis, delR, delC);
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] grid, int r, int c, int[][] vis, int[] delR, int[] delC) {
        vis[r][c] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < delR.length; i++) {
            int nR = delR[i] + r;
            int nC = delC[i] + c;

            if (nR < 0 || nR >= n || nC < 0 || nC >= m) {
                ans++;
                System.out.println(ans);
            }

            if (nR >= 0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == 0) {

                ans++;
                System.out.println(ans);
            }

            if (nR >= 0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == 1 && vis[nR][nC] != 1) {
                dfs(grid, nR, nC, vis, delR, delC);
            }
        }
    }
}
