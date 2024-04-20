class Solution {

    public boolean isSafe(int row, int col, int[][] vis, int[][] land){
        
        int n = land.length;
        int m = land[0].length;

        if(row < n && col < m){
            if(vis[row][col] == 0 && land[row][col] == 1){
                return true;
            }
        }
        return false;
    }

    public void dfs(int row, int col, int[][] vis, int[][] land, ArrayList<Integer> list){

       
        int[] dRow = {1, 0};
        int[] dCol = {0, 1};

        if(list.isEmpty()){
            list.add(row);
            list.add(col);
        }
        vis[row][col] = 1;

        for(int i = 0; i < 2; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if(isSafe(nRow, nCol, vis, land)){
                dfs(nRow, nCol, vis, land, list);
            }
        }

        if(list.size() == 4){
            list.set(2, Math.max(list.get(2), row));
            list.set(3, Math.max(list.get(3), col));
        }
        else{
            list.add(row);
            list.add(col);
        }
        


    }
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[][] vis = new int [n][m];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0;i <n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && land[i][j] == 1){
                    ArrayList<Integer> list = new ArrayList<>();
                    dfs(i, j, vis, land, list);
                   ans.add(list);
                }
            }
        }

        int[][] ans2 = new int [ans.size()][4];

        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < 4; j++){
                ans2[i][j] = ans.get(i).get(j);
            }
        }

        return ans2;
    }
}