
public class brute{
    static int k;
    public static int pairsViolatingBST(int n, Node root) {
        int[] arr = new int[n];
        k = 0;
        inorder(root, arr);
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
                
            }
        }
        
        return count;
    }
    
    
    static void inorder(Node root, int[] arr){
        
        if(root == null){
            return;
        }
        
        inorder(root.left, arr);
        arr[k++] = root.data;
        inorder(root.right, arr);
    }
}