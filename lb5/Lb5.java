package lb5;

import java.util.Arrays;

public class Lb5 {

    public static class Task1 {

        public static void bubbleSort(long[] array) {
            int n = array.length;
            boolean swapped;

            do {
                swapped = false;
                for (int i = 1; i < n; i++) {
                    if (array[i - 1] < array[i]) {
                        long temp = array[i - 1];
                        array[i - 1] = array[i];
                        array[i] = temp;
                        swapped = true;
                    }
                }
            } while (swapped);
        }

        public static void main(String[] args) {
            long[] arrayToSort = {5, 2, 9, 1, 5, 6};

            System.out.println("До сортування: " + Arrays.toString(arrayToSort));

            bubbleSort(arrayToSort);

            System.out.println("Після сортування бульбашкою: " + Arrays.toString(arrayToSort));
        }
    }

    public static class Task2 {

        public static void selectionSort(long[] array) {
            int n = array.length;

            for (int i = 0; i < n - 1; i++) {
                int maxIndex = i;


                for (int j = i + 1; j < n; j++) {
                    if (array[j] > array[maxIndex]) {
                        maxIndex = j;
                    }
                }

                long temp = array[maxIndex];
                array[maxIndex] = array[i];
                array[i] = temp;
            }
        }

        public static void main(String[] args) {
            long[] arrayToSort = {5, 2, 9, 1, 5, 6, 4, 1, 12, 15};

            System.out.println("До сортування: " + Arrays.toString(arrayToSort));

            selectionSort(arrayToSort);

            System.out.println("Після сортування вибором: " + Arrays.toString(arrayToSort));
        }
    }
}