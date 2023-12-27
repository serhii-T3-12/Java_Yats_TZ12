package lb6;

public class lb_6 {
    public static class lb_6_2 {
        public static void main(String[] args) {
            int value = 511;
            String octalString = intToOctString(value);
            System.out.println("Результат: " + octalString);

            String sentence = "The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago";
            int count = countNumbers(sentence);
            System.out.println("Кількість чисел у реченні: " + count);
        }

        public static String intToOctString(int i) {
            return Integer.toOctalString(i);
        }

        public static int countNumbers(String s) {
            if (s == null || s.isEmpty()) {
                throw new IllegalArgumentException("Рядок не може бути порожнім або нульовим");
            }

            String[] words = s.split("\\s+");

            int count = 0;
            for (String word : words) {
                if (word.matches("\\d+")) {
                    count++;
                }
            }

            return count;
        }
    }

    public static class lb_6_1 {
        public static void main(String[] args) {
            String hexString = "CAFEE";
            int result = hexStringToInt(hexString);
            System.out.println(result);
        }

        public static int hexStringToInt(String s) {
            return Integer.parseInt(s, 16);
        }
    }
}
