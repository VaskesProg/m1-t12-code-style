import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, int depositPeriod) {
       double pay = amount * Math.pow((1 + 0.06 / 12), 12 * depositPeriod);

       return round(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return round(amount + amount * 0.06 * depositPeriod);
    }

    double round(double value) {
       double scale = Math.pow(10, 2);

       return Math.round(value * scale) / scale;
    }

    void calculatePercent( ) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        int depositPeriod = scanner.nextInt( );

        System.out.println("Выберите тип вклада, " +
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");
        int command = scanner.nextInt();
        double sumOut = 0;

        if (command == 1) {
            sumOut = calculateSimplePercent(amount, depositPeriod);
        } else if (command == 2) {
            sumOut = calculateComplexPercent(amount, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + sumOut);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculatePercent();
    }




}
