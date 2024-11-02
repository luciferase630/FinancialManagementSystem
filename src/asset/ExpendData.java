package asset;

import java.util.Date;

public class ExpendData {
    private double money;//金额
    private String type;//类别
    private Date date;//交易日期
    public ExpendData(double money,String type,Date date){
        this.money = money;
        this.type = type;
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }
}
