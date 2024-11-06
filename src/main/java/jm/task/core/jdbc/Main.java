package jm.task.core.jdbc;

import java.util.List;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        // Создал табличку
        userService.createUsersTable();

        // Создаю 4 юзера
        User user1 = new User(1L, "John", "Doe", (byte) 30);
        User user2 = new User(2L, "Jane", "Doe", (byte) 25);
        User user3 = new User(3L, "Bob", "Smith", (byte) 40);
        User user4 = new User(4L, "Alice", "Johnson", (byte) 35);

        // Сохраняю и вывожу созданного юзера
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);

        // Вывожу всех юзеров
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        // Удалил всех юзеров (Очистка таблицы)
        userService.cleanUsersTable();

        // Удаляю таблицу совсем ('дропаю' таблицу)
        userService.dropUsersTable();
    }
}
