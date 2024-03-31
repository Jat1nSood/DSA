// Time Complexity of below code is O(n * m) + O(n * m) = 2(n * m)
// Space is O(n) + O(m)

public class optimized {

    void booleanMatrix(int matrix[][])
    {
       
        int n = matrix.length;
        int m = matrix[0].length;
       
        
        int row[] = new int[n];
        int col[] = new int[m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
            
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(row[i] == 1 || col[j] == 1){
                    
                    matrix[i][j] = 1;
                    
                }
            }
        }
        

    }
}
