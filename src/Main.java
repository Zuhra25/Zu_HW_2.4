
public class Main {
    public static void main(String[] args) {
        String login = "java_skypro_go Ю";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";

        checkExceptions(login, password, confirmPassword);
    }

    public static void test(String log, String pass, String confirmPass) {
        if (log.length() > 20) {
            throw new WrongLoginException("Логин длинее 20 символов");
        } else if (!log.matches("\\w+")) {
            throw new WrongLoginException("Логин имеет недопустимые символы");
        }
        if (pass.length() > 20) {
            throw new WrongPasswordException("Пароль длинее 20 символов");
        } else if (!pass.matches("\\w+")) {
            throw new WrongPasswordException("Пароль имеет недопустимые символы");
        } else if (!pass.matches(confirmPass)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

    }

    public static void checkExceptions(String log, String pass, String confirmPass) {
        try {
            test(log, pass, confirmPass);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}