import java.util.Scanner;

public class Methods {

    static Scanner scanner = new Scanner (System.in);

    public static int getInt() {

        System.out.println("Введите число : ");
        int num;
            if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        }
            else {
                System.out.println("Допущена ошибка при вводе числа. Попробуйте ещё раз.");
                scanner.next(); //рекурсия
                num = getInt();
            }

        return num;

    }

    public static char getOperation() {

        System.out.println("Введите операцию: ");
        char operation;
            if (scanner.hasNext()) {
                operation = scanner.next().charAt(0);
            }
            else {
                System.out.println("Допущена ошибка при вводе операции. Попробуйте ещё раз.");
                scanner.next(); //рекурсия
                operation = getOperation();
            }

        return operation;

    }

    public static int calc (int num1, int num2, char operation) {

        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод");
                result = calc(num1, num2, getOperation());//рекурсия
        }

        return result;

    }

}
