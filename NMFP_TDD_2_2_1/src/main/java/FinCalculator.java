public class FinCalculator {

    public FinCalculator() {
    }

    public double getMonthlyPayment(double creditAmount, double yearPercent, double numberOfPeriodsInMonths) {
        return creditAmount * ((yearPercent / (12 * 100)) / (1 - Math.pow((1 + yearPercent / (12 * 100)), -numberOfPeriodsInMonths)));
    }
}
