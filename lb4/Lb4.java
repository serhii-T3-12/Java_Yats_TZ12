package lb4;

public class Lb4 {
    public static class Task2 {
        public static void main(String[] args) {
            int[] array = {-5, 12, -8, 7, -10, -3, 6, -8, -10};

            int sum = 0;
            int count = 0;

            for (int number : array) {
                if (number < 0 && number % 2 == 0) {
                    sum += number;
                    count++;
                }
            }

            if (count == 0) {
                System.out.println("У масиві немає від'ємних чисел, що діляться на 2.");
            } else {
                double average = (double) sum / count;
                System.out.println("Середнє арифметичне від'ємних чисел, що діляться на 2: " + average);
            }
        }
    }

    public static class Task3 {
        public static void main(String[] args) {
            int[] A = {1, 2, 3, 4, 5};
            int[] B = {6, 7, 8, 9, 10};

            int n = A.length;
            int[] C = new int[2 * n];

            for (int i = 0; i < n; i++) {
                C[2 * i] = A[i];
                C[2 * i + 1] = B[i];
            }

            // Виводимо масив C
            for (int value : C) {
                System.out.print(value + " ");
            }
        }
    }

    public static class Task1 {
        public static void main(String[] args) {
            int[] array = {5, 12, 3, 8, 221, 9, 15, 4};
            int min = findMin(array);
            int max = findMax(array);

            int difference = max - min;

            System.out.println("Найбільший елемент: " + max);
            System.out.println("Найменший елемент: " + min);
            System.out.println("Різниця: " + difference);
        }

        public static int findMin(int[] arr) {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }

        public static int findMax(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }
    }
}
