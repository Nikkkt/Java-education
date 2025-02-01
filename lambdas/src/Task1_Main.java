import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task1_Main {
    public static void main(String[] args) {
        // 1
        Predicate<Integer> isLeapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        System.out.println(isLeapYear.test(2024));
        System.out.println(isLeapYear.test(1900));

        // 2
        BiFunction<LocalDate, LocalDate, Long> daysBetween = (date1, date2) -> ChronoUnit.DAYS.between(date1, date2);

        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2024, 1, 1);

        System.out.println(daysBetween.apply(date1, date2));

        // 3
        BiFunction<LocalDate, LocalDate, Long> fullWeeksBetween = (date3, date4) -> ChronoUnit.WEEKS.between(date3, date4);

        LocalDate date3 = LocalDate.of(2023, 1, 1);
        LocalDate date4 = LocalDate.of(2023, 12, 31);

        System.out.println(fullWeeksBetween.apply(date3, date4));

        // 4
        Function<LocalDate, String> dayOfWeek = date -> date.getDayOfWeek().toString();

        LocalDate date = LocalDate.of(1969, 7, 20);
        System.out.println(dayOfWeek.apply(date));
    }
}
