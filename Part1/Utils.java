public class Utils {

    static String DateBaseSafeName(String nameEntered){
        char[] NameAsArray = nameEntered.toCharArray();
        char [] ArrayForNewName=new char[nameEntered.length()];
        int j=0;
        for (char i : NameAsArray) {
            if(Character.isLetter(i)&& !Character.isWhitespace(i)){
                ArrayForNewName[j]=i;
            }
            if(Character.isWhitespace(i)){
                ArrayForNewName[j]='_';
            }
            j++;
        }
        String NameForDataBase = new String(ArrayForNewName);
        return NameForDataBase.trim();
    }

    static  String [] split(String sentenceToSplit,String parameter1,String parameter2,String parameter3) {
        char split1=parameter1.charAt(0);
        char split2=parameter2.charAt(0);
        char split3=parameter3.charAt(0);
        char[] InputAsArray = sentenceToSplit.toCharArray();
        char [] ArrayForSplit=new char[sentenceToSplit.length()];
        int j=0;
        for (char i : InputAsArray) {
            if(i==split1 || i==split2 || i==split3){
                ArrayForSplit[j]=' ';
            }
            else{ ArrayForSplit[j]=i; }
            j++;
        }

        int SizeOfOutput=1;
        for (char i: ArrayForSplit){
            if (Character.isWhitespace(i))
            {
                SizeOfOutput+=1;
            }
        }
        String [] FinalArrayOfWords= new String[SizeOfOutput];
         j=0;
        String temp="";
        for (char i : ArrayForSplit) {
            if (Character.isWhitespace(i)) {
                FinalArrayOfWords[j] = temp.trim();
                j++;
                temp="";
            }
            temp+=i;
        }
        FinalArrayOfWords[j]=temp.trim();
        return  FinalArrayOfWords;

    }

    static String  CapFirstChar(String InputEntered){
        return  InputEntered.substring(0, 1).toUpperCase() + InputEntered.substring(1);

    }

    static String[] UniqueWords(String SentenceEntered){
        int ArraySize=1;
        for(int i=0; i<SentenceEntered.length();i++){
           if(SentenceEntered.charAt(i)==' ')
                ArraySize+=1;
        }

        String [] NotUniqueWords= new String[ArraySize];
        String temp="";
        int j=0;
        for(int i=0; i<SentenceEntered.length();i++){
            if(SentenceEntered.charAt(i)==' '){
                NotUniqueWords[j]=temp.trim();
                temp="";
                j++;
            }
            temp+=SentenceEntered.charAt(i);
        }
        NotUniqueWords[j]=temp.trim();

        String [] UniqueArrayOfWords={ };
        String [] PreviousArrary;
        PreviousArrary=NotUniqueWords;

        // I know there is a Java function to remove duplicates however
        // I tried to minimize the use of java 8 classes for this exercise
        for(int i=0;i<NotUniqueWords.length;i++){
            UniqueArrayOfWords=RemoveDuplicates(PreviousArrary,NotUniqueWords[i]);
            PreviousArrary=UniqueArrayOfWords;
        }

        return UniqueArrayOfWords;

    }

// Function to remove duplicates for uniqueWords
    static String [] RemoveDuplicates(String[] PreviousArrary, String word){
        int duplicate=0;
        for(int i=0;i<PreviousArrary.length;i++){
            if(PreviousArrary[i].equals(word)){
                duplicate+=1;
            }
        }

        if (duplicate <=1){
            return  PreviousArrary;
        }
        String[] UniqueArray=new String[(PreviousArrary.length-duplicate+1)];
        boolean wordAlreadyAdded=false;
        int j=0;
        for(int i=0;i<PreviousArrary.length;i++){
            if(PreviousArrary[i].equals(word)==false|| wordAlreadyAdded==false){
                UniqueArray[j]=PreviousArrary[i];
                j+=1;
                if(PreviousArrary[i].equals(word))
                    wordAlreadyAdded=true;
            }
        }

        return UniqueArray;

    }




}
