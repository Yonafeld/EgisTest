public class Is {

    static boolean email(String userEmail){
        boolean verification =false;
        if (userEmail==null || userEmail.isEmpty()){
            return verification;
        }

        if (userEmail.indexOf('@')!=-1 &&userEmail.indexOf('.')!=-1){
            verification=true;
        }

        return verification;
    }

    static  boolean isInt(double x){
        boolean verification =false;
        String intAsaString=String.valueOf(x);
        if(x==(int)x && x<Integer.MAX_VALUE&& x>Integer.MIN_VALUE && intAsaString.indexOf(".")==-1){
            verification=true;
        }
        return  verification;
    }

    static  boolean isDouble(double x){
        boolean verification =false;
        String doubleAsaString=String.valueOf(x);
        if((x!=(int)x&& x<Double.MAX_VALUE&& x>Double.MIN_VALUE) ||
                (doubleAsaString.indexOf(".")!=-1 && x<Double.MAX_VALUE&& x>Double.MIN_VALUE)){
            verification=true;
        }
        return  verification;
    }

    static boolean isobjEmpty(Object x){
        if(x == null|| x=="") {
            return true;
        }
        return false;
    }


}
