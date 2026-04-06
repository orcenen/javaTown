import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.List;
import java.util.function.Supplier;
import MUtils.MUtil;

public class Main {
    // imports
    public static MUtil        u = new MUtil();
    public static Random       r = new Random();
	public static Events       e = new Events();

    // constants
    public static final double usdEurExchange = 0.87;

    // globals
    public static int          population = 0;
    public static float        rating = 0;
    public static BigDecimal   money = new BigDecimal("0.00");
    public static String       name = "";

    public static boolean      isEuro = true;
    public static boolean      isUsd  = false;

    // utils
    public static String format(int number) {
        if (number < 1000)        return Integer.toString(number);
        if (number < 100_000_000) return String.format("%.1fk", number / 1000.0);

        return String.format("%.1fm", number / 1_000_000.0);
    }

    public static BigDecimal convert(BigDecimal amount) {
        BigDecimal result;
        if (isEuro) {result = amount.multiply(BigDecimal.valueOf(usdEurExchange));}
        else if (isUsd) {result = amount.divide(BigDecimal.valueOf(usdEurExchange), 10, RoundingMode.HALF_UP);}
        else {result = amount;}

        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public static String generation() {
        List<Supplier<String>> methods = List.of(
	            this::methodA,
                this::methodB,
                this::methodC
        );

        Supplier<String> randomMethod = methods.get(r.nextInt(methods.size()));
        return randomMethod.get();
    }

    public static void main(String[] args) {

    }
}

class Events {

}
