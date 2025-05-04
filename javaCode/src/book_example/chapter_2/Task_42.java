package book_example.chapter_2;

import java.util.function.Supplier;

//Проверка ссылок на null и выбрасывание заданного исключения
public class Task_42 {

    public static <T, X extends Throwable> T requireNonNullElseThrow(T obj, X exception) throws X {
        if (obj == null) throw exception;
        return obj;
    }

    public static <T, X extends Throwable> T requireNotNullElseThrow(T obj, Supplier<? extends X> exceptionSupplier) throws X {
        if (obj != null) return obj;
        else throw exceptionSupplier.get();
    }

    public static void main(String[] args) throws IllegalAccessException {

        String name;
        name = null;
        if (name == null) {
            throw new IllegalAccessException("Имя не может быть равное null");
        }
    }
}
