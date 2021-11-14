public class NextDayDate {
    public static String getNextDayDate(int y,int m,int d) {

        int [] month1= {31,28,31,30,31,30,31,31,30,31,30,31};
        int [] month2= {31,29,31,30,31,30,31,31,30,31,30,31};
        d=d+1;
        if(m==2) {
            int a=1;
            if((y%4==0 && y%100!=0) || (y%400==0)){
                a=1;
            }else{
                a=0;
            }
            if(a==1) {
                if(d<=month2[m-1])

                    return String.format("%4d-%02d-%02d", y,m,d);
                else
                    m=m+1;
                d=1;
                return String.format("%4d-%02d-%02d", y,m,d);
            }
            else {
                if(d<=month1[m-1])
                    return String.format("%4d-%02d-%02d", y,m,d);
                else
                    m=m+1;
                d=1;
                return String.format("%4d-%02d-%02d", y,m,d);
            }
        }
        else if(m==12) {
            if(d>=31){
                y=y+1;
                m=1;
                d=d-31;
                return String.format("%4d-%02d-%02d", y,m,d);
            }
            else {
                return String.format("%4d-%2d-%02d", y,m,d);
            }
        }
        else {
            if(d<month1[m-1]) {
                return String.format("%4d-%02d-%02d", y,m,d);
            }
            else
            {
                m=m+1;
                d=1;
                return String.format("%4d-%02d-%02d", y,m,d);
            }
        }
    }

    public static String overwrapGetNextDayDate(String date) {
        String[] splitDate = date.split("-");
        return getNextDayDate(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
    }
}