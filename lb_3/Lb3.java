package lb_3;

import java.util.Scanner;

public class Lb3 {
    public static class Task3 {
        public Task3() {
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть значення для ε (ε > 0): ");
            double epsilon = scanner.nextDouble();
            if (epsilon <= 0.0) {
                throw new IllegalArgumentException("ε повинно бути більше за 0");
            } else {
                double sum = calculateInfiniteSum(epsilon);
                System.out.println("Результат: " + sum);
            }
        }

        public static double calculateInfiniteSum(double epsilon) {
            double sum = 0.0;
            int i = 1;

            double term;
            do {
                term = 1.0 / Math.pow((double)i, 2.0);
                sum += term;
                ++i;
            } while(Math.abs(term) >= epsilon);

            return sum;
        }
    }

    public static class Task2 {
        public static void main(String[] args) {

            Task2 secondTaskObj = new Task2();

            secondTaskObj.printTaskSolution(12, 9, 1);
            secondTaskObj.printTaskSolution(0, 8, -3);
            secondTaskObj.printTaskSolution(-7, 11, 7);
            secondTaskObj.printTaskSolution(5, 7, 2);
            secondTaskObj.printTaskSolution(0, 13, 0);
            secondTaskObj.printTaskSolution(-16, 5, 8);
        }

        private double solveTask(double t, int n, int l) {
            boolean isItEven = l % 2 == 0;

            if(t == 0 || isItEven && t < 0) {
                throw new IllegalArgumentException("param t = " + t);
            }

            double sum = 0;
            for(int i = 1; i <= n; i++) {
                sum += isItEven ? l / Math.sqrt(t) : l / t;
            }

            return sum;
        }

        private void printTaskSolution(double t, int n, int l) {
            String output = "t=" + t + "; n=" + n + "; l=" + l + ";\nresult: ";

            try {
                output += solveTask(t, n, l);

            } catch(IllegalArgumentException e) {
                output += "EXCEPTION! " + e.getMessage();
            }

            System.out.println(output);
        }
    }

    public static class Task1 {
        public Task1() {
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the value for i: ");
            double i = scanner.nextDouble();
            System.out.print("Enter the value for z: ");
            double z = scanner.nextDouble();
            System.out.print("Enter the value for k: ");
            double k = scanner.nextDouble();
            double sum = 0.0;

            for (int kCounter = 1; kCounter < 15; ++kCounter) {
                sum += calculateFunction(i, z, kCounter);
            }

            System.out.println("Result: " + sum);
        }

        private static double calculateFunction(double z, double i, int k) {
            return (1 / Math.sqrt(z * i) + Math.tan(k / i));
        }
    }
}
