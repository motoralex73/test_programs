package book_example.chapter_1;

//Инвертирование букв и слов (в предложении)
public class Task_3 {

    //инвертирование букв (только в словах)
    public static String invertLetters(String input) {
        StringBuilder result = new StringBuilder();
        int wordStartIndex = -1;

        for (int i = 0; i <= input.length(); i++) {
            char temp = ' ';
            if (i < input.length()) temp = input.charAt(i);

            //true - если символ temp не является буквой
            if (!Character.isLetter(temp)) {
                if (wordStartIndex != -1) {
                    StringBuilder word = new StringBuilder(input.substring(wordStartIndex, i));
                    result.append(word.reverse());
                    wordStartIndex = -1;
                }
                result.append(temp);
            } else {
                if (wordStartIndex == -1) wordStartIndex = i;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String str = "Привет, я строка для инвертирования";
        System.out.println("Инвертирование букв: " + invertLetters(str));
        //интвертирование слов (в предложении)
        System.out.println("Инвертирование слов: " + new StringBuilder(invertLetters(str)).reverse());
    }
}
