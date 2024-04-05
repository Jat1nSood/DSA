class Pair {
    int first;
    int second;
    int third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
        }
    }
    


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	
    
    public int minimumCostPath(int[][] grid)
    {
       
        
        int n = grid.length;
        int [][] cost = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = (int) 1e9; 
            }
        }
        cost[0][0] = grid[0][0];
        
        PriorityQueue<Pair> q=new PriorityQueue<Pair>((a,b)->a.third-b.third);
        
        q.add(new Pair(0, 0, grid[0][0]));
        
        int[] delRow = {0, 1, -1, 0};
        int[] delCol = {1, 0, 0, -1};
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int i = pair.first;
            int j = pair.second;
            int wgt = pair.third;
            
            for (int k = 0; k < 4; k++){
                
                int nRow = i + delRow[k];
                int nCol = j + delCol[k];
                
                 if(nRow >= 0 && nCol >= 0 && nRow < n && nCol  < n){
                    int adjWgt = grid[nRow][nCol];
                    if (cost[nRow][nCol] > wgt + adjWgt) {
                        cost[nRow][nCol] = wgt + adjWgt;
                        q.add(new Pair(nRow, nCol, cost[nRow][nCol]));
                    }
                    
                }
            }
            
            
            
        }
        
        
        return cost[n-1][n-1];
    
        
        
    }
}