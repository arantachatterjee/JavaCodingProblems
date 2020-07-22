import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

public class ReorderLogFiles {

    private class logComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public String[] reorderLogFiles(String[] logs) {

        Map<String, String> strLogs = new HashMap<String, String>();
        LinkedList<String> strContent = new LinkedList<>();
        LinkedList<String> digitLogs = new LinkedList<>();

        for (String log : logs) {
            String id = log.substring(0, log.indexOf(' '));
            String content = log.substring(log.indexOf(' ') + 1);

            if (content.length() > 0) {
                Pattern p = Pattern.compile("^[ A-Za-z]+$");
                Matcher m = p.matcher(content);
                if (m.matches())
                    strLogs.put(id, content);
                else
                    digitLogs.add(log);
            }
        }

        for (Map.Entry<String, String> entry : strLogs.entrySet()) {
            strContent.add(entry.getValue());
        }
        //Sort content
        Collections.sort(strContent, new logComparator());
        //Update strLogs
        for (String str : strContent) {
            for (Entry<String, String> entry : strLogs.entrySet()) {
                if (entry.getValue().equals(str)) {
                    strLogs.put(entry.getKey(), str);
                }
            }
        }

        //Merge string and digit logs
        String[] output = new String[strLogs.size() + digitLogs.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : strLogs.entrySet())
            output[i] = entry.getKey() + ' ' + entry.getValue();
        for (String log : digitLogs)
            output[i] = log;

        return output;
    }
}
