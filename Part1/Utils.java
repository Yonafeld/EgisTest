public class Utils {

    static String dateBaseSafe(String name){
        int j=0;
        char[] Namechars = name.toCharArray();
        char [] newArray=new char[name.length()];
        for (char c : Namechars) {
            if(Character.isLetter(c)&& !Character.isWhitespace(c)){
                newArray[j]=c;
            }
            if(Character.isWhitespace(c)){
                newArray[j]='_';
            }
            j++;
        }
        String newName = new String(newArray);
        return newName.trim();
    }

    static  String [] split(String input,String split1,String split2,String split3) {
        char c1=split1.charAt(0);
        char c2=split2.charAt(0);
        char c3=split3.charAt(0);
        char[] inputChars = input.toCharArray();
        char [] newArray=new char[input.length()];
        int j=0;
        for (char c : inputChars) {
            if(c==c1 || c==c2 || c==c3){
                newArray[j]=' ';

            }
            else{ newArray[j]=c; }
            j++;
        }
        int sizeOfOutput=1;
        for (char i: newArray){
            if (Character.isWhitespace(i))
            {
                sizeOfOutput+=1;
            }
        }
        String [] finalStringArray= new String[sizeOfOutput];
         j=0;
        String temp="";
        for (char c : newArray) {
            if (Character.isWhitespace(c)) {
                finalStringArray[j] = temp.trim();
                j++;
                temp="";
            }
            temp+=c;
        }
        finalStringArray[j]=temp.trim();

        return  finalStringArray;

    }

    static String  capFirstChar(String input){
        return  input.substring(0, 1).toUpperCase() + input.substring(1);

    }

    static String[] uniqueWords(String input){
        int arraySize=1;
        for(int i=0; i<input.length();i++){
           if(input.charAt(i)==' ')
                arraySize+=1;
        }

        String [] notUniqueArray= new String[arraySize];
        String temp="";
        int j=0;
        for(int i=0; i<input.length();i++){
            if(input.charAt(i)==' '){
                notUniqueArray[j]=temp.trim();
                temp="";
                j++;
            }
            temp+=input.charAt(i);
        }
        notUniqueArray[j]=temp.trim();
        String [] uniqueArray={ };
        String [] oldArr;
        oldArr=notUniqueArray;

        // I know there is a Java function to remove duplicates however
        // I tried to minimize the use of java 8 classes for this exercise
        for(int i=0;i<notUniqueArray.length;i++){
            uniqueArray =removeDuplicates(oldArr,notUniqueArray[i]);
            oldArr=uniqueArray;
        }

        return uniqueArray;

    }

// Function to remove duplicates for uniqueWords
    static String [] removeDuplicates(String[] oldArr, String word){
        int duplicate=0;
        for(int i=0;i<oldArr.length;i++){
            if(oldArr[i].equals(word)){
                duplicate+=1;
            }
        }

        if (duplicate <=1){
            return  oldArr;
        }
        String[] newArr=new String[(oldArr.length-duplicate+1)];
        boolean wordAlreadyAdded=false;
        int j=0;
        for(int i=0;i<oldArr.length;i++){
            if(oldArr[i].equals(word)==false|| wordAlreadyAdded==false){
                newArr[j]=oldArr[i];
                j+=1;
                if(oldArr[i].equals(word))
                    wordAlreadyAdded=true;
            }
        }

        return newArr;

    }




}