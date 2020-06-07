public class SinusoidalString {
    public static void main(String[] args) {
        System.out.println("Input: Hello World!");
        System.out.println("Snake String: " + GetSnakeString("Hello World!"));

    }

    public static String GetSnakeString(String input) {
        StringBuilder result = new StringBuilder();

        System.out.print("   ");
        //Line 1
        for (int i = 1; i < input.length(); i+=4) {
            System.out.print(input.charAt(i) + "           ");
            result.append(input.charAt(i));
        }

        System.out.println();
        //Line 2
        for (int i = 0; i < input.length(); i+=2) {
            System.out.print(input.charAt(i) + "     ");
            result.append(input.charAt(i));
        }

        System.out.println();
        System.out.print("         ");
        //Line 3
        for (int i = 3; i < input.length(); i+=4) {
            System.out.print(input.charAt(i) + "            ");
            result.append(input.charAt(i));
        }

        System.out.println();
        return result.toString();
    }
}
