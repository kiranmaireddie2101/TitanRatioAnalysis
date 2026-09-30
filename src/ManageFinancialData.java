

import financialdata.FinancialData;
import financialdata.FinancialDataDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ManageFinancialData extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ManageFinancialData() {

        setTitle("Manage Financial Data");
        setSize(1100, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Year");
        model.addColumn("Current Assets");
        model.addColumn("Current Liabilities");
        model.addColumn("Inventory");
        model.addColumn("Total Debt");
        model.addColumn("Equity");
        model.addColumn("Revenue");
        model.addColumn("Gross Profit");
        model.addColumn("Net Profit");

        table = new JTable(model){
        public boolean isCellEditable(int row,int column){
            return false;
        }
    };
        loadData();

        JScrollPane scrollPane = new JScrollPane(table);

        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton refreshButton = new JButton("Refresh");
        JButton closeButton = new JButton("Close");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(closeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        updateButton.addActionListener(e -> updateData());
        deleteButton.addActionListener(e -> deleteData());
        refreshButton.addActionListener(e -> loadData());
        closeButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void loadData() {

        model.setRowCount(0);

        FinancialDataDAO dao = new FinancialDataDAO();

        List<FinancialData> list =
                dao.getAllFinancialData();

        for (FinancialData data : list) {

            model.addRow(new Object[]{
                    data.getId(),
                    data.getFinancialYear(),
                    data.getCurrentAssets(),
                    data.getCurrentLiabilities(),
                    data.getInventory(),
                    data.getTotalDebt(),
                    data.getShareholdersEquity(),
                    data.getRevenue(),
                    data.getGrossProfit(),
                    data.getNetProfit()
            });
        }
    }

    private void updateData() {

        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a record to update."
            );

            return;
        }

        int id = Integer.parseInt(
                model.getValueAt(selectedRow, 0).toString()
        );

        String year = JOptionPane.showInputDialog(
                this,
                "Financial Year:",
                model.getValueAt(selectedRow, 1)
        );

        if (year == null) return;

        try {

            double currentAssets = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Current Assets:",
                            model.getValueAt(selectedRow, 2)
                    )
            );

            double currentLiabilities = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Current Liabilities:",
                            model.getValueAt(selectedRow, 3)
                    )
            );

            double inventory = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Inventory:",
                            model.getValueAt(selectedRow, 4)
                    )
            );

            double totalDebt = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Total Debt:",
                            model.getValueAt(selectedRow, 5)
                    )
            );

            double equity = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Shareholders' Equity:",
                            model.getValueAt(selectedRow, 6)
                    )
            );

            double revenue = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Revenue:",
                            model.getValueAt(selectedRow, 7)
                    )
            );

            double grossProfit = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Gross Profit:",
                            model.getValueAt(selectedRow, 8)
                    )
            );

            double netProfit = Double.parseDouble(
                    JOptionPane.showInputDialog(
                            this,
                            "Net Profit:",
                            model.getValueAt(selectedRow, 9)
                    )
            );

            FinancialData data = new FinancialData(
                    year,
                    currentAssets,
                    currentLiabilities,
                    inventory,
                    totalDebt,
                    equity,
                    revenue,
                    grossProfit,
                    netProfit
            );

            data.setId(id);

            FinancialDataDAO dao =
                    new FinancialDataDAO();

            boolean success =
                    dao.updateFinancialData(data);

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Financial data updated successfully!"
                );

                loadData();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to update financial data."
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numbers."
            );
        }
    }

    private void deleteData() {

        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a record to delete."
            );

            return;
        }

        int id = Integer.parseInt(
                model.getValueAt(selectedRow, 0).toString()
        );

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this record?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            FinancialDataDAO dao =
                    new FinancialDataDAO();

            boolean success =
                    dao.deleteFinancialData(id);

            if (success) {

                JOptionPane.showMessageDialog(
                        this,
                        "Financial data deleted successfully!"
                );

                loadData();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed to delete financial data."
                );
            }
        }
    }
}