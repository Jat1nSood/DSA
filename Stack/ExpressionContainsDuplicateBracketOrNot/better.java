
class Solution {
    public static int checkRedundancy(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            
            // closing
            if(ch == ')') {
                int counter = 0;
                while(st.peek() != '(') {
                    st.pop();
                    counter++;
                }
                if(counter <= 1) {
                    return 1;
                }
                else {
                    st.pop();
                }
            }
            else {
                st.push(ch);
            }
        }
        return 0;
        
    }
}
        