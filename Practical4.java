import java.util.*;

public class Practical4 {
    public static void main(String args[]) {
        String number = "101101";
        String xx = "h";
        toWitch(number, xx);
    }

    public static void toWitch(String number, String xx) {
        if (number.charAt(0) == 'b' || number.charAt(0) == 'B') {
            if (xx.charAt(0) == '0' || xx.charAt(0) == '0') {
                System.out.print(BinaryToOctal(number));
            } else if (xx.charAt(0) == 'h' || xx.charAt(0) == 'H') {
                System.out.print(BinaryToHexadecimal(number));
            } else {
                System.out.print(BinaryToDecimal(number));
            }
        } else if (number.charAt(0) == '0' && number.charAt(1) != 'x' && number.charAt(1) != 'X') {
            if (xx.charAt(0) == 'b' || xx.charAt(0) == 'B') {
                System.out.print(OctalToBinary(number));
            } else if (xx.charAt(0) == 'h' || xx.charAt(0) == 'H') {
                System.out.print(OctalToHexadecimal(number));
            } else {
                System.out.print(OctalToDecimal(number));
            }
        } else if (number.charAt(1) == 'x' || number.charAt(1) == 'X') {
            if (xx.charAt(0) == 'b' || xx.charAt(0) == 'B') {
                System.out.print(HexaDecimalToBinary(number));
            } else if (xx.charAt(0) == '0' || xx.charAt(0) == '0') {
                System.out.print(HexadecimalToOctal(number));
            } else {
                System.out.print(HexadecimalToDecimal(number));
            }
        } else {
            if (xx.charAt(0) == 'b' || xx.charAt(0) == 'B') {
                System.out.print(DecimalToBinary(number));
            } else if (xx.charAt(0) == '0' || xx.charAt(0) == '0') {
                System.out.print(DecimalToOctal(Integer.parseInt(number)));
            } else {
                System.out.print(DecimalToHexadecimal(Integer.parseInt(number)));
            }
        }
    }

    public static int BinaryToDecimal(String number) {
        int decimal = 0;
        int n = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) == '1') {
                decimal += Math.pow(2, n);
            }
            n++;
        }
        return decimal;
    }

    public static String BinaryToOctal(String number) {
        int decimal = BinaryToDecimal(number);
        return DecimalToOctal(decimal);
    }

    public static String BinaryToHexadecimal(String number) {
        int decimal = BinaryToDecimal(number);
        return DecimalToHexadecimal(decimal);
    }

    public static String DecimalToBinary(String num) {
        int number = Integer.parseInt(num);
        int array[] = new int[32];
        int index = 0;
        while (number > 0) {
            array[index] = number % 2;
            index++;
            number = number / 2;
        }
        String result = "";
        for (int i = index - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }

    public static String DecimalToOctal(int num) {
        int number = num;
        int array[] = new int[32];
        int index = 0;
        while (number > 0) {
            array[index] = number % 8;
            index++;
            number = number / 8;
        }
        String result = "";
        for (int i = index - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }

    public static String DecimalToHexadecimal(int num) {
        int number = num;
        char[] array = new char[32];
        int index = 0;

        while (number > 0) {
            int result = number % 16;
            if (result <= 9) {
                array[index] = (char) ('0' + result);
            } else if (result == 10) {
                array[index] = 'A';
            } else if (result == 11) {
                array[index] = 'B';
            } else if (result == 12) {
                array[index] = 'C';
            } else if (result == 13) {
                array[index] = 'D';
            } else if (result == 14) {
                array[index] = 'E';
            } else {
                array[index] = 'F';
            }
            index++;
            number = number / 16;
        }

        String result = "";
        for (int i = index - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }

    public static String HexaDecimalToBinary(String num) {
        int num1 = HexadecimalToDecimal(num);
        return DecimalToBinary(String.valueOf(num1));
    }

    public static String HexadecimalToOctal(String num) {
        int num1 = HexadecimalToDecimal(num);
        return DecimalToOctal(num1);
    }

    public static int HexadecimalToDecimal(String number) {
        int decimal = 0;
        int n = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int hexValue = Character.digit(number.charAt(i), 16);
            decimal += hexValue * Math.pow(16, n);
            n++;
        }
        return decimal;
    }

    public static String OctalToBinary(String num) {
        int num1 = OctalToDecimal(num);
        return DecimalToBinary(String.valueOf(num1));
    }

    public static int OctalToDecimal(String num) {
        int sum = 0;
        int n = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int octalValue = Character.getNumericValue(num.charAt(i));
            sum += octalValue * Math.pow(8, n);
            n++;
        }
        return sum;
    }

    public static String OctalToHexadecimal(String num) {
        int num1 = OctalToDecimal(num);
        return DecimalToHexadecimal(num1);
    }
}
