package book_example.chapter_2;

import java.util.*;

//Методы equals() и hashCode()
//По умолчанию метод equals сравнивает ссылки на объекты (проверяет, одинаковые ли объекты в памяти).
// Его можно переопределить в своем классе для сравнения значений полей.
//hashCode - возвращает хэш-код объекта в виде числа
//Используются для ускорения поиска в коллекциях, если равны для двух разных ссылок на объекты по хэш-коду, то вызывается метод equals.

public class Task_46 {

    public static class Player {
        private int id;
        private String name;

        public Player(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (getClass() != o.getClass()) return false;

            final Player player = (Player) o;
            if (this.id != player.id) return false;
            if (!Objects.equals(this.name, player.name)) return false;
            return true;
        }
    }

    public static void main(String[] args) {

        Player p1 = new Player(1, "Leonardo");
        Player p2 = new Player(1, "Leonardo");

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        HashSet<Player> h = new HashSet<>();
        h.add(p1);
        h.add(p2);

        System.out.println("Hash set count = " + h.size());
        for (Player hh : h) System.out.println(hh.id + "] " + hh.name);

        boolean eq = Objects.equals(new Object(), new Object());

        List list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        //boolean b = Arrays.deepEquals(list1, list2);
    }
}
