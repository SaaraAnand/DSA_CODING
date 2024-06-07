import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.next();
        
        String reversedStr = reverseStringUsingStack(str);
        System.out.println("Reversed string: " + reversedStr);
    }

    public static String reverseStringUsingStack(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        
        for (char c : chars) {
            stack.push(c);
        }
        
        for (int i = 0; i < chars.length; i++) {
            chars[i] = stack.pop();
        }
        
        return new String(chars);
    }
}
