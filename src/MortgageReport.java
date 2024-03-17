import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
    final private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("BALANCE: ");
        System.out.println("----------");

        for (double balance : calculator.getRemainingBalances())
            System.out.println(currencyInstance.format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String monthlyPaymentAmountFormatted = currencyInstance.format(mortgage);

        System.out.println("MORTGAGE: ");
        System.out.println("----------");
        System.out.println("Monthly Payments: " + monthlyPaymentAmountFormatted);
    }
}
