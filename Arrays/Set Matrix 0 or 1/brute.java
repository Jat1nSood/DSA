// Time cmplexity of below code is
// O(n * m) + (n + m)
//  Space Comp  is O(n * m)

public class brute{
    void modifyRowCol(int i, int j, int ans[][], int n, int m){
        
        for(int row = 0; row < n; row++){
            
            ans[row][j] = 1;
        }
        
        for(int col = 0; col < m; col++){
            ans[i][col] = 1;
        }
        
    }
    void booleanMatrix(int matrix[][])
    {
       
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[][] = new int[n][m];
        
        // Making New ans array
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = matrix[i][j];
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                if(matrix[i][j] == 1){
                    modifyRowCol(i, j, ans, n, m);
                }
            }
        }
        
        //copying back ans to matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = ans[i][j];
            }
        }
        
    }
}