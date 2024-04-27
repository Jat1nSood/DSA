class Solution {
    
    static Node split(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
    
    
    static Node merge(Node h1, Node h2){
        
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        while(h1 != null && h2 != null){
            
            if(h1.data < h2.data){
                curr.next = h1;
                h1.prev = curr;
                h1 = h1.next;
               
            }
            
            else{
                
                curr.next = h2;
                h2.prev = curr;
                h2 = h2.next;
                
            }
            curr = curr.next;
        }
        
        while(h1 != null){
            curr.next = h1;
             h1.prev = curr;
            h1 = h1.next;
            curr = curr.next;
        }
        while(h2 != null){
            curr.next = h2;
            h2.prev = curr;
            h2 = h2.next;
            curr = curr.next;
        }
        
        Node ans = dummy.next;
        ans.prev = null;
        return ans;
    }
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node h1) {
        
        if(h1 == null || h1.next == null)
            return h1;
        Node h2 = split(h1);
        h1 = sortDoubly(h1);
        h2 = sortDoubly(h2);
        
       return  merge(h1, h2);
    }
}