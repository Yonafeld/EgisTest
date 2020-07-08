import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class Part2
{
    public static void main(String[] args)
    {
        String DocumentInHtml  = GetUrlContents("https://github.com/egis/handbook/blob/master/Tech-Stack.md");

        String HTMLToBePassed=DocumentInHtml;
        Document HTMLData = Jsoup.parse(HTMLToBePassed);
        HashMap<String, String> ResultsMap = new HashMap<String, String>();
        ResultsMap=GetRelevantData(HTMLData);

        Gson gson = new Gson();
        String DataInJsonFormat = gson.toJson(ResultsMap);
        System.out.println(DataInJsonFormat);

    }

    private static String GetUrlContents(String URLWebsite)
    {
        StringBuilder WebPageContent = new StringBuilder();
        try
        {
            URL url = new URL(URLWebsite);
            URLConnection Connection = url.openConnection();
            BufferedReader BufferedReader = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
            String line;
            while ((line = BufferedReader.readLine()) != null)
            {
                WebPageContent.append(line + "\n");
            }
            BufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return WebPageContent.toString();
    }

    private static  HashMap<String, String> GetRelevantData(Document html){
        HashMap<String, String> result= new HashMap<String, String>();
        String Area="";
        int start=0;
        int finish=75;
        int increment=3;
        for (int i=1;i<4;i++) {
            if (i == 2) {
                start = 78;
                finish = 126;
                increment = 4;
            }
            if (i == 3) {
                start = 126;
                finish = 183;
                increment = 3;
            }
            Area = html.getElementsByTag("h2").get(i).text();
            String temp = "";
            for (int j = start; j <= finish; j += increment) {
                temp = html.getElementsByTag("td").get(j).text();
                result.put(temp, Area);
            }
        }
        return  result;
    }

}