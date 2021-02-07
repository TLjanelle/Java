package main.java;

public class BalancedBrackets {
    /**
     * COMPLETED: implement this method
     * This method should check the characters of the string,
     * and see whether the brackets/parentheses are balanced in the string.
     * <p>
     * The string can contain other characters in addition to the brackets/parentheses
     * For example: [abc(def)d] is considered as balanced
     * If a string does not contain any bracket/parenthesis, the string is also considered as balanced.
     * Another example: [abc(def]d) is considered as unbalanced
     *
     * @param inputString the string that contains brackets/parenthesis and other char values
     */
    public static boolean match(String inputString) {
        Stack openingBrackets = new Stack();
        String temp;

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            if (c == '[' || c == '{' || c == '(') {
                openingBrackets.push(Character.toString(c));
                continue;
            }

            if (openingBrackets.empty() && (c == ']' || c == '}' || c == ')')) {
                return  false;
            } else {
            switch (c) {
                    case ']':
                        temp = openingBrackets.top();
                        if (temp.equals("[")) {
                            openingBrackets.pop();
                        }
                        break;
                case '}':
                        temp = openingBrackets.top();
                        if (temp.equals("{")) {
                            openingBrackets.pop();
                        }
                    break;
                case ')':
                        temp = openingBrackets.top();
                        if (temp.equals("(")) {
                            openingBrackets.pop();
                        }
                    break;
                default:
                }
            }
        }
        return openingBrackets.empty();
    }
}