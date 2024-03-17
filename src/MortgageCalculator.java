public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    final private int principal;
    final private float annualInterestRate;
    final private byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage(){
        short numberOfMonthlyPayments = getNumberOfMonthlyPayments();
        double monthlyInterestRate = getMonthlyInterestRate();

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) - 1);
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        short numberOfMonthlyPayments = getNumberOfMonthlyPayments();
        double monthlyInterestRate = getMonthlyInterestRate();

        return principal
                * (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonthlyPayments) - 1);
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfMonthlyPayments()];

        for (short month = 1; month <= balances.length; month++)
            balances[month-1] = calculateBalance(month);

        return balances;
    }

    private short getNumberOfMonthlyPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }
}
