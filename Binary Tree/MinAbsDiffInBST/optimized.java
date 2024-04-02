

public class optimized {
    int ans = Integer.MAX_VALUE;
    int prevMax = -1;
    int absolute_diff(Node root)
    {
        
        inorder(root);
        return ans;

    }
    
    void inorder(Node root){
        if (root == null) return;
        
        inorder(root.left);
        if(prevMax != -1 ){
            ans = Math.min(ans, root.data - prevMax);
        }
        prevMax = root.data;
        inorder(root.right);
    }
    
}
