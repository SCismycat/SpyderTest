import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

/**
 * Created by Leslee on 2018/7/20.
 */
/*
对Html标签进行解析，提取出对应的内容（包含url和内容）
 */

public class ParseHtml {
    int num = 1;
    public void parse_a(Document document , List<String> urls) throws IOException{
        //通过select选择标签为div的内容
        Elements links = document.select("div.lemma-summary");
        //很多div标签，for循环保存。
        for(Element link:links){
            Elements Link = link.getElementsByTag("a");
            for (Element lin : Link){
                Elements li = lin.select("[href*=/item]");
                for (Element l:li){
                    System.out.println(l.attr("href"));
                    String url = "https://baike.baidu.com" + l.attr("href");
                    if (!urls.contains(url)){
                        System.out.println(url);
                        urls.add(url);
                    }
                }
            }
        }
    }
    public void parse_content(Document document, List<String> contents){
        //爬取lemma-summary中的内容
        Elements links = document.select("div.lemma-summary");
        //循环获取其中文字内容
        for (Element link:links){
            contents.add(link.text());
        }
    }

}
