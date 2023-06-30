
public class Main {
    public static void main(String[] args) {
        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";

        checkExceptions(login, password, confirmPassword);
    }

    public static void test(String log, String pass, String confirmPass) {
        if (log.length() > 20 || !log.matches("\\w+")) {
            throw new WrongLoginException();
        }
        if (pass.length() > 20 || !pass.matches("\\w+") || !pass.matches(confirmPass)) {
            throw new WrongPasswordException();
        }

    }

    public static void checkExceptions(String log, String pass, String confirmPass) {
        try {
            test(log, pass, confirmPass);
        } catch (WrongLoginException e) {
            System.out.println("не верный формат логина");
            throw new WrongLoginException();
        } catch (WrongPasswordException e) {
            System.out.println("не верный формат пароля или проверки пароля");
            throw new WrongPasswordException();
        }
    }
}