public class FactorialRecursive {

    public static void main (String[] args) {
        FactorialRecursive fact = new FactorialRecursive();
        // range of long values is -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        // -2^31 to 2^31 - 1 (32 bits)
        // beyond n = 39, the result cannot be stored as a long value
        System.out.println("Factorial of 39 is: " + fact.factorial(39));
    }

    private long factorial(long n) {
        if (n == 1)
            return 1;
        else
            return n*factorial(n-1);
    }

}