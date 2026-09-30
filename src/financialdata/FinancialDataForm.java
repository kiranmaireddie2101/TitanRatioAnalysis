package financialdata;

import javax.swing.*;
import java.awt.*;

public class FinancialDataForm extends JFrame {

    private JTextField yearField;
    private JTextField currentAssetsField;
    private JTextField currentLiabilitiesField;
    private JTextField inventoryField;
    private JTextField totalDebtField;
    private JTextField shareholdersEquityField;
    private JTextField revenueField;
    private JTextField grossProfitField;
    private JTextField netProfitField;

    public FinancialDataForm() {

        setTitle("Titan Company - Enter Financial Data");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 10, 10));

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Financial Year:"));
        yearField = new JTextField();
        panel.add(yearField);

        panel.add(new JLabel("Current Assets:"));
        currentAssetsField = new JTextField();
        panel.add(currentAssetsField);

        panel.add(new JLabel("Current Liabilities:"));
        currentLiabilitiesField = new JTextField();
        panel.add(currentLiabilitiesField);

        panel.add(new JLabel("Inventory:"));
        inventoryField = new JTextField();
        panel.add(inventoryField);

        panel.add(new JLabel("Total Debt:"));
        totalDebtField = new JTextField();
        panel.add(totalDebtField);

        panel.add(new JLabel("Shareholders' Equity:"));
        shareholdersEquityField = new JTextField();
        panel.add(shareholdersEquityField);

        panel.add(new JLabel("Revenue:"));
        revenueField = new JTextField();
        panel.add(revenueField);

        panel.add(new JLabel("Gross Profit:"));
        grossProfitField = new JTextField();
        panel.add(grossProfitField);

        panel.add(new JLabel("Net Profit:"));
        netProfitField = new JTextField();
        panel.add(netProfitField);

        JButton saveButton = new JButton("Save Financial Data");
        panel.add(saveButton);

        JButton closeButton = new JButton("Close");
        panel.add(closeButton);

        saveButton.addActionListener(e -> saveData());

        closeButton.addActionListener(e -> dispose());

        add(panel);
        setVisible(true);
    }

    private void saveData() {

        try {

            String year = yearField.getText();

            double currentAssets =
                    Double.parseDouble(currentAssetsField.getText());

            double currentLiabilities =
                    Double.parseDouble(currentLiabilitiesField.getText());

            double inventory =
                    Double.parseDouble(inventoryField.getText());

            double totalDebt =
                    Double.parseDouble(totalDebtField.getText());

            double shareholdersEquity =
                    Double.parseDouble(shareholdersEquityField.getText());

            double revenue =
                    Double.parseDouble(revenueField.getText());

            double grossProfit =
                    Double.parseDouble(grossProfitField.getText());

            double netProfit =
                    Double.parseDouble(netProfitField.getText());

            FinancialData data = new FinancialData(
                    year,
                    currentAssets,
                    currentLiabilities,
                    inventory,
                    totalDebt,
                    shareholdersEquity,
                    revenue,
                    grossProfit,
                    netProfit
            );

            FinancialDataDAO dao = new FinancialDataDAO();

            boolean success = dao.insertFinancialData(data);

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Financial Data Saved Successfully!"
                );

                clearFields();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to save financial data."
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers in all financial fields."
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    private void clearFields() {

        yearField.setText("");
        currentAssetsField.setText("");
        currentLiabilitiesField.setText("");
        inventoryField.setText("");
        totalDebtField.setText("");
        shareholdersEquityField.setText("");
        revenueField.setText("");
        grossProfitField.setText("");
        netProfitField.setText("");
    }
}