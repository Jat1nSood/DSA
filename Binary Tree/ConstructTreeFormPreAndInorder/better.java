
class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }
        Node root = helper(0, n-1, inorder, 0, n-1, preorder, map);
        return root;
    }
    
    public static Node helper(int inStart, int inEnd, int[] inorder, int preStart, int preEnd, int[] preorder, Map<Integer, Integer> map){
        
        if(inStart > inEnd || preStart > preEnd)
            return null;
        
        Node root = new Node(preorder[preStart]);
        int index = get_pos(inStart, inEnd, inorder, root.data);
        int numEl = index - inStart;
        
        root.left = helper(inStart, index-1, inorder, preStart+1, preStart + numEl, preorder, map);
        root.right = helper(index+1, inEnd, inorder, preStart+numEl+1, preEnd, preorder, map);
        return root;
    }
    
    public static int get_pos(int inStart, int inEnd, int[] inorder, int val){
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}