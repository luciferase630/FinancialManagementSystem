package finance;

import java.time.LocalDate;

public class FinanceDataEntry {
    private FinanceDataManager financeDataManager;

    // 构造函数
    public FinanceDataEntry(FinanceDataManager manager) {
        this.financeDataManager = manager;
    }

    // 数据录入功能
    public boolean enterData(String type, double amount, String description) {
        if (amount <= 0) {
            return false; // 金额无效
        }

        // 创建新财务数据并添加
        FinanceData financeData = new FinanceData(type, amount, LocalDate.now(), description);
        financeDataManager.addFinanceData(financeData);
        return true; // 录入成功
    }
}
