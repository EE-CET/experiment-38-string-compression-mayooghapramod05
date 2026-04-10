import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(compress(input));
        }
        
        scanner.close();
    }

    public static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        // Change: Use <= so that if lengths are equal (like aabb vs a2b2), 
        // it returns the compressed version.
        return compressed.length() <= str.length() ? compressed.toString() : str;
    }
}
