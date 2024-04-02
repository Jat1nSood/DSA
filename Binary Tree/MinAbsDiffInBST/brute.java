class brute{
    int absolute_diff(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < ans.size(); i++){
            int diff = ans.get(i) - ans.get(i - 1);
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }
    
    void inorder(Node root, ArrayList<Integer> ans){
        if (root == null) return;
        
        inorder (root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
}