import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Для входа введите логин, email или номер телефона:");
        String login = scan.nextLine();
        System.out.println("введите пароль:");
        String password = scan.nextLine();

        validateUser(getUserByLoginAndPassword(login, password));
    }

    public static User[] getUsers() {
        User user1 = new User("jhon", "qwerty123", "123@mail.ru", 15, "79119119191");
        User user2 = new User("max_death", "ytrewq321", "max_death@mail.ru", 25, "79211213698");
        User user3 = new User("serioussam", "omnomnom", "samsam", 32, "79996963214");

        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {

        User[] list_users = getUsers();

        for (User user : list_users) {

            if ((user.login.equals(login)) || (user.password.equals(password))) {
                return user;
            }
            if ((user.email.equals(login)) || (user.password.equals(password))) {
                return user;
            }
            if ((user.phone.equals(login)) || (user.password.equals(password))) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.age < 18) {
            throw new AccessDeniedException("Пользователю меньше 18");
        } else {
            System.out.println("Доступ предоставлен!");
        }
    }
}
