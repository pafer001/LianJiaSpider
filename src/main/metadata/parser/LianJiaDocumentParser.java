package main.metadata.parser;

import com.google.common.collect.Lists;
import main.metadata.URLBuilder;
import main.metadata.metadata.LianJiaHouse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.net.NetUtils;

import java.util.ArrayList;
import java.util.List;

public class LianJiaDocumentParser {


    public static void main(String[] args) {



        try {

            List<LianJiaHouse> AllLianJiaHouses = Lists.newArrayList();
            String URL = URLBuilder.getNextAreaUrl("");
            String content = NetUtils.httpGet(URL);
            Document doc = Jsoup.parse(content);

            final List<LianJiaHouse> houseList = LianJiaDocParser.getHouseList(doc);
            System.out.println(houseList);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
