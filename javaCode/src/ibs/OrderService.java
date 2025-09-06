//package ibs;
//
//@Service
//public class OrderService {
//
//    private final OrderRepository orderRepository;
//    private final NotificationService notificationService; //bad code
//
//    public OrderService(NotificationService notificationService, OrderRepository orderRepository) {
//        this.notificationService = notificationService;
//        this.orderRepository = orderRepository;
//    }
//
//    @Transactional
//    public void updateOrderStatus(Long orderId, String newStatus) {
//        try {
//            Optional<Order> order = orderRepository.findById(orderId).orElseThrow() -> new Exception("Order not found");
//        } catch (Exception e) {
//            System.out.println("Exception in updateOrderStatus");
//        }
//
//        //todo Enum status and switch() ->
//        enum OrderStatus {
//            COMPLETED,
//            CANCELLED,
//            PENDING,
//            IN_PROGRESS
//        }
//
//// Обновленный код с новым синтаксисом switch и enum
//        OrderStatus status = OrderStatus.valueOf(newStatus);
//
//        switch (status) {
//            case COMPLETED -> {
//                order.setStatus(status);
//                orderRepository.save(order);
//                notificationService.notifyUser(order.getUserId(), "Your order is completed");
//            }
//            case CANCELLED -> {
//                order.setStatus(status);
//                orderRepository.save(order);
//                notificationService.notifyUser(order.getUserId(), "Your order is cancelled");
//            }
//            case PENDING, IN_PROGRESS -> {
//                order.setStatus(status);
//                orderRepository.save(order);
//            }
//            default -> throw new IllegalArgumentException("Unsupported status: " + newStatus);
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
