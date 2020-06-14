public class FactorialRecursive {

    public static void main (String[] args) {
        FactorialRecursive fact = new FactorialRecursive();
        System.out.println("Factorial of 15 is: " + fact.factorial(15));
    }

    private long factorial(long n) {
        if (n == 1)
            return 1;
        else
            return n*factorial(n-1);
    }

}