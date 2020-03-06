package classify._5sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,0,1,8,-7,5,6,-2,3,4};
        new QuickSort().quickSort(arr,0,arr.length-1);
        BubbleSort.print(arr);
    }


    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            //调整数组, 并找到基准值的位置
            int mid = division(array,left,right);
            //对分别对左边和右边进行快速排序
            quickSort(array,left,mid-1);
            quickSort(array,mid+1,right);
        }

    }

    private int division(int[] array, int left, int right) {
        //以最左边的数为基准
        int base = array[left];
        while (left < right) {
            //从右边开始向左扫描,直到找到比base小的数
            while (left < right && array[right] >= base) {
                right--;
            }
            //找到了比base小的数, 将其放在left位置
            array[left] = array[right];
            //从左边开始向右扫描, 直到找到比base大的数
            while (left < right && array[left] <= base) {
                left++;
            }
            //找到了比base更大的数, 将其放在right位置
            array[right] = array[left];
        }
        //最后将base放在left位置, 分割结束
        //此时base左边的数都比base小, 右边的数都比它大
        array[left] = base;
        return left;
    }
}
