package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Body {
    private JFrame mainFrame;
    private static final String FILE_NAME = "finance_data.csv";

    public Body() {
        initialize();
        initializeCSVFile(); // 初始化 CSV 文件
    }

    private void initialize() {
        mainFrame = new JFrame("主菜单");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1)); // 3行布局

        JButton enterDataButton = new JButton("录入财务数据");
        JButton viewDataButton = new JButton("查看收支信息");
        JButton exitButton = new JButton("退出");

        enterDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterFinanceData(); // 进入财务数据录入功能
            }
        });

        viewDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFinanceData(); // 进入查看收支信息功能
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose(); // 关闭主菜单
            }
        });

        mainFrame.add(enterDataButton);
        mainFrame.add(viewDataButton);
        mainFrame.add(exitButton);
        mainFrame.setVisible(true);
    }

    private void initializeCSVFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                // 创建 CSV 文件并写入表头
                FileWriter writer = new FileWriter(FILE_NAME);
                writer.write("类别,金额,日期,描述\n"); // CSV 表头
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void enterFinanceData() {
        JFrame dataEntryFrame = new JFrame("财务数据录入");
        dataEntryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataEntryFrame.setSize(400, 300);
        dataEntryFrame.setLayout(new GridLayout(5, 2)); // 调整为5行布局

        JTextField categoryField = new JTextField();
        JTextField amountField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField descriptionField = new JTextField();

        dataEntryFrame.add(new JLabel("输入类别:"));
        dataEntryFrame.add(categoryField);
        dataEntryFrame.add(new JLabel("输入金额:"));
        dataEntryFrame.add(amountField);
        dataEntryFrame.add(new JLabel("输入日期 (YYYY-MM-DD):"));
        dataEntryFrame.add(dateField);
        dataEntryFrame.add(new JLabel("输入描述:"));
        dataEntryFrame.add(descriptionField);

        JButton submitButton = new JButton("提交");
        dataEntryFrame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String category = categoryField.getText();
                double amount;

                try {
                    amount = Double.parseDouble(amountField.getText());
                    if (amount <= 0) {
                        throw new NumberFormatException("金额必须大于零");
                    }

                    // 保存到 CSV 文件
                    try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
                        writer.write(category + "," + amount + "," + dateField.getText() + "," + descriptionField.getText() + "\n");
                    }

                    JOptionPane.showMessageDialog(dataEntryFrame, "录入成功: " + category + " - " + amount);
                    dataEntryFrame.dispose(); // 关闭数据录入界面
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dataEntryFrame, "请输入有效的金额!", "错误", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(dataEntryFrame, "保存数据时出错。", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dataEntryFrame.setVisible(true);
    }

    private void viewFinanceData() {
        JFrame viewFrame = new JFrame("收支信息");
        viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewFrame.setSize(400, 300);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
            textArea.setText("无法读取收支信息文件。");
        }

        viewFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        viewFrame.setVisible(true);
    }
}
