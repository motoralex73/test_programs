package sobes_tasks;

import java.util.ArrayList;
import java.util.Collections;

//Вычислить средний возраст N-лучших студентов. В age, avg могут прийти невалидные строки.
public class Shortcat_task_2 {

    public static class Student {
        private String name;
        private String age;
        private String avg;

        public Student(String name, String age, String avg) {
            this.name = name;
            this.age = age;
            this.avg = avg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAvg() {
            return avg;
        }

        public void setAvg(String avg) {
            this.avg = avg;
        }

        @Override
        public String toString() {
            return "Name=" + name + ", age=" + age + ", avg=" + avg;
        }
    }

    public static ArrayList<Student> sortedStudentToAvg(ArrayList<Student> students) {
        Collections.sort(students, (s1, s2) -> Double.compare(Double.parseDouble(s2.getAvg()), Double.parseDouble(s1.getAvg())));
        return students;
    }

    public static Double middleAgeOfSomeStudents(ArrayList<Student> students, int countStudent) {
        double middleAge = 0.0;
        var list = sortedStudentToAvg(students);

        for (int i = 0; i < countStudent; i++) {
            middleAge+=Double.parseDouble(list.get(i).getAge());
        }
        middleAge /= countStudent;
        return middleAge;
    }

    public static void main(String[] args) {
        var list = new ArrayList<Student>();
        list.add(new Student("Alex", "35", "3.9"));
        list.add(new Student("Sergey", "45", "3.4"));
        list.add(new Student("Mike", "32", "4.1"));
        list.add(new Student("Kirill", "29", "3.5"));
        list.add(new Student("Dasha", "33", "4.2"));

        list = sortedStudentToAvg(list);
        System.out.println(list);
        System.out.println("Средний возраст двух лучших студентов = " + middleAgeOfSomeStudents(list, 2));
    }
}
