import java.util.Scanner;

public class PallindromeCheckerAppUseCase10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;
        boolean flag = true;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                flag = false;
                break;
            }
            start++;
            end--;
        }

        if (flag == true) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
