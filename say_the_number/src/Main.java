
import java.util.Scanner;

public class Main {

    private static final String ZERO = "Zero";

    private static String[] units = {"", " one", " two", " three",
            " four", " five"," six", " seven", " eight", " nine"};

    private static String[] teens = {" ten", " eleven", " twelve", " thirteen",
            " fourteen", " fifteen"," sixteen", " seventeen", " eighteen", " nineteen"};

    private static String[] tens = {"", "", " twenty", " thirty",
            " forty", " fifty"," sixty", " seventy", " eighty", " ninety"};


    public static String generateWords(long number) {
        String input = String.valueOf(number);
        int size = input.length();

//        creating words with numbers between 3 and 4 digits
        if (size <= 3) {
            int num = (int) number;
            return hundredsAndTens(num);
        } else if (size > 3 && size <= 6) {
            int thousand = (int)(number/1000);
            int hundred = (int) (number % 1000);
            String thousands = hundredsAndTens(thousand);


            String hundreds = hundredsAndTens(hundred);
            String word = "";

            if (!thousands.isEmpty()) {
                word = thousands +" thousand";
            }
            word += hundreds;
            return word;

//            creating words with numbers between 6 and 13 digits
        } else if (size > 6 && size <= 14) {
            int tri = (int) (number / 1000000000000L);
            number = number % 1000000000000L;
            int bill = (int) (number/ 1000000000);
            number = number % 1000000000;
            int mill = (int) (number/ 1000000);
            number = number % 1000000;
            int thousand = (int)(number/1000);
            int hundred = (int) (number % 1000);

            String trillions = hundredsAndTens(tri);
            String billions = hundredsAndTens(bill);
            String millions = hundredsAndTens(mill);
            String thousands = hundredsAndTens(thousand);
            String hundreds = hundredsAndTens(hundred);

            String word = "";


            if (!trillions.isEmpty()){
                word = trillions + " trillion";
            }
            if(!billions.isEmpty()){
                word += billions + " billion";
            }
            if (!millions.isEmpty()) {
                word += millions +" million";
            }
            if (!thousands.isEmpty()) {
                word += thousands +" thousand";
            }
            word += hundreds;
            return word;
        }

        return generateWords(number);
    }


    //    creates words that have numbers with less than 3 digits
    private static String hundredsAndTens(int num) {
        if (num <= 0)
            return "";

        String word = "";
        if (num/100 > 0) {
            int dividend = num/100;
            word = units[dividend] + " hundred";
            num = num % 100;
        }

        if (num/10 > 1) {
            int dividend = num/10;
            num = num % 10;
            word += tens[dividend];

        }
        else if (num/10 == 1) {
            num = num % 10;
            word += teens[num];
            return word;
        }
        else {
            num = num % 10;
        }
        if (num > 0) {
            word += units[num];
        }

        return word;
    }

    public static String sayNumber(long num){

        if (num == 0){
            return ZERO;
        }
        return generateWords(num).trim();

    }

    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        Scanner num = new Scanner(System.in);
        System.out.print(sayNumber(Long.parseLong(num.nextLine())));
    }
}