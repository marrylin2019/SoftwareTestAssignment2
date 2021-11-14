import java.util.Arrays;
import java.util.regex.Pattern;

public class StdNextDayDate {
    public static String getNextDayDate(String primeDate) {
        /**
         Generate date of the day after input

         * @param primeDate Base date
         * @return Date of the day after input
         */

        int maxDay;
        final int MAX_MONTH = 12;
        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (Pattern.matches("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[01])", primeDate)) {
            int[] date = Arrays.stream(primeDate.split("-")).mapToInt(Integer::parseInt).toArray();
            boolean isLeapMonth = (date[0]%4==0&&date[0]%100!=0 || date[0]%400==0) && date[1]==2;

            if (isLeapMonth) maxDay = 29;
            else maxDay = maxDays[date[1] - 1];

            if (++date[2] > maxDay) {
                date[2] = 1;
                if (++date[1] > MAX_MONTH) {
                    date[1] = 1;
                    if (++date[0] > 9999) return "Overflow on!";
                }
            }
            return String.format("%04d-%02d-%02d", date[0], date[1], date[2]);
        }
        return "";
    }
}
