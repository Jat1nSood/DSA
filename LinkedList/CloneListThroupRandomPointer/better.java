class Clone {
    
    Node insertCopy(Node head){
        
        Node curr = head;
        while(curr != null){
            
            Node newN = new Node(curr.data);
            
            newN.next = curr.next;
            curr.next = newN;
            curr = curr.next.next;
        }
        return head;
    }
    
    Node randomConnection(Node head){
        
        Node curr = head;
        Node copy = curr.next;
        
        while(curr != null){
            if(curr.arb == null){
                copy.arb = null;
            }
            else{
                copy.arb = curr.arb.next;
                
            }
            curr = copy.next;
            if(curr != null)
                copy = curr.next;
        }
        return head;
    }
    
    void seprateCopyAndOrig(Node head, Node dummy){
        
        Node curr = head;
        Node copy = dummy;
        
        while(curr != null){
            copy.next = curr.next;
            copy = copy.next;
            curr.next = copy.next;
            curr = curr.next;
        }
    }
    //Function to clone a linked lst with next and random pointer.
    Node copyList(Node head) {
        
        // insert copy node in the liked list
        head = insertCopy(head);
        
        // Make rendom Pinter connection
        head = randomConnection(head);
        
        // Seprate copy and original
        Node dummy = new Node(-1);
        seprateCopyAndOrig(head, dummy);
        return dummy.next;
    }
}
