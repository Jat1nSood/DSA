class Solution {
    public static Node LCA(Node root, int x, int y){
     
        while(root != null){
            
            if(root.data < x & root.data < y){
                root = root.right;
                
            }
            
            else if(root.data > x && root.data > y){
                root = root.left;
            }
            
            else{
                break;
            }
        }
        
        return root;
    }
    
    public void findPath(Node root, Node target, ArrayList<Node> path){
        
        while(root != null){
            
            if(root.data < target.data){
                path.add(root);
                root = root.right;
                
            }
            
            else if(root.data > target.data){
                path.add(root);
                root = root.left;
            }
            
            else{
                path.add(root);
                break;
            }
        }
    }
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        
        ArrayList<Node> path = new ArrayList<>();
        
        Node target = LCA(root, x, y);
        
        findPath(root, target, path);
        
        if(path.size() - k < 0){
            return -1;
        }
        
        int size = path.size();
        
        return path.get(size - k).data;
        
    }
}
