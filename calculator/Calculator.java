package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int calculate(String str) {
        ArrayList<String> list = new ArrayList<String>();
        String string = str.replaceAll("\\s", "");
        String numbers = "";
        String value = " ";
        int count = 0;
        int notDigitIndex = 0;
        char ch = ' ';
        boolean digit = false;

        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                count++;
            }
        }
        if (0 == count) {
            string = RomanConverter.convert(string);
        }

        while (!Character.isDigit(string.charAt(notDigitIndex))) {
            notDigitIndex++;
        }

        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i);
            value = string.substring(i, i + 1);

            if (Character.isDigit(ch)) {
                digit = true;
                numbers = numbers + value;
            }
            if (!digit) {
                if (0 == i || !Character.isDigit(string.charAt(i - 1))) {
                    list.add(value);
                } else {
                    list.add(numbers);
                    list.add(value);
                    numbers = "";
                }
            }
            digit = false;
            if (0 < i && string.charAt(i - 1) == '-' && i <= notDigitIndex) {
                list.add(i - 1, "0");
            }

            if (i == string.length() - 1) {
                if (Character.isDigit(ch)) {
                    list.add(numbers);
                }
            }
        }
        return Integer.parseInt(calc(list).get(0));
    }

    private List<String> calc(List<String> list) {
        int result = 0;
        if (1 == list.size()) {
            return list;
        }

        char ch = ' ';
        for (int i = 0; i < list.size(); i++) {
            ch = list.get(i).charAt(0);
            if ('(' == ch) {
                ch = ' ';
                brackets(list);
                break;
            }
        }

        if (1 == list.size()) {
            return list;
        }

        if ((Character.isDigit(list.get(0).charAt(0)) || Character.isDigit(list.get(0).charAt(1)))) {

            switch (list.get(1).charAt(0)) {
                case '*':
                    Integer.parseInt(list.get(0));

                    result = Integer.valueOf(list.get(0)) *
                            Integer.valueOf(list.get(2));
                    list.set(0, Integer.toString(result));
                    list.subList(1, 3).clear();
                    list = calc(list);
                    break;

                case '/':
                    result = Integer.valueOf(list.get(0)) /
                            Integer.valueOf(list.get(2));
                    list.set(0, Integer.toString(result));
                    list.subList(1, 3).clear();
                    list = calc(list);
                    break;

                default:
                    if (4 < list.size() && '/' == list.get(3).charAt(0)) {
                        result = Integer.valueOf(list.get(2)) /
                                Integer.valueOf(list.get(4));
                        list.set(2, Integer.toString(result));
                        list.subList(3, 5).clear();
                        list = calc(list);
                        break;

                    } else if (4 < list.size() && '*' == (list.get(3).charAt(0))) {
                        result = Integer.valueOf(list.get(2)) *
                                Integer.valueOf(list.get(4));
                        list.set(2, Integer.toString(result));
                        list.subList(3, 5).clear();
                        list = calc(list);
                        break;

                    } else if ('+' == list.get(1).charAt(0)) {
                        result = Integer.valueOf(list.get(0)) +
                                Integer.valueOf(list.get(2));
                        list.set(0, Integer.toString(result));
                        list.subList(1, 3).clear();
                        list = calc(list);
                        break;

                    } else if ('-' == list.get(1).charAt(0)) {
                        result = Integer.valueOf(list.get(0)) -
                                Integer.valueOf(list.get(2));
                        list.set(0, Integer.toString(result));
                        list.subList(1, 3).clear();
                        list = calc(list);
                    }
            }
        }
        return list;
    }

    private List<String> brackets(List<String> list) {
        int start = 0;
        int finish = 0;
        char charOne = ' ';
        char charTwo = ' ';


        for (int i = 0; i < list.size(); i++) {
            charOne = list.get(i).charAt(0);
            if ('(' == charOne) {
                start = i + 1;
            }
            if (')' == charOne) {
                finish = i;
                break;
            }
        }

        List<String> list2 = new ArrayList<>(list.subList(start, finish));
        calc(list2);
        list.set(start - 1, list2.get(0));
        list.subList(start, finish + 1).clear();
        return calc(list);
    }
}
