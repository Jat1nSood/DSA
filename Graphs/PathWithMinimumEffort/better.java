

class Solution {
  
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        
        int[][] vis = new int[rows][columns];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        pq.offer(new int[]{0, 0, 0});
        
        while(!pq.isEmpty()){
            
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int effort = current[2];
            
            if(row == rows - 1 && col == columns - 1){
                return effort;
            }
            vis[row][col] = 1;
            
            for(int i = 0; i < 4; i++){
            
                int nRow = row +  delRow[i];
                int nCol = col + delCol[i];
                if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < columns && vis[nRow][nCol] == 0){
                    
                    int currEff = Math.abs(heights[row][col] - heights[nRow][nCol]);
                    int maxDiff = Math.max(effort, currEff);
                    pq.offer(new int[]{nRow, nCol, maxDiff});
                    
                }
            }
        }
        return -1;
    }
}
