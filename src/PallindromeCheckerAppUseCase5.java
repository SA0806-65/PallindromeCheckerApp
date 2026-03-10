import java.util.Scanner;
import java.util.Stack;
public class PallindromeCheckerAppUseCase5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        String original = input.toLowerCase();

        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }
        if (original.equals(reversed)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();

    }
}
