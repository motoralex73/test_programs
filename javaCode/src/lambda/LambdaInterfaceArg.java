package lambda;

public class LambdaInterfaceArg {

    //Функциональный интерфейс
    interface StringFuncInterface {
        String func(String n);
    }

    //Фунция принимает на вход функциональный интерфейс
    static String stringReturn(StringFuncInterface sfi, String string) {
        return sfi.func(string);
    }

    public static void main(String[] args) {
        String inStr = "Lambda lesson Java";
        //1
        String outStr = stringReturn(str -> str.toUpperCase(), inStr);
        System.out.println(outStr);
        //2
        outStr = stringReturn(str -> {
            StringBuilder result = new StringBuilder();
            for (int i=0; i<str.length();i++)
                if (str.charAt(i) != ' ') result.append(str.charAt(i));
            return result.toString();
        }, inStr);
        System.out.println(outStr);
        //3
        outStr = stringReturn(str -> {
            StringBuilder result = new StringBuilder();
            for (int i = str.length()-1; i >= 0; i--) {
                result.append(str.charAt(i));
            }
            return result.toString();
        }, inStr);
        System.out.println(outStr);
        //4
        StringFuncInterface stringFuncInterface = str -> {
            if (str.contains("Java")) return "Java";
            return "string";
        };
        System.out.println(stringReturn(stringFuncInterface, inStr));





    }
}
