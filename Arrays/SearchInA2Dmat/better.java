class Sol
{
    public static int matSearch(int mat[][], int n, int m, int x)
    {
        int i =0; int j = m - 1;
        while(i < n && j >= 0 ){
            if(mat[i][j] == x){
                return 1;
            }
            else if(mat[i][j] < x){
                i++;
            }
            else{
                j--;
            }
        }
        return 0;
    }
}