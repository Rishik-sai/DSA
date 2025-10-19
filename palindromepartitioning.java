import java.util.*;
public class palindromepartitioning {
    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    static void backtrack(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                backtrack(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(0, s, path, res);
        return res;
    }
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);

        for (List<String> part : result) {
            for (String str : part) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
