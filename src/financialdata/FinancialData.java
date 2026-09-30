package financialdata;

public class FinancialData {

    private int id;
    private String financialYear;
    private double currentAssets;
    private double currentLiabilities;
    private double inventory;
    private double totalDebt;
    private double shareholdersEquity;
    private double revenue;
    private double grossProfit;
    private double netProfit;

    // Default constructor
    public FinancialData() {
    }

    // Constructor
    public FinancialData(String financialYear, double currentAssets,
                         double currentLiabilities, double inventory,
                         double totalDebt, double shareholdersEquity,
                         double revenue, double grossProfit,
                         double netProfit) {

        this.financialYear = financialYear;
        this.currentAssets = currentAssets;
        this.currentLiabilities = currentLiabilities;
        this.inventory = inventory;
        this.totalDebt = totalDebt;
        this.shareholdersEquity = shareholdersEquity;
        this.revenue = revenue;
        this.grossProfit = grossProfit;
        this.netProfit = netProfit;
    }

    // ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Financial Year
    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    // Current Assets
    public double getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(double currentAssets) {
        this.currentAssets = currentAssets;
    }

    // Current Liabilities
    public double getCurrentLiabilities() {
        return currentLiabilities;
    }

    public void setCurrentLiabilities(double currentLiabilities) {
        this.currentLiabilities = currentLiabilities;
    }

    // Inventory
    public double getInventory() {
        return inventory;
    }

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    // Total Debt
    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    // Shareholders Equity
    public double getShareholdersEquity() {
        return shareholdersEquity;
    }

    public void setShareholdersEquity(double shareholdersEquity) {
        this.shareholdersEquity = shareholdersEquity;
    }

    // Revenue
    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    // Gross Profit
    public double getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(double grossProfit) {
        this.grossProfit = grossProfit;
    }

    // Net Profit
    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }
}