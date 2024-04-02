class better{

    int atoi(String s) {
        int sign = 1;
        int ans = 0;
        if(s.charAt(0) == '-'){
            sign *= -1;
            
            for(int i = 1; i < s.length(); i++){
                char ch = s.charAt(i);
                if(ch < '0' || ch > '9'){
                    return -1;
                }
                ans = ans * 10 + (ch - '0');
                
            }
            
            return ans * sign;
            
        }
         for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(ch < '0' || ch > '9'){
                    return -1;
                }
                ans = ans * 10 + (ch - '0');
                
            }
            
            return ans * sign;
        
        
    }
    
}