import java.util.Scanner;

public class PallindromeCheckerAppUseCase9 {

    static boolean flag = true;

    public static void checkPalindrome(String str, int start, int end) {

        if (start >= end) {
            return;
        }

        if (str.charAt(start) != str.charAt(end)) {
            flag = false;
            return;
        }

        checkPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine().toLowerCase();

        checkPalindrome(input, 0, input.length() - 1);

        if (flag == true) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}