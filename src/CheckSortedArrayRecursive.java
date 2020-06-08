public class CheckSortedArrayRecursive {

    public static void main (String[] args) {
        int arr[] = {1,2,3,4,5,6,0};
        System.out.println("Is array sorted? :\n" + checkSortedArr(arr, arr.length));
    }

    private static boolean checkSortedArr(int[] arr, int n) {
        if (arr.length == 1 || n == 1) {
            return true;
        } else {
            return (arr[n - 1] < arr[n - 2] ? false : checkSortedArr(arr, n - 1));
        }
    }

}