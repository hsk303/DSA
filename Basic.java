import java.util.*;

public class Basic {
    // prime

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        // write ur code here

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int flag = 1;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    flag = 0;
                    break;
                }

            }
            if (flag == 1)
                System.out.println("prime");
            else
                System.out.println("not prime");
        }
    }

    //Prime between low and high

    public static void primeLH(){
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        for (int i = low; i <= high; i++) {
            int flag = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }

            }
            if (flag == 1)
                System.out.println(i);
        }
    }

    // Fibanocci till N

    public static void Fib() {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 1, c = 0;
        System.out.println(a);
        System.out.println(b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
    
    // No of digits in no

    public static void countDigit(int n) {
        int n1 = n;
        int l1 = 0;
        while (n1 != 0) {
            n1 = n1 / 10;
            l1++;
        }
        System.out.println(l1);
    }

    // print digits

    public static void printDigits(int n) {
       int nod = 0;
       int temp=n;
       while(temp!=0){
        temp= temp/10;
        nod++;
       }

       int div = (int)Math.pow(10, nod-1);

       while(div!=0){
        int q = n/div;
        System.out.println(q);
         n = n%div;
         div=div/10;
       }
    }

    //print reverse of digit

    static void PrintRev(int n) {
        if (n == 0)
            return;
        int d = n % 10;
        System.out.println(d);
        PrintRev(n / 10);
    }

    // Rotate by k

    public static void rotateByK() {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int temp = n;
        int nod = 0;
        while (temp > 0) {
            temp = temp / 10;
            nod++;
        }
        k = k % nod;
        if (k < 0)
            k = k + nod;
        int div = 1;
        int multi = 1;
        for (int i = 1; i <= nod; i++) {
            if (i <= k)
                div *= 10;
            else
                multi *= 10;

        }
        int q = n / div;
        int rem = n % div;
        int rot = rem * multi + q;
        System.out.println(rot);

    }

    // GCD and LCM

    public static void GCDLCM(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int gcd = FindGCD(num1, num2);
        System.out.println(gcd);
        System.out.println((num1 * num2) / gcd);
    }

    static int FindGCD(int a, int b) {
        if (b == 0)
            return a;
        else
            return (FindGCD(b, a % b));
    }

    // Pythagorus Triplet

    public static void Pythagorus(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b)
            System.out.println(true);
        else
            System.out.println(false);

    }

    //digit frequency in a no:

    public static int getDigitFrequency(int n, int d) {
        // write code here
        int count = 0;
        while (n != 0) {
            int digit = n % 10;
            n = n / 10;
            if (digit == d)
                count++;
        }
        return count;
    }

}
