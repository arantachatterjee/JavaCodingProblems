public class HanoiRecursive {

    public static String hanoi (int n, int frompeg, int topeg) {
        if(n == 1)
            return frompeg + " --> " + topeg + ";";
        else {
            String sol1, sol2, sol3;
            int helppeg = 6 - frompeg - topeg;

            sol1 = hanoi(n - 1, frompeg, helppeg);
            sol2 = frompeg + " --> " + topeg + ";";
            sol3 = hanoi(n - 1, helppeg, topeg);

            return sol1 + sol2 + sol3;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        String stepstosolution = hanoi(n, 1, 3);

        for (String step: stepstosolution.split(";")) {
            System.out.println(step);
        }
    }

}
