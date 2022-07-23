public class Main {

    public static void main(String[] args) {
        // Principal
        double principal = Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);

        // Annual Interest Rate
        double rate = Console.readNumber("Annual Interest Rate: ", 1, 30);

        // Period (Years)
        double years = Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculators((int) principal, (float) rate, (int) years);

        var report = new MortgageReports(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}