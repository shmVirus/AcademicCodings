import java.io.*;   //? import java.io.BufferedReader | import java.io.IOException | import java.io.InputStreamReader;
import java.net.*;  //? import java.net.HttpURLConnection | import java.net.MalformedURLException | import java.net.URL;

public class Task__1__getMethod {
  public static void main(String[] args) throws MalformedURLException, IOException, ProtocolException {
    URL getURL = new URL("http://webcode.me/");
    HttpURLConnection setConnection = (HttpURLConnection) getURL.openConnection();

    setConnection.setRequestMethod("GET");
    int responseCode = setConnection.getResponseCode();
    
    if (responseCode == HttpURLConnection.HTTP_OK) {
      System.out.print("\033[36;1mResponse Code:\033[0m " + "\033[3;5m" + responseCode + "\033[0m\n");
      System.out.print("\033[36;1mResponse Message:\033[0m " + "\033[3;5m" + setConnection.getResponseMessage() + "\033[0m\n");

      InputStreamReader input = new InputStreamReader(setConnection.getInputStream());  // stores contents from URL
      BufferedReader buffer = new BufferedReader(input);  // buffers for reading content of server
      StringBuffer responseString = new StringBuffer();   // stores each line from the buffer
      String eachLine = null;

      while ((eachLine = buffer.readLine()) != null) {
        responseString.append("\t");
        responseString.append(eachLine);
        responseString.append(System.lineSeparator());
      }
      buffer.close();
      System.out.print("\033[32;1mFetched Page:\033[0m\n" + "\033[3m" + responseString + "\033[0m\n");

      /*
       * The following lines of code can parse the HTML document into String
       Document document = Jsoup.parse(responseString);
       String title = document.title();
       System.out.println("Title:\n" + title);
       String body = doc.body().text();
       System.out.println("Body:\n" + body);

       ? But above lines of code requires following packages
       import org.jsoup.Jsoup;
       import org.jsoup.nodes.Document;
       
       ! Couldn't import those (external) packages, so wasn't possible to parse for this task.
       */
    }
  }
}