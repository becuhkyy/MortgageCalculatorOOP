import java.util.Scanner;

public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static double readNumber(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextDouble();
    }

    public static double readNumber(String prompt, double minVal, double maxVal) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = SCANNER.nextDouble();
            if (value >= minVal && value <= maxVal )
                return value;
            System.out.println("Please enter a value between " + minVal + " and " + maxVal);
        }
    }
}
