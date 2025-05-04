package book_example.chapter_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


//Подсчет гласных и согласных
public class Task_5 {

    static class Pair<T1, T2> {
        private T1 vowels;
        private T2 consonants;

        public Pair(T1 vowels, T2 consonants) {
            this.vowels = vowels;
            this.consonants = consonants;
        }
        public T1 getVowels() {
            return vowels;
        }
        public T2 getConsonants() {
            return consonants;
        }
    }

    static Set<Character> allVowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

    public static Pair<Long, Long> countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) vowels++;
            else if (ch >= 'a' && ch <= 'z') consonants++;
        }

        Pair pair = new Pair(vowels, consonants);

        return pair;
    }

    public static void main(String[] args) {

        String str = "String calculate vowel and consonant letters";
        str = str.toLowerCase();

        //первый способ
        Pair pair = countVowelsAndConsonants(str);
        System.out.println("1. Vowels = " + pair.getVowels() + " consonants = " + pair.getConsonants());

        //второй способ
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(Collectors.partitioningBy(c -> allVowels.contains(c), Collectors.counting()));

        System.out.println("2. Vowels = " + result.get(true) + " consonants = " + result.get(false));
    }
}
