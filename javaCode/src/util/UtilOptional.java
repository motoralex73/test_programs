package util;

import java.util.Optional;

public class UtilOptional {
    public static void main(String[] args) {
        Optional<String> noVal = Optional.empty();
        Optional<String> hasVal = Optional.of("ABCDEFG");
        if (noVal.isPresent()) System.out.println("Это не отобразистя");
        else System.out.println("noVal не имеет значения");
        if (hasVal.isPresent()) System.out.println("Строка hasVal : " + hasVal.get());
        String defString = noVal.orElse("Стандартная строка");
        System.out.println(defString);
    }
}
