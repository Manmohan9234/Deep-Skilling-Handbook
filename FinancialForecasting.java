<<<<<<< HEAD
import java.util.Scanner;

public class FinancialForecasting {

    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return forecast(currentValue * (1 + growthRate / 100), growthRate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Current Value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter Growth Rate (%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double futureValue = forecast(currentValue, growthRate, years);

        System.out.println("Future Value = " + futureValue);

        sc.close();
    }
=======
import java.util.Scanner;

public class FinancialForecasting {

    public static double forecast(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return forecast(currentValue * (1 + growthRate / 100), growthRate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Current Value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter Growth Rate (%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double futureValue = forecast(currentValue, growthRate, years);

        System.out.println("Future Value = " + futureValue);

        sc.close();
    }
>>>>>>> 07bf603f52ca267bbc8fcd875de0a2201b47b17f
}