package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo01.class.getClassLoader().getResource("a.xml").getPath();
//        Document document = Jsoup.parse(new File(path), "utf-8");
//        Elements element = document.getElementsByTag("name");
//        System.out.println(element.size());
//        Element element1 = element.get(0);
//        String name = element1.text();
//        System.out.println(name);

//        URL url = new URL("https://www.baidu.com/");
//        Document document = Jsoup.parse(url, 5000);
//        System.out.println(document);

        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements ele1 = document.select("name");
        System.out.println(ele1.get(0));
        System.out.println("===============");
        Elements ele2 = document.select("user[id=\"2\"] >age");
        System.out.println(ele2);
        System.out.println("===============");
        Elements ele3 = document.select("name[number=\"a_001\"]");
        System.out.println(ele3);
        System.out.println(ele3.text());

    }
}
