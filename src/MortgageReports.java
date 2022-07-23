import java.text.NumberFormat;

public class MortgageReports {
    private MortgageCalculators calculator;
    private final NumberFormat currency;

    public MortgageReports(MortgageCalculators calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println("\nMORTGAGE" + "\n--------" + "\nMonthly Payments: " + currency.format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances()){
            System.out.println(currency.format(balance));
        }
    }
}
