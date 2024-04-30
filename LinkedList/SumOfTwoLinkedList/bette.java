
// reverse kardenge 
// n1 + n2 + carry krdenge

class Solution{
    //Function to add two numbers represented by linked list.
    
    static Node reverse(Node head){
        
        Node prev = null;
        Node curr = head;
        Node next = head;
    
        while(curr != null){
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        num1 = reverse(num1);
        num2 = reverse(num2);
        int carry = 0;
        Node ans = new Node(0);
        Node first = ans;
        
        while(num1 != null  || num2 != null || carry != 0){
            int sum = carry;
            
            if(num1 != null){
                sum += num1.data;
                num1 = num1.next;
            }
            if(num2 != null){
                sum += num2.data;
                num2 = num2.next;
            }
            ans.data = sum % 10;
            carry = sum / 10;
            
            if(num1 != null || num2 != null || carry != 0){
                ans.next = new Node(0);
                ans = ans.next;
            }
        }
        ans = reverse(first);
        while(ans.next != null && ans.data == 0){
            ans = ans.next;
        }
    return ans;
    }
}