package ibs;
/*
* // 1) Функция возвращает квадратные корни элементов в data в том же порядке, но без дубликатов, [16, 16, 4] => [4, 2]
// Код должен быть production-ready
public static List<Double> uniqueSqrts(List<Double> data) {


}
составить тест для него
*
*
*
*-----------------------------------------------------------------------------------------
*
* задача по БД

-- В базе есть таблицы supplier (поставщик) и supply (поставка), которые связаны отношением один-ко-многим.
-- В таблице supplier есть колонки id, name. В таблице supply есть поля id, supplier_id, name, supply_date, worth (стоимость в рублях).
-- Нужно получить уникальные имена поставщиков, которые поставили товаров на общую сумму более 1000_000 рублей.

и вторая отдельная

-- При запросе упорядоченных поставок из supply нужно дополнительно выводить стоимость предыдущей поставки.
* ------------------------------------------------------------------------------------------------------------
*
*
*
* public record User(String name) {
}
*
public interface Registrator {
   void register(User user);
}

@Component
public class GoogleRegistrator implements Registrator {
   @Override
   public void register(User user) {
       System.out.println("Registering Google User: " + user.name());
   }
}

@Component
public class YandexRegistrator implements Registrator {
   @Override
   public void register(User user) {
       System.out.println("Registering Yandex User: " + user.name());
   }
}

@Service
@RequiredArgsConstructor
public class RegistratorService {
   private final Registrator registrator;

   public void register(User user) {
       registrator.register(user);
   }
}

что будет в бине Registrator ?
*
* */


import java.util.ArrayList;
import java.util.List;

public class FriendlySobes2 {

    public static List<Double> uniqueSqrts(List<Double> data) {
        var returnList = new ArrayList<Double>();
        Double temp = 0.0;
        for (var i = 0; i < data.size(); i++) {
            if (!temp.equals(data.get(i))) returnList.add(Math.sqrt(data.get(i)));
            temp = data.get(i);
        }

        return returnList;
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(List.of(16.0,16.0,24.0,32.0,64.0,49.0));
        System.out.println(uniqueSqrts(list));
    }
}
