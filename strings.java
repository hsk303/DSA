import java.util.*;

public class strings {
    // all palindromic substrings
    public static void palindromicSubstrings(String str) {
        // write your code here
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (ispalindrome(str, i, j - 1)) {
                    String s = str.substring(i, j);
                    System.out.println(s);
                }
            }
        }

    }

    public static boolean ispalindrome(String s, int si, int ei) {
        while (si < ei) {
            if (s.charAt(si) != s.charAt(ei))
                return false;
            si++;
            ei--;
        }
        return true;
    }

    // string compression

    public static String compression1(String str) {
        // write your code here
        int n = str.length();
        if (n == 0)
            return null;
        String ans = str.charAt(0) + "";
        int i = 1;
        while (i < n) {
            while (i < n && ans.charAt(ans.length() - 1) == str.charAt(i)) {
                i++;
            }
            if (i < n) {
                ans += str.charAt(i);
            }
            i++;

        }
        return ans;

    }

    public static String compression2(String str) {
        // write your code here

        int n = str.length();
        if (n == 0)
            return null;
        String ans = str.charAt(0) + "";
        int i = 1, count = 0;
        while (i < n) {
            count = 1;
            while (i < n && ans.charAt(ans.length() - 1) == str.charAt(i)) {
                i++;
                count++;
            }
            if (count > 1)
                ans += count;
            if (i < n) {
                ans += str.charAt(i);
            }
            i++;
        }
        return ans;
    }

    // Toggle case

    public static String toggleCase(String str) {
        // write your code here
        int n = str.length();
        int i = 0;
        String ans = "";
        while (i < n) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                ans += (char) (str.charAt(i) - 'a' + 'A');
            } else {
                ans += (char) (str.charAt(i) + 'a' - 'A');
            }
            i++;
        }
        return ans;

    }

    // diff between conseccutive characters in string

    public static String solution(String str) {
        // write your code here
        int n = str.length();
        String ans = str.charAt(0) + "";
        for (int i = 1; i < n; i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            int diff = curr - prev;
            ans += diff;
            ans += curr;
        }
        return ans;

    }

    // remove primes from arraylist

    public static void solution(ArrayList<Integer> al) {
        // write your code here
        for (int i = al.size() - 1; i >= 0; i--) {
            if (isPrime(al.get(i)) == true) {
                al.remove(i);
            }
        }

    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
