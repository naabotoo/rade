package scrapper;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rsl_prod_005 on 11/3/15.
 */
public class HtmlUnitImpl {
    private String urlStr;
    private URL url;

    public HtmlUnitImpl(String url){
        this.urlStr = url;
    }

    private URL getUrl(){
        URL url = null;
        try{
            url = new URL(urlStr);
        } catch (MalformedURLException ex){
            ex.printStackTrace();
        }
        return url;
    }

    public String getDataById(String selector){
        String value = null;
        if(StringUtils.isNotBlank(selector)){
            URL urlObj = getUrl();
            WebClient webClient = new WebClient(BrowserVersion.getDefault());
            try {
                HtmlPage page = webClient.getPage(urlObj);
                HtmlDivision division = page.getHtmlElementById("imgBlkFront");
                value = division.asText();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return value;
    }
}
