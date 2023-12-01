import java.util.Stack;

public class Parentheses {
    final int BASE_LEVEL = 0;
    final int CURLY_LEVEL = 1;
    final int SQUARE_LEVEL = 2;
    final int PARENTHESES_LEVEL = 3;
    public boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> levels = new Stack<>();
        levels.push(BASE_LEVEL);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int currLevel = levels.peek();
            if (c == '{' || c == '[' || c == '(') {
                if (c == '{') {
                    if (currLevel > BASE_LEVEL) return false;
                    levels.push(CURLY_LEVEL);
                } else if (c == '[') {
                    if (currLevel > CURLY_LEVEL) return false;
                    levels.push(SQUARE_LEVEL);
                } else {
                    levels.push(PARENTHESES_LEVEL);
                }
                stack.push(c);
            } else {
                char last = stack.pop();
                if (c == '}') {
                    if (currLevel != CURLY_LEVEL || last != '{') return false;
                    levels.pop();
                }
                if (c == ']') {
                    if (currLevel != SQUARE_LEVEL || last != '[') return false;
                    levels.pop();
                }
                if (c == ')') {
                    if (currLevel != PARENTHESES_LEVEL || last != '(') return false;
                    levels.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Invalid arguments. Provide at least one expression.");
            return;
        }
        String sequence = args[0];
        Parentheses par = new Parentheses();
        System.out.println(par.isBalanced(sequence));
    }
}