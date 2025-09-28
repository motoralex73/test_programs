package ibs;

//public class FriendlySobes1 {
//
//    java.sql.SQLTransientConnectionException: HikariPool-1 - Connection is not available, request timed out after 30000ms.
//
//    @Transactional //добавлено в релизе. Задача - гарантировать доставку сообщения при успешной операции
//    public Boolean doTransaction (Request r) {
//
//        moneyService.saveOperation(...);
//        messageSender.syncSend(...);
//        log(...);
//
//    }
//
//////MoneyService//////////
//...
//    @Transactional()
//    public void saveOperation(...) {
//        //операции в БД
//    }
//
//
//////MessageSender//////////
//...
//
//    private
//
//    public void syncSend(...) {
//
//        //обертка над вызовом апи мобильного оператора
//
//    }
//
//}
