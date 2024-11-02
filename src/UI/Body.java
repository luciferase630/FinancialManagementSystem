package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Body {
    private JFrame mainFrame;

    public Body() {
        initialize();
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

    private void enterFinanceData() {
        JFrame dataEntryFrame = new JFrame("财务数据录入");
        dataEntryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataEntryFrame.setSize(400, 300);
        dataEntryFrame.setLayout(new GridLayout(4, 2));

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
                    if (amount == 0) {
                        throw new NumberFormatException("金额不能为零");
                    }
                    // 这里可以添加将数据保存到CSV的逻辑
                    JOptionPane.showMessageDialog(dataEntryFrame, "录入成功: " + category + " - " + amount);
                    dataEntryFrame.dispose(); // 关闭数据录入界面
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dataEntryFrame, "请输入有效的金额!", "错误", JOptionPane.ERROR_MESSAGE);
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

        try (BufferedReader br = new BufferedReader(new FileReader("finance_data.csv"))) {
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
