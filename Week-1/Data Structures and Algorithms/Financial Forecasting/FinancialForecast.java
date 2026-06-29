import java.util.Scanner;

public class FinancialForecast {

    // Recursive function to predict future revenue
    static double forecast(double revenue, double growthRate, int years) {
        if (years == 0)
            return revenue;

        return forecast(revenue * (1 + growthRate / 100), growthRate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Current Revenue: ");
        double revenue = sc.nextDouble();

        System.out.print("Annual Growth Rate (%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Number of Years: ");
        int years = sc.nextInt();

        double predictedRevenue = forecast(revenue, growthRate, years);

        System.out.printf("Predicted Revenue after %d years = %.2f\n", years, predictedRevenue);

        sc.close();
    }
}