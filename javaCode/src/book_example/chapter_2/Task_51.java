package book_example.chapter_2;

import java.util.Date;

//Написание немутируемого класса с помощью шаблона строителя
public class Task_51 {

    public static final class User {
        private final String login;
        private final String password;
        private final String firstname;
        private final String lastname;
        private final String email;
        private final Date created;

        public User(UserBuilder builder) {
            this.login = builder.login;
            this.password = builder.password;
            this.firstname = builder.firstname;
            this.lastname = builder.lastname;
            this.email = builder.email;
            this.created = builder.created;
        }

        public static UserBuilder getBuilder(String login, String password) {
            return new User.UserBuilder(login,password);
        }

        public static final class UserBuilder {
            private final String login;
            private final String password;
            private String firstname;
            private String lastname;
            private String email;
            private final Date created;

            public UserBuilder(String login, String password) {
                this.login = login;
                this.password = password;
                this.created = new Date();
            }

            public UserBuilder firstName(String firstname) {
                this.firstname = firstname;
                return this;
            }

            public UserBuilder lastName(String lastname) {
                this.lastname = lastname;
                return this;
            }

            public UserBuilder email(String email) {
                this.email = email;
                return this;
            }

            public User build() {
                return new User(this);
            }

            public Date getCreated() {
                return new Date(created.getTime());
            }

            public String getEmail() {
                return email;
            }

            public String getLastname() {
                return lastname;
            }

            public String getFirstname() {
                return firstname;
            }

            public String getPassword() {
                return password;
            }

            public String getLogin() {
                return login;
            }
        }
    }

    public static void main(String[] args) {

        //User login/password
        User user1 = User.getBuilder("alex", "123").build();

        //User login/password/email
        User user2 = User.getBuilder("alex","12345").email("motor@mail.ru").build();

        //User login/password/email/firstname/lastname
        User user3 = User.getBuilder("alex", "1234567")
                .email("motor@mail.ru")
                .firstName("pupkin")
                .lastName("sergeevich")
                .build();
    }
}
