import dbconnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class RatioAnalysis extends JFrame {

    JTextArea resultArea;

    public RatioAnalysis() {

        setTitle("Titan Ratio Analysis");
        setSize(650, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        resultArea = new JTextArea();
        resultArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14)
        );

        resultArea.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(resultArea);

        add(scrollPane);

        calculateRatios();

        setVisible(true);
    }

    private void calculateRatios() {

        String sql =
                "SELECT * FROM financial_data ORDER BY id DESC LIMIT 1";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {

                String year =
                        rs.getString("financial_year");

                double currentAssets =
                        rs.getDouble("current_assets");

                double currentLiabilities =
                        rs.getDouble("current_liabilities");

                double inventory =
                        rs.getDouble("inventory");

                double debt =
                        rs.getDouble("total_debt");

                double equity =
                        rs.getDouble("shareholders_equity");

                double revenue =
                        rs.getDouble("revenue");

                double grossProfit =
                        rs.getDouble("gross_profit");

                double netProfit =
                        rs.getDouble("net_profit");

                // Calculate ratios

                double currentRatio =
                        currentAssets / currentLiabilities;

                double quickRatio =
                        (currentAssets - inventory)
                        / currentLiabilities;

                double debtEquity =
                        debt / equity;

                double grossProfitRatio =
                        (grossProfit / revenue) * 100;

                double netProfitRatio =
                        (netProfit / revenue) * 100;

                // Display results

                resultArea.setText("");

                resultArea.append(
                        "========================================\n");
                resultArea.append(
                        "       TITAN COMPANY LIMITED\n");
                resultArea.append(
                        "          RATIO ANALYSIS\n");
                resultArea.append(
                        "========================================\n\n");

                resultArea.append(
                        "Financial Year : " + year + "\n\n");

                resultArea.append(
                        "LIQUIDITY RATIOS\n");
                resultArea.append(
                        "----------------------------------------\n");

                resultArea.append(
                        String.format(
                                "Current Ratio       : %.2f%n",
                                currentRatio));

                resultArea.append(
                        String.format(
                                "Quick Ratio          : %.2f%n%n",
                                quickRatio));

                resultArea.append(
                        "SOLVENCY RATIOS\n");
                resultArea.append(
                        "----------------------------------------\n");

                resultArea.append(
                        String.format(
                                "Debt-Equity Ratio    : %.2f%n%n",
                                debtEquity));

                resultArea.append(
                        "PROFITABILITY RATIOS\n");
                resultArea.append(
                        "----------------------------------------\n");

                resultArea.append(
                        String.format(
                                "Gross Profit Ratio   : %.2f%%%n",
                                grossProfitRatio));

                resultArea.append(
                        String.format(
                                "Net Profit Ratio     : %.2f%%%n",
                                netProfitRatio));

                resultArea.append(
                        "\n========================================\n");

            } else {

                resultArea.setText(
                        "No financial data available.\n\n"
                        + "Please enter financial data first."
                );
            }

        } catch (SQLException e) {

            resultArea.setText(
                    "Database Error:\n" + e.getMessage()
            );

            e.printStackTrace();
        }
    }
}