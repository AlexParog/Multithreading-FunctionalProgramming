import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFinCalculator {

    private static final double CREDIT_AMOUNT = 20000;
    private static final double YEAR_PERCENT = 12;
    private static final double NUMBER_OF_PERIODS_IN_MONTHS = 36;
    private static final FinCalculator finCalculator = new FinCalculator();

    @Test
    // Месячный платёж
    public void testMonthlyPayment() {

        System.out.println("Месячный платёж");

        double totalByFinCalculator = finCalculator.getMonthlyPayment(CREDIT_AMOUNT, YEAR_PERCENT, NUMBER_OF_PERIODS_IN_MONTHS);
        double totalByFunction = funMonthlyPayment();
        assertTrue((int) totalByFunction == (int) totalByFinCalculator);

        System.out.println("Месячный расчёт, рассчитанный FinCalculator: " + totalByFinCalculator);
        System.out.println("Месячный расчёт, рассчитанный funMonthlyPayment(): " + totalByFunction);

    }

    @Test
    // Кредит + проценты
    public void testInterestAmount() {

        System.out.println("Итоговая выплата");

        double totalByFinCalculator = finCalculator.getMonthlyPayment(CREDIT_AMOUNT, YEAR_PERCENT, NUMBER_OF_PERIODS_IN_MONTHS)
                * NUMBER_OF_PERIODS_IN_MONTHS;
        double totalByFunction = funMonthlyPayment() * NUMBER_OF_PERIODS_IN_MONTHS;
        assertTrue((int) totalByFunction == (int) totalByFinCalculator);

        System.out.println("Итоговая выплата, рассчитанная FinCalculator: " + totalByFinCalculator);
        System.out.println("Итоговая выплата, рассчитанная funMonthlyPayment(): " + totalByFunction);

    }

    @Test
    // Проценты
    public void testAmountForThePeriod() {

        System.out.println("Сумма переплат");

        double totalByFinCalculator = finCalculator.getMonthlyPayment(CREDIT_AMOUNT, YEAR_PERCENT, NUMBER_OF_PERIODS_IN_MONTHS)
                * NUMBER_OF_PERIODS_IN_MONTHS - CREDIT_AMOUNT;
        double totalByFunction = funMonthlyPayment() * NUMBER_OF_PERIODS_IN_MONTHS - CREDIT_AMOUNT;
        assertTrue((int) totalByFunction == (int) totalByFinCalculator);

        System.out.println("Сумма переплат, рассчитанная FinCalculator: " + totalByFinCalculator);
        System.out.println("Сумма переплат, рассчитанная funMonthlyPayment(): " + totalByFunction);

    }

    public static double funMonthlyPayment() {
        return CREDIT_AMOUNT * ((YEAR_PERCENT / (12 * 100)) / (1 - Math.pow((1 + YEAR_PERCENT / (12 * 100)), - NUMBER_OF_PERIODS_IN_MONTHS)));
    }
}
