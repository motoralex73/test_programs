package util;

import java.util.Currency;
import java.util.Locale;

public class UtilCurrency {
    public static void main(String[] args) {
        Currency c = Currency.getInstance(Locale.CHINA);
        System.out.println("Символ: " + c.getSymbol());
        System.out.println("Количество цифр после запятой: " + c.getDefaultFractionDigits());
    }
}
