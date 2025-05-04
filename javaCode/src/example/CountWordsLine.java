package example;

//Посчитать количество слов в строке
public class CountWordsLine {

    static int calcCountWords(String str) {

        String clearString = str.replaceAll("[\\p{Punct}]", "");
        String[] words = clearString.trim().split("\\s+");
        int count = words.length;
        return count;
    }

    public static void main(String[] args) {

        String str1 = "Привет  , , , , как твои дела?";
        String str2 = "Я упал из-за тебя!";
        System.out.println(str1 + " count words = " + calcCountWords(str1));
        System.out.println(str2 + " count words = " + calcCountWords(str2));
    }
}
