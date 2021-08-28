package 二分查找法;

/**
 * 换个定义实现二分查找法
 */

public class BinarySearch2 {
    //在 [l,r)中查找 target
    public int search(int[] arr, int target){
        int l=0, r=arr.length;

        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] < target)
                l = mid+1; //继续在[mid+1,r)里面寻找解
            else
                r=mid; //继续在 [l,mid)范围里寻找解
        }
        return -1;
    }
}
