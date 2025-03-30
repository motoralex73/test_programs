
public class FindDuplicateSymbols {

    private static String searchDuplicate(String inputString) {
        StringBuilder outputString = new StringBuilder();
        char temp = '\0';
        for (char a : inputString.toCharArray()) {
            if (a != temp) outputString.append(a);
            temp = a;
        }
        return outputString.toString();
    }

    public static void main(String[] args) {
        String inputString = "Пррривет, люббббители яззыка Jaava";
        System.out.println(inputString);
        String outputString = searchDuplicate(inputString);
        System.out.println(outputString);
    }

}
