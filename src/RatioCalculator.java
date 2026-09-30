public class RatioCalculator {

    public static double currentRatio(
            double currentAssets,
            double currentLiabilities) {

        return currentAssets / currentLiabilities;
    }

    public static double quickRatio(
            double quickAssets,
            double currentLiabilities) {

        return quickAssets / currentLiabilities;
    }

    public static double debtEquityRatio(
            double debt,
            double equity) {

        return debt / equity;
    }

    public static double proprietaryRatio(
            double equity,
            double totalAssets) {

        return equity / totalAssets;
    }

    public static double grossProfitRatio(
            double sales,
            double cogs) {

        double grossProfit = sales - cogs;

        return (grossProfit / sales) * 100;
    }

    public static double netProfitRatio(
            double netProfit,
            double sales) {

        return (netProfit / sales) * 100;
    }

    public static double operatingRatio(
            double cogs,
            double netProfit,
            double sales) {

        double grossProfit = sales - cogs;

        double operatingProfit =
                grossProfit - netProfit;

        double operatingCost =
                sales - operatingProfit;

        return (operatingCost / sales) * 100;
    }

    public static double ROCE(
            double netProfit,
            double capitalEmployed) {

        return (netProfit / capitalEmployed) * 100;
    }

    public static double ROE(
            double netProfit,
            double equity) {

        return (netProfit / equity) * 100;
    }

    public static double EPS(
            double netProfit,
            double numberOfShares) {

        return netProfit / numberOfShares;
    }
}
