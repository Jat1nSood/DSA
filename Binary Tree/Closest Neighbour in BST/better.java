

class Node
{
    int key;
    Node left, right;

    Node(int x)
    {
        key = x;
        left = right = null;
    }

}
public class better {
    static void helper(Node root, int[] minDiff, int[] element, int n){
        
        if(root == null){
            return;
        }
        
        int diff = Math.abs(root.key - n);
        if(diff < minDiff[0] && root.key <= n){
            minDiff[0] = diff;
            element[0] = root.key;
        }
        
        helper(root.left, minDiff, element, n);
        helper(root.right, minDiff, element, n);
    }
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        
        int [] minDiff = {n};
        int[] element = {-1};
        
        helper(root, minDiff, element, n);
        return element[0];
        
    }
    
}
