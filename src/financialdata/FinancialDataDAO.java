package financialdata;

import dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FinancialDataDAO {

    public boolean insertFinancialData(FinancialData data) {

        String sql = "INSERT INTO financial_data "
                + "(financial_year, current_assets, current_liabilities, inventory, "
                + "total_debt, shareholders_equity, revenue, gross_profit, net_profit) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, data.getFinancialYear());
            ps.setDouble(2, data.getCurrentAssets());
            ps.setDouble(3, data.getCurrentLiabilities());
            ps.setDouble(4, data.getInventory());
            ps.setDouble(5, data.getTotalDebt());
            ps.setDouble(6, data.getShareholdersEquity());
            ps.setDouble(7, data.getRevenue());
            ps.setDouble(8, data.getGrossProfit());
            ps.setDouble(9, data.getNetProfit());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println(
                    "Error inserting financial data: "
                    + e.getMessage()
            );
            return false;
        }
    }

    public List<FinancialData> getAllFinancialData() {

        List<FinancialData> list = new ArrayList<>();

        String sql = "SELECT * FROM financial_data";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                FinancialData data = new FinancialData();

                data.setId(rs.getInt("id"));
                data.setFinancialYear(
                        rs.getString("financial_year")
                );
                data.setCurrentAssets(
                        rs.getDouble("current_assets")
                );
                data.setCurrentLiabilities(
                        rs.getDouble("current_liabilities")
                );
                data.setInventory(
                        rs.getDouble("inventory")
                );
                data.setTotalDebt(
                        rs.getDouble("total_debt")
                );
                data.setShareholdersEquity(
                        rs.getDouble("shareholders_equity")
                );
                data.setRevenue(
                        rs.getDouble("revenue")
                );
                data.setGrossProfit(
                        rs.getDouble("gross_profit")
                );
                data.setNetProfit(
                        rs.getDouble("net_profit")
                );

                list.add(data);
            }

        } catch (Exception e) {
            System.out.println(
                    "Error retrieving financial data: "
                    + e.getMessage()
            );
        }

        return list;
    }

    public boolean updateFinancialData(FinancialData data) {

        String sql = "UPDATE financial_data SET "
                + "financial_year = ?, "
                + "current_assets = ?, "
                + "current_liabilities = ?, "
                + "inventory = ?, "
                + "total_debt = ?, "
                + "shareholders_equity = ?, "
                + "revenue = ?, "
                + "gross_profit = ?, "
                + "net_profit = ? "
                + "WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, data.getFinancialYear());
            ps.setDouble(2, data.getCurrentAssets());
            ps.setDouble(3, data.getCurrentLiabilities());
            ps.setDouble(4, data.getInventory());
            ps.setDouble(5, data.getTotalDebt());
            ps.setDouble(6, data.getShareholdersEquity());
            ps.setDouble(7, data.getRevenue());
            ps.setDouble(8, data.getGrossProfit());
            ps.setDouble(9, data.getNetProfit());
            ps.setInt(10, data.getId());

            int rowsUpdated = ps.executeUpdate();

            System.out.println(
                    "ID being Updated: " + data.getId()
            );

            System.out.println(
                    "Rows Updated: " + rowsUpdated
            );

            return rowsUpdated > 0;

        } catch (Exception e) {

            System.out.println(
                    "Error updating financial data: "
                    + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }

    public boolean deleteFinancialData(int id) {

        String sql =
                "DELETE FROM financial_data WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(
                    "Error deleting financial data: "
                    + e.getMessage()
            );

            return false;
        }
    }
}