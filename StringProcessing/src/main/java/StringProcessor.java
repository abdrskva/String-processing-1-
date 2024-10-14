import java.util.Stack;

public class StringProcessor {
    public StringProcessor() {
    }

    public boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        } else {
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;
            char[] var6 = password.toCharArray();
            int var7 = var6.length;

            for (char c : var6) {
                if (Character.isUpperCase(c)) {
                    hasUpper = true;
                } else if (Character.isLowerCase(c)) {
                    hasLower = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecial = true;
                }
            }

            return hasUpper && hasLower && hasDigit && hasSpecial;
        }
    }

    public int calculateDigits(String sentence) {
        int count = 0;
        char[] var3 = sentence.toCharArray();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char c = var3[var5];
            if (Character.isDigit(c)) {
                ++count;
            }
        }

        return count;
    }

    public int calculateWords(String sentence) {
        if (sentence != null && !sentence.trim().isEmpty()) {
            String[] words = sentence.trim().split("\\s+");
            return words.length;
        } else {
            return 0;
        }
    }

    public double calculateExpression(String expression) {
        return this.evaluateExpression(expression);
    }

    private double evaluateExpression(String expression) {
        Stack<Double> values = new Stack();
        Stack<Character> ops = new Stack();

        for(int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c != ' ') {
                if (Character.isDigit(c)) {
                    StringBuilder sb;
                    for(sb = new StringBuilder(); i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.'); ++i) {
                        sb.append(expression.charAt(i));
                    }

                    values.push(Double.parseDouble(sb.toString()));
                    --i;
                } else if (c != '+' && c != '-' && c != '*' && c != '/') {
                    if (c == '(') {
                        ops.push(c);
                    } else if (c == ')') {
                        while((Character)ops.peek() != '(') {
                            values.push(this.applyOperation((Character)ops.pop(), (Double)values.pop(), (Double)values.pop()));
                        }

                        ops.pop();
                    }
                } else {
                    while(!ops.isEmpty() && this.hasPrecedence(c, (Character)ops.peek())) {
                        values.push(this.applyOperation((Character)ops.pop(), (Double)values.pop(), (Double)values.pop()));
                    }

                    ops.push(c);
                }
            }
        }

        while(!ops.isEmpty()) {
            values.push(this.applyOperation((Character)ops.pop(), (Double)values.pop(), (Double)values.pop()));
        }

        return (Double)values.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 != '(' && op2 != ')') {
            return op1 != '*' && op1 != '/' || op2 != '+' && op2 != '-';
        } else {
            return false;
        }
    }

    private double applyOperation(char op, double b, double a) {
        switch (op) {
            case '*':
                return a * b;
            case '+':
                return a + b;
            case ',':
            case '.':
            default:
                return 0.0;
            case '-':
                return a - b;
            case '/':
                return a / b;
        }
    }

    public static void main(String[] args) {
        StringProcessor sp = new StringProcessor();
        System.out.println(sp.isStrongPassword("Strong1!"));
        System.out.println(sp.isStrongPassword("weakpassword"));
        System.out.println(sp.isStrongPassword("12345678"));
        System.out.println(sp.isStrongPassword("Short1!"));
        System.out.println(sp.isStrongPassword("NoSpecialChar1"));
        System.out.println(sp.calculateDigits("There are 2 apples."));
        System.out.println(sp.calculateDigits("123 Main St."));
        System.out.println(sp.calculateDigits("No digits here!"));
        System.out.println(sp.calculateDigits("My number is 456-7890."));
        System.out.println(sp.calculateDigits("In 2020, I got 1 dog."));
        System.out.println(sp.calculateWords("Hello everyone!"));
        System.out.println(sp.calculateWords("whats app"));
        System.out.println(sp.calculateWords(" welcome mm "));
        System.out.println(sp.calculateWords(""));
        System.out.println(sp.calculateWords("Salima"));
        System.out.println(sp.calculateExpression("3 + 5"));
        System.out.println(sp.calculateExpression("10 + 2 * 6"));
        System.out.println(sp.calculateExpression("100 * 2 + 12"));
        System.out.println(sp.calculateExpression("100 * ( 2 + 12 )"));
        System.out.println(sp.calculateExpression("100 * ( 2 + 12 ) / 14"));
    }
}