import java.util.*;

public class recursion {
    public static void printDecreasing(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printDecreasing(n - 1);

    }

    public static void printIncreasing(int n) {
        if (n == 0)
            return;
        printIncreasing(n - 1);
        System.out.println(n);
    }

    public static void pdi(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static int power(int a, int b) {
        if (b == 0)
            return 1;
        return a * power(a, b - 1);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        // idx=0
        if (idx == arr.length)
            return;
        displayArrReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static void displayArr(int[] arr, int idx) {
        if (idx == arr.length)
            return;
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);

    }

    public static int maxOfArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return -(int) 1e9;
        }
        int recAns = maxOfArray(arr, idx + 1);
        return Math.max(arr[idx], recAns);
    }

    public static int firstIndex(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;
        if (arr[idx] == data)
            return idx;
        int index = firstIndex(arr, idx + 1, data);
        return index;
    }

    public static int lastIndex(int[] arr, int idx, int data) {
        if (idx == arr.length)
            return -1;
        int index = lastIndex(arr, idx + 1, data);
        if (index != -1)
            return index;
        return arr[idx] == data ? idx : -1;
    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> recAns = gss(str.substring(1));
        char ch = str.charAt(0);
        ArrayList<String> myAns = new ArrayList<>();
        for (String s : recAns) {
            myAns.add(s);
        }
        for (String s : recAns)
            myAns.add(ch + s);
        return myAns;
    }

    public static String[] nokiaKeys = { "-;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static ArrayList<String> getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(0);
        String code = nokiaKeys[ch - '0'];
        ArrayList<String> recAns = getKPC(str.substring(1));
        ArrayList<String> myAns = new ArrayList<>();
        for (int i = 0; i < code.length(); i++) {
            for (String s : recAns) {
                myAns.add(code.charAt(i) + s);
            }
        }
        return myAns;
    }

    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();
        for (int i = 1; i <= 3 && n - i >= 0; i++) {
            ArrayList<String> recAns = getStairPaths(n - i);
            for (String s : recAns) {
                myAns.add(i + s);
            }
        }
        return myAns;
    }

    public static int stairPaths(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            count += stairPaths(n - jump, ans + jump);
        }
        return count;
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();
        if (sc + 1 <= dc) {
            ArrayList<String> recAns = getMazePaths(sr, sc + 1, dr, dc);
            for (String s : recAns) {
                myAns.add("h" + s);
            }
        }
        if (sr + 1 <= dr) {
            ArrayList<String> recAns = getMazePaths(sr + 1, sc, dr, dc);
            for (String s : recAns) {
                myAns.add("v" + s);
            }
        }
        return myAns;
    }

    public static int mazePaths(int sr, int sc, int er, int ec, String ans) {
        if (sr == er && sc == ec) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        if (sc + 1 <= ec)
            count += mazePaths(sr, sc + 1, er, ec, ans + "H");
        if (sr + 1 <= er && sc + 1 <= ec) {
            count += mazePaths(sr + 1, sc + 1, er, ec, ans + "D");
        }
        if (sr + 1 <= er)
            count += mazePaths(sr + 1, sc, er, ec, ans + "V");
        return count;
    }

    public static ArrayList<String> getMazePathsjumps(int sr, int sc, int dr, int dc) {

        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myAns = new ArrayList<>();
        for (int jump = 1; sc + jump <= dc; jump++) {
            ArrayList<String> recAns = getMazePathsjumps(sr, sc + jump, dr, dc);
            for (String s : recAns) {
                myAns.add("h" + jump + s);
            }
        }

        for (int jump = 1; sr + jump <= dr; jump++) {
            ArrayList<String> recAns = getMazePathsjumps(sr + jump, sc, dr, dc);
            for (String s : recAns) {
                myAns.add("v" + jump + s);
            }
        }
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
            ArrayList<String> recAns = getMazePathsjumps(sr + jump, sc + jump, dr, dc);
            for (String s : recAns) {
                myAns.add("d" + jump + s);
            }
        }
        return myAns;
    }
}
