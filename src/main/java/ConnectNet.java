import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Leslee on 2018/7/20.
 */
//解析url获取的html网页
public class ConnectNet {
    public static Document getDom(String url) throws IOException{
        Document document = Jsoup.connect(url).get();
        return document;
    }
}
