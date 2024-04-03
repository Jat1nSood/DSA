
public class brute {

       // Helper function to find the path from root to target node
       void inorder(Node root, int target, ArrayList<Node> path) {
        if (root == null) return;
        
        path.add(root);
        if (root.data == target) return;
        
        if (root.data < target) {
            inorder(root.right, target, path);
        } else {
            inorder(root.left, target, path);
        }
    }

    // Function to find the lowest common ancestor in a BST.
    Node LCA(Node root, int n1, int n2) {
        
        
        
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        
        inorder(root, n2, path1);
        inorder(root, n2, path2);
        
        // Find the length of the shorter path
        int len = Math.min(path1.size(), path2.size());
        
        for(int i = 0; i < len; i++){
            if(path1.get(i).data != path2.get(i).data){
                return path1.get(i - 1);
            }
        }
        
        return len == path1.size() ? path1.get(len - 1) : path2.get(len - 1);
    }
    
}
