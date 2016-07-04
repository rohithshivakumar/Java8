package Arrays;

import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

 You are given a target value to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Input : [4 5 6 7 0 1 2] and target = 4
 Output : 0

 The below code handles duplicates
 */
public class SearchRotatedArray {

    public int RotatedArratSearch(final List<Integer> arr, int b, boolean recursive) {
        if(arr == null || arr.size() ==0 ){
            return -1;
        }
        int low = 0;
        int high = arr.size()-1;
        Integer[] a = arr.toArray(new Integer[arr.size()]);
        return recursive ? RotatedArrSortedSearchR(a, low, high, b): RotatedArrSortedSearchItr(low, high, b, a);

    }

    private int RotatedArrSortedSearchItr(int low, int high, int key, Integer[] a) {


        int dupIndex = -1;
        while(low <= high){
            int mid = (int) ((low + high)/2);
            //System.out.format("low = %d , high =%d ,mid = %d : ", low, high ,mid);
            if(a[mid] == key){
                return mid;
            }

            if(a[low] < a[mid]){
                //left side is sorted
               if(a[low] <= key && key < a[mid]){
                   //search left
                  high = mid -1;
                  continue;
               }else {
                  low = mid +1;
                  continue;
               }
            }else if (a[mid] < a[high]){
                //right side is sorted
                if(a[mid] < key && key <= a[high] ){
                    low = mid + 1;
                    continue;
                }else {
                    high = mid -1;
                    continue;
                }
            }else if(a[low] == a[mid]){
                if(a[mid] !=  a[high]){
                    low = mid +1;
                    continue;
                }
                //Duplicates both sides
                dupIndex = mid;
            }

        }

        if(dupIndex > -1){
            //Search left and then search right
            int left = dupIndex -1;
            while(left >=0){
                if(a[left] == key) return left;
                left--;
            }

            int right = dupIndex;
            while (right < a.length){
                if(a[right] == key) return right;
                right++;
            }
        }

        return -1;
    }

    public int RotatedArrSortedSearchR(final Integer[] a , int low , int high, int key){


        int mid = (int) ((low + high)/2);
        if(a[mid] == key )return mid;
        if(low > high )return -1;

        if(a[low] < a[mid]){
            //left side is sorted
            if(a[low] <= key && key < a[mid]){
                //search left
                return RotatedArrSortedSearchR(a, low, mid-1, key);
            }else {
                return RotatedArrSortedSearchR(a, mid +1, high, key);
            }
        }else if(a[mid] < a[high]){
            //right side is sorted
            if(a[mid] < key && key <= a[high] ){
                return RotatedArrSortedSearchR(a , mid + 1, high , key);
            }else {
                return  RotatedArrSortedSearchR(a, low, mid-1, key);
            }
        }else if(a[low] == a[mid]){
            if(a[mid] !=  a[high]){
                return RotatedArrSortedSearchR(a, mid +1 ,high ,key );
            }
            int result = RotatedArrSortedSearchR(a, low, mid-1, key);
            if(result == -1){
                RotatedArrSortedSearchR(a, low + 1, high, key);
            }else{
                return result;
            }
        }
        return -1;
    }


}
