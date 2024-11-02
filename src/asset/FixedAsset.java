package asset;

import java.util.Date;

public class FixedAsset {
    private String name;//资产名字
    private String type;//资产类型
    private Date date;//购买日期
    private double value;//价值

    public FixedAsset(String name,String type,Date date,double value){
        this.name = name;
        this.type = type;
        this.date = date;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }


}
