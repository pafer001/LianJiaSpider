package main.metadata.metadata;

public class LianJiaHouse {
    private String houseId;
    private String houseTitle;
    //区域，小区
    private String houseRegion;
    private String houseRoom;
    private String houseArea;
    //方向
    private String houseDirection;
    //装修
    private String houseDecoration;
    //电梯
    private String elevator;
    private String housePrice;
    private String unitPrice;
    private String houseURL;
    private String regionURL;
    private String houseType;
    //楼层
    private String houseHeight;
    private String houseBuildYear;
    //塔楼
    private String houseBuildType;
    //房本满五年
    private String taxFree;
    //随时看房
    private String hasKey;

    private String positionName;
    private String positionURL;


    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseHeight() {
        return houseHeight;
    }

    public void setHouseHeight(String houseHeight) {
        this.houseHeight = houseHeight;
    }

    public String getHouseBuildYear() {
        return houseBuildYear;
    }

    public void setHouseBuildYear(String houseBuildYear) {
        this.houseBuildYear = houseBuildYear;
    }

    public String getHouseBuildType() {
        return houseBuildType;
    }

    public void setHouseBuildType(String houseBuildType) {
        this.houseBuildType = houseBuildType;
    }

    public String getHouseURL() {
        return houseURL;
    }

    public void setHouseURL(String houseURL) {
        this.houseURL = houseURL;
    }

    public String getRegionURL() {
        return regionURL;
    }

    public void setRegionURL(String regionURL) {
        this.regionURL = regionURL;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public String getUnitPrice() {
        return unitPrice.replace(" 元/m²", "");
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseTitle() {
        return houseTitle;
    }

    public void setHouseTitle(String houseTitle) {
        this.houseTitle = houseTitle;
    }

    public String getHouseRegion() {
        return houseRegion;
    }

    public void setHouseRegion(String houseRegion) {
        this.houseRegion = houseRegion;
    }

    public String getHouseRoom() {
        return houseRoom;
    }

    public void setHouseRoom(String houseRoom) {
        this.houseRoom = houseRoom;
    }

    public String getHouseArea() {
        return houseArea.replace("平米", "");
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseDirection() {
        return houseDirection;
    }

    public void setHouseDirection(String houseDirection) {
        this.houseDirection = houseDirection;
    }

    public String getHouseDecoration() {
        return houseDecoration;
    }

    public void setHouseDecoration(String houseDecoration) {
        this.houseDecoration = houseDecoration;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getTaxFree() {
        return taxFree;
    }

    public void setTaxFree(String taxFree) {
        this.taxFree = taxFree;
    }

    public String getHasKey() {
        return hasKey;
    }

    public void setHasKey(String hasKey) {
        this.hasKey = hasKey;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionURL() {
        return positionURL;
    }

    public void setPositionURL(String positionURL) {
        this.positionURL = positionURL;
    }

    @Override
    public String toString() {
        return "LianJiaHouse{" +
                "houseId='" + houseId + '\'' +
                ", houseTitle='" + houseTitle + '\'' +
                ", houseRegion='" + houseRegion + '\'' +
                ", houseRoom='" + houseRoom + '\'' +
                ", houseArea='" + houseArea + '\'' +
                ", houseDirection='" + houseDirection + '\'' +
                ", houseDecoration='" + houseDecoration + '\'' +
                ", elevator='" + elevator + '\'' +
                ", housePrice='" + housePrice + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", houseURL='" + houseURL + '\'' +
                ", regionURL='" + regionURL + '\'' +
                ", houseType='" + houseType + '\'' +
                ", houseHeight='" + houseHeight + '\'' +
                ", houseBuildYear='" + houseBuildYear + '\'' +
                ", houseBuildType='" + houseBuildType + '\'' +
                ", taxFree='" + taxFree + '\'' +
                ", hasKey='" + hasKey + '\'' +
                ", positionName='" + positionName + '\'' +
                ", positionURL='" + positionURL + '\'' +
                '}';
    }
}
