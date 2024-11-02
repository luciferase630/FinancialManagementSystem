package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Body {
    private JFrame mainFrame;

    public Body() {
        initialize();
    }

    private void initialize() {
        mainFrame = new JFrame("主菜单");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(2, 1)); // 2行布局

        JButton enterDataButton = new JButton("录入财务数据");
        JButton exitButton = new JButton("退出");

        enterDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enterFinanceData(); // 进入财务数据录入功能
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose(); // 关闭主菜单
            }
        });

        mainFrame.add(enterDataButton);
        mainFrame.add(exitButton);
        mainFrame.setVisible(true);
    }

    private void enterFinanceData() {
        JFrame dataEntryFrame = new JFrame("财务数据录入");
        dataEntryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataEntryFrame.setSize(400, 300);
        dataEntryFrame.setLayout(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField amountField = new JTextField();

        dataEntryFrame.add(new JLabel("输入名称:"));
        dataEntryFrame.add(nameField);
        dataEntryFrame.add(new JLabel("输入金额:"));
        dataEntryFrame.add(amountField);

        JButton submitButton = new JButton("提交");
        dataEntryFrame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double amount;

                try {
                    amount = Double.parseDouble(amountField.getText());
                    if (amount == 0) {
                        throw new NumberFormatException("金额不能为零");
                    }
                    JOptionPane.showMessageDialog(dataEntryFrame, "录入成功: " + name + " - " + amount);
                    dataEntryFrame.dispose(); // 关闭数据录入界面
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dataEntryFrame, "请输入有效的金额!", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dataEntryFrame.setVisible(true);
    }
}
