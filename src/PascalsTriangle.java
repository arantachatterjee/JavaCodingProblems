import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

        public static void main (String[] args) {
            List<List<Integer>> list = generate(10);
            int len1 = list.size();
            for (int i = 0; i < len1; i++) {
                System.out.println(list.get(i));
            }
        }

        public static List<List<Integer>> generate(int numRows) {
            if (numRows == 0)
                return null;

            List<List<Integer>> ll = new ArrayList<>();

            List<Integer> firstList = new ArrayList<Integer>();
            firstList.add(1);
            //initialize linked list with first row
            ll.add(firstList);

            if (numRows == 1)
                return ll;

            //initialize linked list with second row
            List<Integer> secondList = new ArrayList<>();
            secondList.add(1); secondList.add(1);
            ll.add(secondList);

            if(numRows == 2)
                return ll;

            for (int i = 2; i < numRows; i++) {
                List<Integer> newList = new ArrayList<>();
                newList.add(1);
                for(int j = 0; j < i - 1; j++) {
                    newList.add(ll.get(i - 1).get(j) + ll.get(i - 1).get(j + 1));
                }
                newList.add(1);
                ll.add(newList);
            }

            return ll;
        }
}
