package calculator;

import java.util.Scanner;

public class CalculatorStart {

    public static void main(String[] args) {
        new CalculatorStart().demo();
    }

    private void demo() {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println("Your input is: " + string);

        int result = new Calculator().calculate(string);

        System.out.println("Result is :" + result);
        sc.close();
    }
}
