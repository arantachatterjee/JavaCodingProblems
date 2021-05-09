import java.util.Arrays;

public class QuickSort {
    /* This function takes last element as pivot, places the
        pivot element at its correct position, places smaller
        elements (smaller than pivot) to left of pivot and all
        greater elements to right of pivot */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    // The main function that implements QuickSort()
    void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is the partitioning index, arr[pi] is now at the right place */
            int pivot = partition(arr, low, high);
            // Recursively sort elements before partition and after partition
            sort(arr, low, pivot-1);
            sort(arr, pivot+1, high);
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("sorted array" + Arrays.toString(arr));
    }
}