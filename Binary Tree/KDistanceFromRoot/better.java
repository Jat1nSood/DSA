public 
class Tree
{
     void helper(Node root, int k, int curr, ArrayList<Integer> ans){
         
         if(root == null)
            return;
        
        if(curr == k)
          {  ans.add(root.data);
            return;}
        
        helper(root.left, k, curr + 1, ans);
        helper(root.right, k, curr + 1, ans);
     }
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
        //   Queue<Node> q = new LinkedList<>();
          
        //   q.offer(root);
        //   q.offer(null);
        //   int size = 0;
          
          
        //   while(!q.isEmpty()){
              
        //       if(size == k){
        //           break;
        //       }
        //       Node top = q.poll();
              
        //       if(top == null){
        //           if(!q.isEmpty()){
        //               q.offer(null);
        //               size++;
        //           }
        //       }
        //       else{
        //           if(top.left != null)
        //             q.offer(top.left);
        //           if(top.right != null)
        //             q.offer(top.right);
        //       }
              
        //   }
          
          ArrayList<Integer> ans = new ArrayList<>();
          
          helper(root, k , 0, ans);
          return ans;
     }
}
