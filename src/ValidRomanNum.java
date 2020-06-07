import java.util.Map;
import java.util.HashMap;

public class ValidRomanNum {

    public static void main(String[] args) {
        System.out.println("MMMCMXCIX: " + isValidRomanNum("MMMCMXCIX"));
        System.out.println("IXIII: " + isValidRomanNum("IXIII"));
        System.out.println("CMMM: " + isValidRomanNum("CMMM"));
        System.out.println("OKML: " + isValidRomanNum("OKML"));
        //System.out.println("MMMCMXCIX: " + isValidRomanNum("MMMCMXCIX"));
        //System.out.println("MMMCMXCIX: " + isValidRomanNum("MMMCMXCIX"));
        //System.out.println("MMMCMXCIX: " + isValidRomanNum("MMMCMXCIX"));
    }

    /*
    In order for a number written in Roman numerals to be considered valid there are three basic rules
    which must be followed.
    1) Numerals must be arranged in descending order of size.
    2) M, C, and X cannot be equalled or exceeded by smaller denominations.
    3) D, L, and V can each only appear once.
     */
    public static Boolean isValidRomanNum(String romanNum) {

        if (romanNum.isEmpty() || romanNum == null)
            return false;

        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("I", 1);
        hm.put("IV", 4);
        hm.put("V", 5);
        hm.put("IX", 9);
        hm.put("X", 10);
        hm.put("XL", 40);
        hm.put("L", 50);
        hm.put("XC", 90);
        hm.put("C", 100);
        hm.put("XD", 400);
        hm.put("D", 500);
        hm.put("CM", 900);
        hm.put("M", 1000);

        int len = romanNum.length() - 2;
        int lastVal = 0;

        for (int i = 0; i < len; i++) {

            try {
                if (hm.get(romanNum.substring(i, i+1)) < hm.get(romanNum.substring(i + 1, i+2))) {
                    if (!hm.containsKey(romanNum.substring(i, i + 1)))
                        return false;
                }
                for (int j = i+1; j < len; j++) {
                    if (hm.get(romanNum.substring(j, j+1)) <= hm.get(romanNum.substring(j + 1, j+2))
                    && (romanNum.substring(j + 1, j + 2) == "M" ||
                            romanNum.substring(j + 1, j + 2) == "C" ||
                            romanNum.substring(j + 1, j + 2) == "X"))
                        return false;
                }
            }
            catch (Exception ex) {
                return false;
            }
        }
        return true;
    }
}