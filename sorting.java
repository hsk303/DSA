import java.util.*;

public class sorting {
    public static void sort01(int[] arr) {
        // write your code here
        int p = -1, itr = 0;
        while (itr < arr.length) {
            if (arr[itr] == 0) {
                swap(arr, ++p, itr);
            }
            itr++;
        }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + j + " and index " + i);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort012(int[] arr) {
        // write your code here
        int p = -1, itr = 0, p2 = arr.length - 1;
        while (itr <= p2) {
            if (arr[itr] == 0) {
                swap(arr, ++p, itr++);
            } else if (arr[itr] == 2)
                swap(arr, p2--, itr);
            else
                itr++;

        }

    }

    public static void mergeWithNoSpace(int[] arr1, int[] arr2) {
        // Write your code here
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] arr = new int[n + m];
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else
                arr[k++] = arr2[j++];
        }
        while (i < n) {
            arr[k++] = arr1[i++];
        }
        while (j < m) {
            arr[k++] = arr2[j++];
        }
        print(arr);
    }

    public static void bubble(int arr[], int n) {

        // Write your code here.
        n = arr.length;
        for (int li = n - 1; li > 0; li--) {
            for (int i = 1; i <= li; i++) {
                if (arr[i - 1] > arr[i])
                    swapb(arr, i, i - 1);
            }
        }

    }

    public static void swapb(int[] arr, int si, int ei) {
        int temp = arr[si];
        arr[si] = arr[ei];
        arr[ei] = temp;
    }

    public static void bubbleOpt(int arr[], int n) {

        // Write your code here.
        n = arr.length;
        for (int li = n - 1; li > 0; li--) {
            boolean isSwaped = false;
            for (int i = 1; i <= li; i++) {
                if (arr[i - 1] > arr[i])
                    swapb(arr, i, i - 1);
                isSwaped = true;
            }

            if (!isSwaped)
                break;
        }

    }

    public static void selectionSort(int[] arr) {
        // write your code here
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        // write your code here
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
                else
                    break;
            }

        }

    }

    public static void partition(int[] arr, int pivot) {
        // write your code here
        int p = -1, itr = 0;
        int n = arr.length;
        while (itr < n) {
            if (arr[itr] <= pivot) {
                swap(arr, itr, ++p);
            }
            itr++;
        }
    }

    public static int partitionOverPivot(int[] arr, int si, int ei, int pidx) {
        swap(arr, pidx, ei);

        int p = si - 1, itr = si;

        while (itr <= ei) {
            if (arr[itr] <= arr[ei]) {
                swap(arr, ++p, itr);
            }
            itr++;
        }
        return p;
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si > ei) {
            return;
        }

        int pidx = ei;
        int p = partitionOverPivot(arr, si, ei, pidx);

        quickSort(arr, si, p - 1);
        quickSort(arr, p + 1, ei);
    }

    public static void quickSelect(int[] arr, int si, int ei, int idx) {
        // for k-th largest: n-k=idx

        if (si > ei) {
            return;
        }

        int pivot = ei;
        int pidx = partitionOverPivot(arr, si, ei, pivot);
        if (idx == pidx)
            return;
        else if (idx > pidx)
            quickSelect(arr, pidx + 1, ei, idx);
        else
            quickSelect(arr, si, pidx - 1, idx);
    }

    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return arr1.length == 0 ? arr2 : arr1;

            int i = 0, j = 0, k = 0;
            int n = arr1.length;
            int m = arr2.length;

            int[] arr = new int[n + m];

            while (i < n && j < m) {
                if (arr[i] < arr[j]) {
                    arr[k++] = arr1[i++];
                } else {
                    arr[k++] = arr2[j++];
                }
            }

            while (i < n) {
                arr[k++] = arr1[i++];
            }
            while (j < m) {
                arr[k++] = arr2[j++];
            }
        }
        return arr;
    }

    public static int[] mergesort(int[] arr, int si, int ei) {
        if (si == ei) {
            return new int[] { arr[si] };
        }

        int mid = (si + ei) / 2;
        int[] left = mergesort(arr, si, mid);
        int[] right = mergesort(arr, mid + 1, ei);

        return mergeTwoSortedArray(left, right);
    }

    public static void targetSumPair(int[] arr, int target) {
        // write your code here
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        int si = 0, ei = n - 1;
        while (si < ei) {
            int sum = arr[si] + arr[ei];
            if (sum == target) {
                System.out.print(arr[si++] + "," + " " + arr[ei--]);
                System.out.println();
            } else if (sum < target)
                si++;
            else
                ei--;
        }

    }

    public static void _quickSort(int[] arr, int si, int ei) {
        if (si > ei)
            return;
        int pivot = ei;
        int pidx = segregate(arr, si, ei, pivot);
        _quickSort(arr, si, pidx - 1);
        _quickSort(arr, pidx + 1, ei);
    }

    public static int segregate(int[] arr, int si, int ei, int pivot) {
        swap(arr, pivot, ei);
        int p = si - 1, itr = si;
        while (itr <= ei) {
            if (arr[itr] <= arr[ei])
                swap(arr, ++p, itr);
            itr++;
        }
        return p;
    }

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {

        if (cs > ts) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String res = asf;
            if (oddc != null)
                res += oddc;

            res += rev;
            System.out.println(res);
            return;
        }
        for (char ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq > 0) {
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }

    static int c = 1;

    public static void friendsPairing(int count, int n, boolean[] used, String asf) {
        if (count == n) {
            System.out.println(c++ + "." + asf);
            return;
        }
        int fup = 1;
        while (fup <= n && used[fup]) {
            fup++;
        }
        used[fup] = true;
        friendsPairing(count + 1, n, used, asf + "(" + fup + ") ");

        for (int pp = fup + 1; pp <= n; pp++) {
            if (!used[pp]) {
                used[pp] = true;
                friendsPairing(count + 2, n, used, asf + "(" + fup + "," + pp + ") ");
                used[pp] = false;
            }
        }
        used[fup] = false;
    }

    public static int friends(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;

        return friends(n - 1) + friends(n - 2) * (n - 1);
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dict.contains(left)) {
                String right = str.substring(i + 1);
                wordBreak(right, ans + left + " ", dict);
            }
        }
    }

    static String max;

    public static void KMostSwaps(String str, int k) {
        if (Integer.parseInt(str) > Integer.parseInt(max))
            max = str;
        if (k == 0) {
            return;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    String swapped = swap(str, i, j);
                    KMostSwaps(swapped, k - 1);
                }
            }
        }
    }
}
