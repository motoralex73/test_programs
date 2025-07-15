package java_lang;

public class LangCharacter {


    public static void main(String[] args) {
        Character character = '&';
        System.out.println("charValue = " + character.charValue());
        char[] a = {'a', 'b', '5', '?', 'A', ' '};
        //for (int i = 0; i < a.length; i++) {
        for (char aa : a) {
            if (Character.isDigit(aa)) System.out.println(aa + " - цифра");
            if (Character.isLetter(aa)) System.out.println(aa + " - буква");
            if (Character.isWhitespace(aa)) System.out.println(aa + "' ' - пробел");
            if (Character.isUpperCase(aa)) System.out.println(aa + " - верхний регистр");
            if (Character.isLowerCase(aa)) System.out.println(aa + " - нижний регистр");
        }
        System.out.println("Количество char в переменной = " + Character.charCount(character));

    }
}
