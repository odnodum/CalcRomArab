import java.util.Scanner;

public class ConsoleCalc {
    static int num1;
    static int num2;
    static char simbol;
    static int res;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input:");
        String strInput = scan.nextLine();
        char[] arrChar = new char[8];

        for (int i = 0; i < strInput.length(); i++) {
            arrChar[i] = strInput.charAt(i);
            if (arrChar[i] == '*') {
                simbol = '*';
            }
            if (arrChar[i] == '/') {
                simbol = '/';
            }
            if (arrChar[i] == '+') {
                simbol = '+';
            }
            if (arrChar[i] == '-') {
                simbol = '-';
            }
        }

        String arrCharStr = String.valueOf(arrChar);
        String[] numArr = arrCharStr.split("[-+*/]");
        String numString1 = numArr[0].trim();
        String numString2 = numArr[1].trim();
        num1 = romanToNumber(numString1);
        num2 = romanToNumber(numString2);
        try {
            if (num1 < 0 && num2 < 0) {
                res = 0;
            } else {
                res = resultOperation(num1, num2, simbol);
                System.out.println("Output:");
                System.out.println(arabianToRoman(res));
            }
            num1 = Integer.parseInt(numString1);
            num2 = Integer.parseInt(numString2);
            res = resultOperation(num1, num2, simbol);
            System.out.println("Output:");
            System.out.println(res);
        } catch (ArithmeticException | NumberFormatException ex) {
        }
    }

    private static String arabianToRoman(int arabianNum) {
        String[] romanNum = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = romanNum[arabianNum];
        return s;
    }

    private static int romanToNumber(String numRoman) {
        if (numRoman.equals("I")) {
            return 1;
        } else if (numRoman.equals("II")) {
            return 2;
        } else if (numRoman.equals("III")) {
            return 3;
        } else if (numRoman.equals("IV")) {
            return 4;
        } else if (numRoman.equals("V")) {
            return 5;
        } else if (numRoman.equals("VI")) {
            return 6;
        } else if (numRoman.equals("VII")) {
            return 7;
        } else if (numRoman.equals("VIII")) {
            return 8;
        } else if (numRoman.equals("IX")) {
            return 9;
        } else if (numRoman.equals("X")) {
            return 10;
        }
        return -1;
    }

    public static int resultOperation(int num1, int num2, char simbol) {
        int result = 0;
        switch (simbol) {
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            default:
                throw new IllegalArgumentException("Не верная операция");
        }
        return result;
    }
}
