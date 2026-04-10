import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string to compress: ");
        String input = scanner.nextLine();
        
        System.out.println("Result: " + compress(input));
        scanner.close();
    }

    public static String compress(String str) {
        // Edge case: empty or null string
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // If next character is different or we are at the end of the string
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        // Return the shorter one
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
