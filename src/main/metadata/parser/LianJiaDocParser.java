package main.metadata.parser;

import java.util.ArrayList;
import java.util.List;

import main.metadata.metadata.LianJiaHouse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.net.NetUtils;

public class LianJiaDocParser {
	
	private static String houseListSelector = "body .content .leftContent .sellListContent li";
	
	public static List<LianJiaHouse> getHouseList(Document doc){
		List<LianJiaHouse> list = new ArrayList<LianJiaHouse>();
		Elements lis = doc.select(houseListSelector);
		for(Element li : lis){
			try{
				LianJiaHouse house = new LianJiaHouse();
				String houseId = li.getElementsByClass("title").select("a").attr("data-housecode");
				if(houseId == null || houseId.isEmpty()) {
					continue;
				}
				String houseTitle =li.getElementsByClass("title").select("a").text();
				String houseURL = li.getElementsByClass("title").select("a").attr("href");
				String regionURL = li.getElementsByClass("address").select("a").attr("href");
				final String[] addresses = li.getElementsByClass("address").text().split("/");
				String houseLocation = addresses[0];
				String houseRoom =  "";
                if (addresses.length >= 2) {
                    houseRoom = addresses[1];
                }
				String houseArea = "";
                if (addresses.length >= 3) {
                    houseArea = addresses[2].replace("平米", "");
                }
				String houseDirection = "";
                if (addresses.length >= 4) {
                    houseDirection = addresses[3];
                }
				String houseDecoration = "";
				if (addresses.length >= 5) {
					houseDecoration = addresses[4];
				}
				String elevator = "";
				if (addresses.length >= 6) {
					elevator = addresses[5];
				}
				final String[] positionInfos = li.getElementsByClass("positionInfo").text().split("/");
				String houseHeight = positionInfos[0];
				final String[] houseBuildYearTypes = positionInfos[1].split("年建");
				String houseBuildYear = houseBuildYearTypes[0];
				String houseBuildType = houseBuildYearTypes[1];
				String positionName = positionInfos[2];
				String positionURL = li.getElementsByClass("positionInfo").select("a").attr("href");
				String taxFree = li.getElementsByClass("taxfree").text();
				String hasKey = li.getElementsByClass("haskey").text();
				String housePrice =li.getElementsByClass("totalPrice").text();
				String unitPrice =li.getElementsByClass("unitPrice").text()
						.replace("单价", "").replace("元/平米", "");


				house.setHouseDecoration(houseDecoration);
				house.setElevator(elevator);
				house.setPositionURL(positionURL);
				house.setPositionName(positionName);
				house.setTaxFree(taxFree);
				house.setHasKey(hasKey);
				house.setHouseId(houseId);
				house.setHouseTitle(houseTitle);
				house.setHouseRegion(houseLocation);
				house.setHouseRoom(houseRoom);
				house.setHouseArea(houseArea);
				house.setHouseDirection(houseDirection);
				house.setHousePrice(housePrice);
				house.setUnitPrice(unitPrice);
				house.setHouseURL(houseURL);
				house.setRegionURL(regionURL);
				house.setHouseType(houseBuildType);
				house.setHouseHeight(houseHeight);
				house.setHouseBuildType(houseBuildType);
				house.setHouseBuildYear(houseBuildYear);
				list.add(house);
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}

		return list;
	}
}
