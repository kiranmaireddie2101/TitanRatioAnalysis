import dbconnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Report extends JFrame {

    JTextArea reportArea;

    public Report() {

        setTitle("Titan Company Financial Report");
        setSize(700, 600);
        setLocationRelativeTo(null);

        reportArea = new JTextArea();

        reportArea.setFont(
                new Font("Monospaced", Font.PLAIN, 13)
        );

        reportArea.setEditable(false);

        add(new JScrollPane(reportArea));

        loadReport();

        setVisible(true);
    }

    private void loadReport() {

        String sql =
                "SELECT * FROM financial_data ORDER BY financial_year";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            reportArea.append(
                    "============================================================\n");
            reportArea.append(
                    "             TITAN COMPANY LIMITED\n");
            reportArea.append(
                    "              FINANCIAL REPORT\n");
            reportArea.append(
                    "============================================================\n\n");

            while (rs.next()) {

                String year =
                        rs.getString("financial_year");

                double revenue =
                        rs.getDouble("revenue");

                double grossprofit =
                        rs.getDouble("gross_profit");

                double netProfit =
                        rs.getDouble("net_profit");

                double currentAssets =
                        rs.getDouble("current_assets");

                double currentLiabilities =
                        rs.getDouble("current_liabilities");

                double currentRatio =
                        RatioCalculator.currentRatio(
                                currentAssets,
                                currentLiabilities);

                double netProfitRatio =
                        RatioCalculator.netProfitRatio(
                                netProfit,revenue);
                double grossProfitRatio =
                        RatioCalculator.grossProfitRatio(
                                grossprofit,revenue);
                reportArea.append(
                        "Financial Year : " + year + "\n");

                reportArea.append(
                        "Revenue         : " + revenue + "\n");
                
                reportArea.append(
                        "Gross Profit     :"+ grossprofit +"\n");

                reportArea.append(
                        "Net Profit     : " + netProfit + "\n");

                reportArea.append(
                        String.format(
                                "Current Ratio  : %.2f%n",
                                currentRatio));
                reportArea.append(
                        String.format(
                                "GrossProfit %%  : %.2f%%%n",
                                grossProfitRatio));
                 reportArea.append(
                        String.format(
                                "Net Profit %%   : %.2f%%%n",
                                netProfitRatio));

                reportArea.append(
                        "------------------------------------------------------------\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}