/*
Написать калькулятор:
Метод int getInt() - должен считывать с консоли целое число и возвращать его
Метод char getOperation() - должен считывать с консоли какое-то значение и возвращать символ с операцией (+, -, * или /)
Метод int calc(int num1, int num2, char operation) - должен выполнять над числами num1 и num2 арифметическую операцию, заданную operation.
Метод main() - должен считывать 2 числа (с помощью getInt()), считать операцию (с помощью getOperation(), передать все методу calc() и вывести на экран результат.
*/

public class Main {

    public static void main(String[] args) {

        int num1 = Methods.getInt();
        int num2 = Methods.getInt();
        char operation = Methods.getOperation();
        int result = Methods.calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);

    }
}
