import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SearchFirstNotDuplicateSymbol {

    public static Character returnFirstSymbol(String s) {
        Character result = null;
        Map<Character, Integer> mapCount = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mapCount.containsKey(s.charAt(i))) {
                mapCount.put(s.charAt(i), mapCount.get(s.charAt(i)) + 1);
            }
            else mapCount.put(s.charAt(i), 1);
        }

        for (Map.Entry<Character, Integer> entry : mapCount.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "summer time sadness";
        System.out.println(str);
        System.out.println("result first symbol = "+returnFirstSymbol(str));
    }
}
