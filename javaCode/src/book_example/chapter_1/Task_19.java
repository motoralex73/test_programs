package book_example.chapter_1;

//Объявление многострочных строковых литералов (или текстовых блоков)
public class Task_19 {

    public static void main(String[] args) {
        CharSequence charSequence = new StringBuilder();
        String text = String .join ( charSequence,
                "Моя школа , Иллинойская Академия , ",
                "математики и естественных наук , показала мне , что , ",
                "в этом мире все может быть и что никогда ",
                " не слишком рано начинать мыслить масштабно . " ) ;
        System.out.println(text);
    }
}
