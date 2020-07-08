import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Text {

    static String JoinStrings(String [] InputArrayOfWords){
        String ConcatenatedWord="";
        for (String i:InputArrayOfWords){
            ConcatenatedWord+=i;
        }
        return ConcatenatedWord;
    }

    static Integer StringToInt(String value){
        return Integer.parseInt(value.trim());
    }

    static Double StringToDouble(String value){
        return Double.parseDouble(value.trim());
    }

    static Float StringToFloat(String value){
        return Float.parseFloat(value.trim());
    }

    static String DateToString(Date OldDate) {
        DateFormat FormatDateToForm = new SimpleDateFormat("yyyy-mm-dd");
        return FormatDateToForm.format(OldDate);
    }

    static LocalDate StringToDate(String OldDate) {
        LocalDate FormatDateToForm = LocalDate.parse(OldDate);
        return FormatDateToForm;
    }

}
