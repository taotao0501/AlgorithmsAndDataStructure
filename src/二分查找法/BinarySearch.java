package 二分查找法;

/**
 * 递归 + 普通的方法
 */
public class BinarySearch {
    // 循环不变量是 在 [l,r] 空间内二分查找
    public static int binarySearch1(int[] arr, int target){

        int l=0, r= arr.length -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] > target){
                l = mid + 1;
            }
            else{
               r=mid-1;
            }
        }
        return -1;
    }

    //递归实现
    public int binarySearch2(int[] arr, int target){
        return search(arr,0,arr.length-1,target);
    }
    private int search(int[] arr,int l, int r,int target){
        if(l>r)
            return -1;
        int mid=l+(r-1)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid] < target)
            return search(arr,mid+1,r,target);
        return search(arr,l,mid-1,target);
    }

}
