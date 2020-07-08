import java.util.List;

public class Is {

    static boolean IsEmail(String userEmailEntered){
        boolean verification =false;
        if (userEmailEntered==null || userEmailEntered.isEmpty()){
            return verification;
        }

        if (userEmailEntered.indexOf('@')!=-1 &&userEmailEntered.indexOf('.')!=-1){
            verification=true;
        }

        return verification;
    }

    static  boolean IsInt(double ValueToCheck){
        boolean verification =false;
        if(ValueToCheck==(int)ValueToCheck && ValueToCheck<Integer.MAX_VALUE&& ValueToCheck>Integer.MIN_VALUE){
            verification=true;
        }
        return  verification;
    }

    static  boolean IsDouble(double ValueToCheck){
        boolean verification =false;
        String ValueFormatted=String.valueOf(ValueToCheck);
        if((ValueToCheck!=(int)ValueToCheck&& ValueToCheck<Double.MAX_VALUE&& ValueToCheck>Double.MIN_VALUE) ||
                (ValueFormatted.indexOf(".")!=-1 && ValueToCheck<Double.MAX_VALUE&& ValueToCheck>Double.MIN_VALUE)){
            verification=true;
        }
        return  verification;
    }

    static boolean IsObjEmpty(String Value){
        if(Value == null|| Value=="") {
            return true;
        }
        return false;
    }

    static boolean IsObjEmpty(String [] Value){
        if(Value == null|| Value.length==0) {
            return true;
        }
        return false;
    }

    static boolean IsObjEmpty(Integer Value){
        if(Value == null) {
            return true;
        }
        return false;
    }

    static boolean IsObjEmpty(Integer [] Value){
        if(Value == null|| Value.length==0) {
            return true;
        }
        return false;
    }

    static boolean IsObjEmpty(Character Value){
        if(Value == null) {
            return true;
        }
        return false;
    }

    static boolean IsObjEmpty(Character [] Value){
        if(Value == null|| Value.length==0) {
            return true;
        }
        return false;
    }

    static boolean IsObjEmpty(List<String> Value){
        if(Value == null) {
            return true;
        }
        if(Value.isEmpty()) {
            return true;
        }

        return false;
    }






}
