package General;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author İbrahim Başar YARGICI
 * @date 13.04.2021
 *
 * Task to find the truth of parenthesis in a sentence.
 */
public class ParenthesisMatch {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        boolean isMatched = isParenthesisMatch(str);

        if (isMatched) {
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }


    }

    public static boolean isParenthesisMatch(String str) {

        Stack<Character> stack = new Stack<>();

        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (c == '(') stack.push(c);
            else if (c == ')') if (stack.empty()) return false;
            else if (stack.peek() == '(') stack.pop();
            else return false;
        }
        return stack.empty();
    }
}
