package finance;

import java.util.ArrayList;
import java.util.List;

public class FinanceDataManager {
    private List<FinanceData> financeDataList; // 财务数据列表

    // 构造函数
    public FinanceDataManager() {
        financeDataList = new ArrayList<>();
    }

    // 添加财务数据
    public void addFinanceData(FinanceData data) {
        financeDataList.add(data);
    }

    // 获取所有财务数据
    public List<FinanceData> getAllFinanceData() {
        return financeDataList;
    }

    // 可以添加其他功能，比如删除、编辑财务数据等
}
