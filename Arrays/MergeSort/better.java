package MergeSort;

import java.util.ArrayList;

public class better {

        void merge(int arr[], int l, int mid, int r)
    {
         int i = l;
         int j = mid + 1;
         
         ArrayList<Integer> temp = new ArrayList<>();
         while(i <= mid  &&  j <= r){
             if(arr[i] <= arr[j]){
                 temp.add(arr[i]);
                 i += 1;
                 
             }
             else if (arr[j] <=  arr[i]){
                 temp.add(arr[j]);
                 j += 1;
                 
             }
         }
         
         while(i <= mid){
             temp.add(arr[i]);
             i += 1;
             
         }
         
         while(j <= r){
             temp.add(arr[j]);
             j += 1;
         }
         
         
         for (int k = l; k <= r; k++){
             arr[k] = temp.get(k - l);
         }
            
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l == r){
            return;
        }
        int mid = (l + r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    
}
