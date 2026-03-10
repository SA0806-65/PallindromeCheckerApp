import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PallindromeCheckerAppUseCase6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();
        String original = input.toLowerCase();

        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}