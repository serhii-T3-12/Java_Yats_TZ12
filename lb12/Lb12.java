package lb12;

public class Lb12 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static class lb2 {
        static void Task1() {
            double a = -1.49, b = 23.4, c = 1.23, d = 2.254;
            double y = 2 * Math.sqrt(Math.tan(Math.abs(a + c))) + Math.log(b) / Math.pow(c, d);
            System.out.println("Task 1: " + y);
        }

        static void Task2() {
            double a = 0.345, b = -2.25, c = 2.65, d = 3.99;
            double y = (5 * a) / Math.sin(a) + Math.sqrt(Math.tanh(Math.abs(b) * c) / Math.log(d));
            System.out.println("Task 2: " + y);
        }

        static void Task3() {
            double a = 1.27, b = 10.99, c = 4.0, d = -25.32;
            double y = (Math.pow(Math.tan(a), 1.0 / c) / (2 - (Math.sinh(b) / Math.log(Math.abs(d + c)))));
            System.out.println("Task 3: " + y);
        }

        public static void main(String[] args) {
            Task1();
            Task2();
            Task3();
        }
    }
}