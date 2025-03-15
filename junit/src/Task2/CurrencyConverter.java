package Task2;

public class CurrencyConverter {
    private static final double DOLLAR_RATE = 40.0;
    private static final double EURO_RATE = 45.0;
    private static final double POUND_RATE = 50.0;
    private static final double YEN_RATE = 0.3;
    private static final double HRYVNA_RATE = 1.0;

    public static double convert(double amount, Currency from, Currency to) {
        if(amount < 0) throw new IllegalArgumentException("Amount must be non-negative");
        double amountInHryvnia = amount * getRateToHryvnia(from);
        return amountInHryvnia / getRateToHryvnia(to);
    }

    private static double getRateToHryvnia(Currency currency) {
        switch (currency) {
            case DOLLAR:
                return DOLLAR_RATE;
            case EURO:
                return EURO_RATE;
            case POUND:
                return POUND_RATE;
            case YEN:
                return YEN_RATE;
            case HRYVNA:
                return HRYVNA_RATE;
            default:
                throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
    }
}