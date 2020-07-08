import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

public class TestNG {

    @Test
    void TestJoinStrings()
    {
        Text text=new Text();
        String [] WordsToBeChecked={"this"," is"," a"," string"," to"," concatenate"};
        String ExpectedResult="this is a string to concatenate";
        Assert.assertEquals(text.JoinStrings(WordsToBeChecked),ExpectedResult,"String did not match");

    }

    @Test
    void TestStringToDouble()
    {
        Text text=new Text();
        String NumberToBeChecked="500.34";
        Double ExpectedResult=500.34;
        Assert.assertEquals(text.StringToDouble(NumberToBeChecked),ExpectedResult,"string and double did not match");

    }
    @Test
    void TestDateToString()
    {
        Text text=new Text();
        Date DateToBeChecked = Calendar.getInstance().getTime();
        Assert.assertEquals((text.DateToString(DateToBeChecked)).getClass().getSimpleName(),"String",
                "Date has not been changed to a string");

    }

    @Test
    void TestIsInt()
    {
        Is is =new Is();
        double ValueToBeChecked=200;
        Assert.assertTrue(is.IsInt(ValueToBeChecked),"integer cant be evaluated");

    }
    @Test
    void TestIsDouble()
    {
        Is is =new Is();
        double ValueToBeChecked=537.989;
        Assert.assertTrue(is.IsDouble(ValueToBeChecked),"Double cant be evaluated");

    }

    @Test
    void TestIsEmail()
    {
        Is is =new Is();
        String EmailToBeChecked="Yon@gmail.com";
        Assert.assertTrue(is.IsEmail(EmailToBeChecked),"email address is wrong");

    }

    @Test
    void TestIsobjEmpty()
    {
        Is is =new Is();
        String [] ObjectToBeChecked={};
        Assert.assertTrue(is.IsObjEmpty(ObjectToBeChecked),"object failed test");

    }

    @Test
    void TestDateBaseSafe()
    {
        Utils UTILS= new Utils();
        String NameToBeConverted="Some name345@";
        String ExpectedResult="Some_name";;
        Assert.assertEquals((UTILS.DateBaseSafeName(NameToBeConverted)),ExpectedResult,
                "Database name is not changed correctly");


    }

    @Test
    void TestSplit()
    {
        Utils UTILS= new Utils();
        String Sentence="Four,score-and,seven|years-ago";
        String [] ExpectedResult={"Four","score","and","seven","years","ago"};
        Assert.assertEquals(UTILS.split(Sentence,",","-","|"),ExpectedResult,
                "Element of the array do not match the correct words");


    }

    @Test
    void TestUniqueWords()
    {
        Utils UTILS= new Utils();
        String Sentence="This is a a sentence sentence with duplicate words words";
        String [] ExpectedResult={"This","is","a","sentence","with","duplicate","words"};
        Assert.assertEquals(UTILS.UniqueWords(Sentence),ExpectedResult,
                "Element of the array do not match the correct words");


    }

}
