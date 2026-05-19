class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] adj = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j =0; j< n; j++){
                adj[i][j] = 0;
            }
        }

        int cnt = 0;

        for(int i = 0; i < m; i++){
            for(int j =0; j< n; j++){
                if(grid[i][j] == '1' && adj[i][j] != 1){
                    cnt++;
                    dfs(i, j, grid, adj);
                }
            }
        }
        return cnt;
    }

    private void dfs(int i, int j, char[][] grid, int[][] adj){
        if(i < 0 || j < 0 || i>=m || j>=n || grid[i][j] != '1' || adj[i][j] == 1) return;

        adj[i][j] = 1;

        dfs(i+1,j,grid,adj);
        dfs(i-1,j,grid,adj);
        dfs(i,j+1,grid,adj);
        dfs(i,j-1,grid,adj);
    }
}
