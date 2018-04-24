package test.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.ProtocolVersion;
import org.apache.http.message.BasicHttpRequest;

public class HTTPClient {

  // return code and status !
  public static String GET(String urli) throws IOException {
    if (urli == null)
      return "erreur!";

    URL url = new URL(urli);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    String rep = con.getResponseMessage();
    int code = con.getResponseCode();
    return code + " " + rep;
  }

  // display wish HTTP version
  public static String getVersion(String urli) throws IOException {
    URL url = new URL(urli);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    // HttpVersion ver =
    // (HttpVersion)httpclient.getParams().getParameter("http.protocol.version");
    String httpVersion = url.getProtocol();
    // HttpMethod method = new GetMethod(urli);

    // BasicHttpRequest bhreq = new BasicHttpRequest("GET", urli);
    // // it s not working error java!!
    // ProtocolVersion pvers=bhreq.getProtocolVersion();
    // String ver =bhreq.toString();
    return httpVersion;

  }

  // display the content of the page
  public static StringBuffer getResult(String urli) throws IOException {
    URL url = new URL(urli);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      content.append(inputLine);
    }
    in.close();
    return content;

  }
}
