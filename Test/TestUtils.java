import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TestUtils {
    public static Integer getVCNormalValue(int min, int max) { // get VolumeCalculator's normal value
        return new Random(System.currentTimeMillis()).nextInt(max)%(max-min+1) + min;
    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static String getNDDNormalValue() { // get NextDayDate's normal value
        final int nDay = 3652426;
        final long aDay = 86400000L, firstDay = -62167420800000L, lastDay = 253402185600000L;
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(getVCNormalValue(0, nDay)*aDay+firstDay));
    }

    public static int getYear(int isLeapYear) {
        int index = 0, nIndex = 0;
        int[] leapYear = new int[10000], nLeapYear = new int[10000];
        for (int year=0; year <= 9999; year++)
            if (year%4==0&&year%100!=0 || year%400==0) leapYear[index++] = year;
            else nLeapYear[nIndex++] = year;
        if (isLeapYear==1) return leapYear[getVCNormalValue(0, index)];
        else return nLeapYear[getVCNormalValue(0, nIndex)];
    }

    /**
     * @param type 0 is 31day month, 1 is 30day month, others return  2
     */
    public static int getMonth(int type) {
        final int[] the31DayMonth = {1, 3, 5 ,7, 8, 10, 12}, the30DayMonth = {4, 6, 8, 11};
        if (type==0) return the31DayMonth[getVCNormalValue(0, the31DayMonth.length-1)];
        else if (type==1) return the30DayMonth[getVCNormalValue(0, the30DayMonth.length-1)];
        else return 2;
    }

    /**
     * @param type 27 is a random normal value, others return as argument
     */
    public static int getDay(int type) {
        if (type ==  27) return getVCNormalValue(1, 27);
        else return type;
    }
}
