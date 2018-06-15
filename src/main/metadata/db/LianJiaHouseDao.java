package main.metadata.db;

import com.google.common.collect.Collections2;
import main.metadata.metadata.LianJiaHouse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class LianJiaHouseDao {

    static String INSERT_LIAN_JIA_SQL = "REPLACE INTO t_lianjia_house(houseId, houseTitle, houseRegion, houseRoom, houseArea, " +
            "houseDirection, houseDecoration, elevator, housePrice, unitPrice, houseURL, regionURL, " +
            "  houseType, houseHeight, houseBuildYear, houseBuildType, taxFree," +
            " hasKey, positionName, positionURL)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


    public static void updateLianjiaHouse(List<LianJiaHouse> lianJiaHouseList) {
        PreparedStatement pstmt1= null;
        Connection connection = null;
        try {
            System.out.println("insert size " + lianJiaHouseList.size());
            if (lianJiaHouseList.isEmpty()) {
                return;
            }

            connection = C3P0Cnn.getConnection();

            pstmt1= connection.prepareStatement(INSERT_LIAN_JIA_SQL);
            for (LianJiaHouse lianJiaHouse : lianJiaHouseList) {
                pstmt1.setString(1, lianJiaHouse.getHouseId());
                pstmt1.setString(2, lianJiaHouse.getHouseTitle());
                pstmt1.setString(3, lianJiaHouse.getHouseRegion());
                pstmt1.setString(4, lianJiaHouse.getHouseRoom());
                pstmt1.setString(5, lianJiaHouse.getHouseArea());
                pstmt1.setString(6, lianJiaHouse.getHouseDirection());
                pstmt1.setString(7, lianJiaHouse.getHouseDecoration());
                pstmt1.setString(8, lianJiaHouse.getElevator());

                pstmt1.setString(9, lianJiaHouse.getHousePrice());
                pstmt1.setString(10, lianJiaHouse.getUnitPrice());
                pstmt1.setString(11, lianJiaHouse.getHouseURL());
                pstmt1.setString(12, lianJiaHouse.getRegionURL());
                pstmt1.setString(13, lianJiaHouse.getHouseType());
                pstmt1.setString(14, lianJiaHouse.getHouseHeight());
                pstmt1.setString(15, lianJiaHouse.getHouseBuildYear());
                pstmt1.setString(16, lianJiaHouse.getHouseBuildType());

                pstmt1.setString(17, lianJiaHouse.getTaxFree());
                pstmt1.setString(18, lianJiaHouse.getHasKey());
                pstmt1.setString(19, lianJiaHouse.getPositionName());
                pstmt1.setString(20, lianJiaHouse.getPositionURL());
                pstmt1.executeUpdate();//这才是向数据库发送语句
            }
//            connection.commit();//提交一下下
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt1 != null) {
                    pstmt1.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
