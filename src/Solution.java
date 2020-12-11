import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();

        int len = searchWord.length();
        for (int i = 1; i <= len; i++) { // i starts at 1 because substring function will exclude it
            String a = searchWord.substring(0,i); // Current substring
            ans.add(new ArrayList<>());
            int count = 3;
            for (String q:products) {
                if(q.length() >= i && a.equals(q.substring(0,i)) && count > 0) {
                    ans.get(i-1).add(q);
                    count--;
                }
            }
        }
        return ans;
    }
}