//package ibs;
//
//import book_example.chapter_2.Task_51;
//
//import java.util.*;
//
//public class Rtk {
//
//    public static class User {
//        private String name;
//        public String getName() {
//            return name;
//        }
//    }
//
//    @Service
//    public static class UserService {
//
//        private final List<User> users = Collections.synchronizedList(new ArrayList<>());
//
//        public void addUser(User user) {
//            if (user == null || user.getName() == null) {
//                throw new IllegalArgumentException("User name cannot be null");
//            }
//            users.add(user);
//        }
//
//        public Optional<User> findUser(String name) {
//            return users.stream().filter(x -> x.name.equals(name)).findFirst();
//        }
//
//        public void processUsers() {
//            for (int i = 0; i < users.size(); i++) {
//                User user = users.get(i);
//
//                try {
//                    Thread.sleep(1000);
//                    user.setProcessed(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    }
//
//    @RestController
//    public class UserController {
//
//        private final UserService userService;
//
//        @Autowired
//        public UserController (UserService userService) {
//            this.userService = userService;
//        }
//
//        @GetMapping("/users/{name}")
//        public ResponseEntity<User> getUser(@PathVariable String name) {
//            Optional<User> user = userService.findUser(name);
//            if (user == null) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(user);
//        }
//
//        @PostMapping("/users")
//        public void addUser(@RequestBody User user) {
//            userService.addUser(user);
//        }
//
//        @PostMapping("/users/process")
//        public void processUsers() {
//            userService.processUsers();
//        }
//    }
//
//}
