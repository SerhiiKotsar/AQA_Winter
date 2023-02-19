package hillel.exeptions;

public class UserValidation {
    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (login.length() >= 20 || !login.contains("_")) {
            throw new WrongLoginException("Логин должен содержать менее 20 символов и содержать символ подчеркивания «_».");
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() >= 20 || !password.contains("_") || !password.contains("!") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль должен содержать менее 20 символов, содержать подчеркивание «_» и восклицательный знак «!» и быть равным confirmPassword");
        }
    }
}
