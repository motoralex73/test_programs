package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ExampleKataStreamKeyValueMapper {
    public static void main(String[] args) {
        var listNumber = List.of(1,2,3,4,5,6,7,8,9);
        Function<Integer, String> keyMapper = a -> (a % 2 == 0) ? "even" : "odd";
        Function<Integer, List<Integer>> valueMapper = a -> List.of(a);
        BinaryOperator<List<Integer>> mergeFunction = (a, b) -> {
          List<Integer> list = new ArrayList<>(a);
          list.addAll(b);
          return list;
        };
        Supplier<Map<String, List<Integer>>> supplier = HashMap::new;
        Map<String, List<Integer>> map = listNumber.stream()
                .collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction, supplier));
        System.out.println(map);
    }
}
