package main.metadata.parser;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import main.metadata.URLBuilder;
import main.metadata.db.LianJiaHouseDao;
import main.metadata.metadata.LianJiaHouse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import util.net.NetUtils;

import java.util.List;

public class GrabLianJiaData {


    public static void main(String[] args) {

        grabLianJiaData();
    }
    public static void grabLianJiaData() {
        List<LianJiaHouse> allLianJiaHouses = Lists.newArrayList();

        try {

            String nextArea = URLBuilder.getNextArea("");
            int page = 0;
            while (true) {
                System.out.println(nextArea + "  " + page);
                if (Strings.isNullOrEmpty(nextArea)) {
                    return ;
                }
                String URL = URLBuilder.getAreaLastPageUrl(nextArea, page);
                String content = NetUtils.httpGet(URL);
                Document doc = Jsoup.parse(content);

                final List<LianJiaHouse> houseList = LianJiaDocParser.getHouseList(doc);
                if (!houseList.isEmpty()) {
                    allLianJiaHouses.addAll(houseList);
                    if (allLianJiaHouses.size() > 1000) {
                        LianJiaHouseDao.updateLianjiaHouse(allLianJiaHouses);
                        allLianJiaHouses = Lists.newArrayList();
                    }
                }

                if (!houseList.isEmpty() && houseList.size() == 30) {
                    if (page <= 100) {
                        page = page +1;
                        continue;
                    }

                }


                nextArea =  URLBuilder.getNextArea(nextArea);
                page = 0;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ;
    }

}
