package programmers.kakao.blind_recruitment.v2020;

import java.util.Stack;

public class ParenthesisTransformation {
    public String solution(String p) {
        if (isCorrect(p)) return p;
        return transform(p);
    }

    private String transform(String p) {
        if (p.isEmpty()) return p;

        String[] split = splitStr(p);
        String u = split[0];
        String v = split[1];

        if (isCorrect(u)) {
            return u + transform(v);
        } else {
            return "(" + transform(v) + ")" +
                    reverseParenthesis(u.substring(1, u.length() - 1));
        }
    }

    private String[] splitStr(String w) {
        for (int i = 2; i < w.length(); i++) {
            String s = w.substring(0, i);
            if (isBalance(s)) {
                return new String[]{s, w.substring(i)};
            }
        }
        return new String[]{w, ""};
    }

    private boolean isBalance(String s) {
        int a = 0;
        int b = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') a++;
            if (c == ')') b++;
        }
        return a == b;
    }

    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }

    private String reverseParenthesis(String u) {
        StringBuilder builder = new StringBuilder();
        for (char c : u.toCharArray()) {
            builder.append(c == '(' ? ')' : '(');
        }
        return builder.toString();
    }
}
