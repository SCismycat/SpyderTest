import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by Leslee on 2018/7/20.
 */
//url管理器，通过其从第一个页面开始获取所需url，不断解析相关的url并获取新的url
public class URLManager {
    int i = 0;
    public void getNewURL(List<String> urls) throws IOException{
        Document document = ConnectNet.getDom(urls.get(i));
        i += 1;
        Elements links = document.select("[href*=/item]");
        for (Element link:links){
            String url = "https://baike.baidu.com" + link.attr("href");
            if (!urls.contains(url)){
                urls.add(url);
            }
        }
    }
}
