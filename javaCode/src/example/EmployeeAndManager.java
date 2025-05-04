package example;

//Задача про 3 класса, главный смотрит и устанавливает чужую зарплату
public class EmployeeAndManager {

    //устанавливает и смотрит
    static class Employee {

        Manager manager;

        public Employee(Manager manager) {
            this.manager = manager;
        }


    }
    //только смотрит
    static class Manager {

        Intern intern;

        public Manager(Intern intern) {
            this.intern = intern;
        }
    }
    //не может даже посмотреть, не то, что установить зарплату
    static class Intern {
        private String name;
        private String position;
        private int wages;
    }


    static class AnyClass {
        protected int aProtected;
        private int aPrivate;
        public int aPublic;
    }
    static class AnyChild extends AnyClass{
        boolean thisChild;
    }


    public static void main(String[] args) {

        //Employee employee = new Employee(new Manager(new Intern()));




        AnyClass anyChild = new AnyClass();
        anyChild.aPrivate = 123;
        System.out.println(anyChild.aPrivate);

    }
}
