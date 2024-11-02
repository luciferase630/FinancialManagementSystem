package finance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private List<FinanceData> financeDataList;
    private static final String FILE_NAME = "finance_data.csv";

    public FinanceManager() {
        financeDataList = new ArrayList<>();
    }

    public void addFinanceData(FinanceData financeData) {
        financeDataList.add(financeData);
        saveToCSV(financeData);
    }

    private void saveToCSV(FinanceData financeData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(financeData.getCategory() + "," +
                    financeData.getAmount() + "," +
                    financeData.getDate() + "," +
                    financeData.getDescription());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
