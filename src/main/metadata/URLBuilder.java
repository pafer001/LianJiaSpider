package main.metadata;

import com.google.common.collect.Lists;

import java.util.List;

public class URLBuilder {

    static List<String> areas = Lists.newArrayList("dongcheng", "xicheng", "chaoyang", "haidian",
            "fengtai", "shijingshan", "tongzhou", "changping", "daxing", "yizhuangkaifaqu",
    "shunyi", "fangshan", "mentougou", "pinggu", "huairou", "miyun", "yanqing");

    static String URL = "https://bj.lianjia.com/ershoufang/%s/%s";

    public static String getAreaLastPageUrl(String area, int page){
        return String.format(URL, area, "pg" + (page + 1));
    }

    public static String getNextArea(String area) {
        if (area.isEmpty()) {
            area = areas.get(0);
        } else {
            int i = area.indexOf(area);
            if (i >= areas.size() -1) {
                return "";
            }
            area = areas.get(i +1);
        }
        return area;
    }

    public static String getNextAreaUrl(String area) {

        String nextArea = getNextArea(area);
        return String.format(URL, nextArea,  "pg"+1);
    }


    public static void main(String[] args) {

        String nextAreaUrl = getNextAreaUrl("");
        System.out.println(nextAreaUrl);
    }


}
