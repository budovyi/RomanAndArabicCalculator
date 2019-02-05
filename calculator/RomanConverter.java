package calculator;

import java.util.ArrayList;
import java.util.List;

public class RomanConverter {
    public static String convert(String RomanString) {
        StringBuilder sb = new StringBuilder();
        List<Integer> listInt = new ArrayList<>();
        char ch = ' ';
        String string = "";

        for (int i = 0; i < RomanString.length(); i++) {
            ch = RomanString.charAt(i);
            string = String.valueOf(ch);

            if (Character.isLetter(ch)) {
                for (Roman r : Roman.values()) {
                    if (String.valueOf(ch).equals(r.toString())) {
                        listInt.add(r.getValue());
                    }
                }
            }

            if ((i == RomanString.length() - 1) || !Character.isLetter(ch)) {
                while (1 < listInt.size()) {
                    if (3 <= listInt.size() && listInt.get(1) > listInt.get(0)) {
                        listInt.set(0, (listInt.get(1) - listInt.get(0)));
                        listInt.remove(1);
                    }
                    if (3 <= listInt.size() && listInt.get(2) > listInt.get(1)) {
                        listInt.set(1, listInt.get(2) - listInt.get(1));
                        listInt.remove(2);
                    } else {
                        int result = listInt.get(1) > listInt.get(0) ?
                                listInt.get(1) - listInt.get(0) :
                                listInt.get(1) + listInt.get(0);
                        listInt.set(0, result);
                        listInt.remove(1);
                    }
                }
                if (0 != listInt.size()) {
                    sb.append(listInt.get(0));
                }
                if (!Character.isLetter(ch)) {
                    sb.append(string);
                }
                listInt.clear();
            }
        }
        return sb.toString();
    }
}

enum Roman {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int value;

    Roman(int number) {
        value = number;
    }

    public int getValue() {
        return value;
    }
}
