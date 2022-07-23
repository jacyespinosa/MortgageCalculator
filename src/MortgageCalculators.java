import java.text.NumberFormat;

public class MortgageCalculators {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private int years;

    public MortgageCalculators(int principal, float annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        // Calculate the Monthly Interest Rate
        float monthlyInterestRate = getMonthlyInterestRate();
        // Calculate the Number of Payments
        int numberOfPayments = getNumberOfPayments();

        double balance = principal * (Math.pow(1 + monthlyInterestRate, numberOfPayments) -
                Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {
        // Calculate the Monthly Interest Rate
        float monthlyInterestRate = getMonthlyInterestRate();
        // Calculate the Number of Payments
        int numberOfPayments = getNumberOfPayments();

        // Calculate the Monthly Mortgage Payment
        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;

    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }
    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
    private float getMonthlyInterestRate() {
        return (annualInterest / PERCENT) / MONTHS_IN_YEAR;
    }
}
