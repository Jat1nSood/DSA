

public class better {

    Node smallest(Node root, int n1, int n2){
        
        while(root != null){
            if(root.data > n1 && root. data > n2){
                root = root.left;
            }else if(root.data  < n2 && root.data < n1){
                root = root.right;
            }
            
            else break;
            
        }
        return root;
        
    }
    
    // Function to find the lowest common ancestor in a BST.
    Node LCA(Node root, int n1, int n2) {
        
        
        // Find paths from root to nodes n1 and n2
        return smallest(root, n1, n2);

    }
    
}
