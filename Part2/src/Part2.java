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
        String docInHtml  = getUrlContents("https://github.com/egis/handbook/blob/master/Tech-Stack.md");

        String HTMLSTring=docInHtml;
        Document html = Jsoup.parse(HTMLSTring);
        HashMap<String, String> resultsMap = new HashMap<String, String>();
        resultsMap=getRelevantData(html);

        Gson gson = new Gson();
        String resultJson = gson.toJson(resultsMap);
        System.out.println(resultJson);

    }

    private static String getUrlContents(String urlWebsite)
    {
        StringBuilder urlContent = new StringBuilder();
        try
        {
            URL url = new URL(urlWebsite);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                urlContent.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return urlContent.toString();
    }

    private static  HashMap<String, String> getRelevantData(Document html){
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