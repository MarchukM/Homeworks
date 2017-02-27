package homework1;

public class BracketCheck {

    private static boolean check(String inputString) {
        int size = inputString.length();
        SimpleStack stack = new SimpleStack(size);

        for (int i = 0; i < size; i++) {
            char ch = inputString.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '<':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '>':
                    if (!stack.isEmpty())
                        stack.pop();
                    else {
                        return false;
                    }
                default:
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        String input1 = "<>[]((<>))123abcd()[]";
        String input2 = "<<<<)))";
        String input3 = "<<<>>>>>>>";

        System.out.println(input1 + " : " + BracketCheck.check(input1));
        System.out.println(input2 + " : " + BracketCheck.check(input2));
        System.out.println(input3 + " : " + BracketCheck.check(input3));
    }
}

