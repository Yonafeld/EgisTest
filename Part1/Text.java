import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Text {

    static String joinStrings(String [] inputStringArray){
        String result="";
        for (String i:inputStringArray){
            result+=i;
        }
        return result;
    }

    static Integer stringToInt(String input){
        return Integer.parseInt(input.trim());
    }

    static Double stringToDouble(String input){
        return Double.parseDouble(input.trim());
    }

    static Float stringToFloat(String input){
        return Float.parseFloat(input.trim());
    }

    static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return dateFormat.format(date);
    }

    static LocalDate stringToDate(String date) {
        LocalDate newDate = LocalDate.parse(date);
        return newDate;
    }

}
