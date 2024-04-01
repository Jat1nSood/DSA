package FirstAndLastOccurenceOfX;

import java.util.*;
public class optimised { ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer>ans = new ArrayList<>();
        if(arr[0] == x && arr[n-1] == x){
            ans.add(0);
            ans.add(n-1);
            return ans;
        }
        
        
        int left = 0;
        int right = n - 1;
        int firstFound = -1;
        int lastFound = -1;
        
        while(left <= right){
            int mid = (right + left)/2;
            
            if(arr[mid] == x){
                int origi = mid;
                while(arr[mid] == x && mid >= left){
                    firstFound = mid;
                    if(mid - 1 >= 0) mid -= 1;
                    else break;
                }
                mid = origi;
                while(arr[mid] == x && mid <= right){
                    lastFound = mid;
                    if(mid + 1 <= n-1) mid += 1;
                    else break;
                }
                break;
            }else if(arr[mid] < x){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        if(firstFound != -1 && lastFound != -1){
            ans.add(firstFound);
            ans.add(lastFound);
            return ans;
        }
        
        ans.add(firstFound);
        ans.add(firstFound);
        return ans;

    }

    
}
