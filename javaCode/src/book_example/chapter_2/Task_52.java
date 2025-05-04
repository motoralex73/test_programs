package book_example.chapter_2;


import javax.swing.*;
import javax.xml.validation.Validator;
import java.util.Set;

//Предотвращение плохих данных в немутируемых объектах
public class Task_52 {

    //Использование аннотаций, например, для валидации полей класса
    //@NotNull @Size @Email

    public static void main(String[] args) {

        Task_51.User user;
//        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//        Task_51.User.UserBuilder userBuilder = new Task_51.User.UserBuilder("sergey","123")
//                .email("lol@mail.ru")
//                .firstName("lisaev")
//                .lastName("stepanovich");

        //final Set<ConstraintValidation<Task_51.User.UserBuilder>>  violations = validator.validate(userBuilder);
    }
}
