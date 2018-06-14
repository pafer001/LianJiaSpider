package main.metadata.parser;

import main.metadata.metadata.LianJiaHouse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.net.NetUtils;

import java.util.List;

public class LianJiaDocumentParser {


    public static void main(String[] args) {

        try {
            String URL = "https://bj.lianjia.com/ershoufang/bp0ep300ba0ea20000/";
            String content = NetUtils.httpGet(URL);
            Document doc = Jsoup.parse(content);

            final List<LianJiaHouse> houseList = LianJiaDocParser.getHouseList(doc);
            System.out.println(houseList);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
