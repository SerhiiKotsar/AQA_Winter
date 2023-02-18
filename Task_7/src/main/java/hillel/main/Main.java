package hillel.main;
import hillel.exeptions.UserValidation;


public class Main {
    public static void main(String[] args) {
        String login = "user_name"; // указываем свои значения
        String password = "password_!"; // указываем свои значения
        String confirmPassword = "password_!"; // указываем свои значения
        boolean isValid = UserValidation.validate(login, password, confirmPassword);
        System.out.println(isValid);
    }
}

