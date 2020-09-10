package programmers.kakao.blind_recruitment.v2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsClustering {
    public int solution(String str1, String str2) {
        List<String> set1 = filterString(toStringSet(str1.toLowerCase()));
        List<String> set2 = filterString(toStringSet(str2.toLowerCase()));

        Collections.sort(set1);
        Collections.sort(set2);

        int union = union(set1, set2);
        int intersect = intersect(set1, set2);

        if (intersect == 0 && union == 0) {
            return 65536;
        } else {
            return (int) (((float) intersect / union) * 65536);
        }
    }

    public List<String> toStringSet(String str) {
        List<String> set = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2);
            set.add(s);
        }
        return set;
    }

    public List<String> filterString(List<String> list) {
        List<String> filtered = new ArrayList<>();
        for (String s : list) {
            boolean isValid = true;
            for (char c : s.toCharArray()) {
                if (c < 'a' || c > 'z') {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public int union(List<String> set1, List<String> set2) {
        List<String> union = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < set1.size() && idx2 < set2.size()) {
            if (set1.get(idx1).compareTo(set2.get(idx2)) < 0) {
                union.add(set1.get(idx1++));
            } else if (set1.get(idx1).compareTo(set2.get(idx2)) > 0) {
                union.add(set2.get(idx2++));
            } else {
                union.add(set1.get(idx1));
                idx1++;
                idx2++;
            }
        }

        while (idx1 < set1.size()) {
            union.add(set1.get(idx1++));
        }

        while (idx2 < set2.size()) {
            union.add(set2.get(idx2++));
        }
        return union.size();
    }

    public int intersect(List<String> set1, List<String> set2) {
        List<String> intersect = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < set1.size() && idx2 < set2.size()) {
            if (set1.get(idx1).compareTo(set2.get(idx2)) < 0) {
                idx1++;
            } else if (set1.get(idx1).compareTo(set2.get(idx2)) > 0) {
                idx2++;
            } else {
                intersect.add(set1.get(idx1));
                idx1++;
                idx2++;
            }
        }
        return intersect.size();
    }
}
