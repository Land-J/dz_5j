import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class dz_5 {
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("()")); // true
        System.out.println(isCorrectParentheses("(")); // false
        System.out.println(isCorrectParentheses("())")); // false
        System.out.println(isCorrectParentheses("((()))")); // true
        System.out.println(isCorrectParentheses("()[]{}<>")); // true
        System.out.println(isCorrectParentheses("([)]")); // false
        System.out.println(isCorrectParentheses("][]")); // false
        System.out.println(isCorrectParentheses("[]{<()[]<>>}")); // true
    }

    static boolean isCorrectParentheses(String parentheses) {
        Map<Character, Character> bracketsMapping = new HashMap<Character, Character>();
        bracketsMapping.put('(', ')');
        bracketsMapping.put('{', '}');
        bracketsMapping.put('[', ']');
        bracketsMapping.put('<', '>');

        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);

            if (bracketsMapping.containsKey(c)) {
                stack.push(c);
            }
            else if (bracketsMapping.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpenedBracket = stack.pop();
                if (bracketsMapping.get(lastOpenedBracket) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}