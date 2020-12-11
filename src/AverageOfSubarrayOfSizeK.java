import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

    public static double[] getAvgOfSubarraysSizeK(int k, int[] arr) {
        int len = arr.length;
        double sum = 0;
        int j = 0;
        double[] result = new double[len - k + 1];

        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                result[j] = sum / k;
                sum -= arr[j];
                j++;
            }
        }

        return result;
    }

    public static void main (String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        double[] res = getAvgOfSubarraysSizeK(5, arr);
        System.out.println(Arrays.toString(res));
    }

}