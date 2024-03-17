public class Main {
    final static int MIN_PRINCIPAL = 1000;
    final static int MAX_PRINCIPAL = 1_000_000;
    final static float MIN_ANNUAL_INTEREST_RATE = 0.00F;
    final static float MAX_ANNUAL_INTEREST_RATE = 30.00F;
    final static byte MIN_YEARS = 1;
    final static byte MAX_YEARS = 30;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal (BGN 1K - BGN 10M): ", MIN_PRINCIPAL, MAX_PRINCIPAL);
        byte years = (byte) Console.readNumber("Period (Years): ", MIN_YEARS, MAX_YEARS);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate (0.00 - 30.00%): ", MIN_ANNUAL_INTEREST_RATE, MAX_ANNUAL_INTEREST_RATE);

        var calculator = new MortgageCalculator(principal, annualInterestRate,years);
        var mortgageReport = new MortgageReport(calculator);

        mortgageReport.printMortgage();
        mortgageReport.printPaymentSchedule();
    }

}