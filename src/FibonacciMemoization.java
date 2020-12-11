// Memoization (top down dynamic programming)
public class FibonacciMemoization {
    static int[] arr = new int[100];
    public static int fib (int n) {
        if (arr[n] == -1) {
           if (n == 1 || n == 0)
               return n;
           arr[n] = fib(n - 1) + fib(n - 2);
        }
        return arr[n];
    }

    public static void initializeArr() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }

    public static void main(String[] args) {
        initializeArr();
        System.out.println(fib(40));
    }
}