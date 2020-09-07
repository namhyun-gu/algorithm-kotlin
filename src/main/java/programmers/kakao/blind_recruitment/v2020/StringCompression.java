package programmers.kakao.blind_recruitment.v2020;

import java.util.ArrayList;

public class StringCompression {
    public int solution(String s) {
        int answer = s.length();
        for (int length = 1; length < s.length() - 1; length++) {
            String compressed = compress(s, length);
            if (compressed.length() < answer) {
                answer = compressed.length();
            }
        }
        return answer;
    }

    private String compress(String str, int length) {
        ArrayList<String> list = new ArrayList<>();
        for (int start = 0; start < str.length(); start += length) {
            list.add(str.substring(start, Math.min(start + length, str.length())));
        }
        int cnt = 1;
        String before = list.get(0);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < list.size(); i++) {
            if (before.equals(list.get(i))) {
                cnt++;
            } else {
                builder.append(cnt > 1 ? cnt + before : before);
                before = list.get(i);
                cnt = 1;
            }
        }
        builder.append(cnt > 1 ? cnt + before : before);
        return builder.toString();
    }
}
