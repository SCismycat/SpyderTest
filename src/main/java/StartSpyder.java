import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leslee on 2018/7/20.
 */
public class StartSpyder {
    public static void main(String[] args) throws IOException {
        String rooturl = "https://baike.baidu.com/item/python";

        Document rootdocument = Jsoup.connect(rooturl).get();
        int index = 1;
        ParseHtml parseHtml = new ParseHtml();
        ConnectNet connectNet = new ConnectNet();
        SaveContent saveContent = new SaveContent();
        //存储要迭代的url
        List<String> urls = new ArrayList<String>();
        //放置简介字符串
        List<String> contents = new ArrayList<String>();

        parseHtml.parse_a(rootdocument, urls);
        URLManager urlManager = new URLManager();
        int flag = 1;
        //首先判断url集合里面是否还有可以爬取的页面，然后按照顺序获取url，
        //然后urlmanager 继续添加新的url，从提取的url获得dom对象，解析存储，循环爬取。
        while (urls!=null){
            String url = urls.get(index-1);
            index += 1;
            urlManager.getNewURL(urls);
            Document document = connectNet.getDom(url);
            parseHtml.parse_content(document,contents);
            saveContent.saveContent_Csv(contents);
            System.out.println("---开始爬--");
            System.out.println(flag);
            flag+=1;
        }
    }
}
