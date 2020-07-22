public class MagicIndexRecursive {

    public static void main (String args[]) {
        int[] arr = {-9, 0, 1, 3, 6, 7, 10, 65};
        System.out.println(magicIndex(arr));
    }

    public static int magicIndex (int[] arr) {
        return magicIndex(arr, 0, arr.length - 1);
    }

    public static int magicIndex (int[] arr, int start, int end) {

        if (end < start)
            return -1;

        int mid = (start + end) /2;

        if (arr[mid] == mid)
            return mid;
        else if (arr[mid] > mid)
            return magicIndex (arr, start, mid - 1);
        else
            return magicIndex (arr, mid + 1, end);
    }
}
