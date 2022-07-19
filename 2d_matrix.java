import java.util.*;

class solution{
    public static void state_of_wakanda() {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        }
        for (int j = 0; j < m; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    System.out.println(arr[i][j]);
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                }
            }
        }

    }

    //print diagonal

    public static void printDiagonal(){
        // write your code here
        Scanner sc= new Scanner(System.in);
	int n= sc.nextInt();
	int[][] arr= new int[n][n];
	for(int i=0;i<n;i++){
	    for(int j=0;j<n;j++)
	         arr[i][j]= sc.nextInt();
	}
	for(int gap=0;gap<n;gap++){
	    for(int i=0,j=gap;i<n && j<n; i++,j++){
	        System.out.println(arr[i][j]);
	    }
	}
    }

    //spiral display

    public static void spiral(){
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                arr[i][j] = sc.nextInt();
        }
        int rmin = 0;
        int rmax = n - 1;
        int cmin = 0;
        int cmax = m - 1;
        int tele = n * m;
        while (tele > 0) {
            for (int r = rmin; r <= rmax && tele > 0; r++) {
                System.out.println(arr[r][cmin]);
                tele--;
            }
            cmin++;
            for (int c = cmin; c <= cmax && tele > 0; c++) {
                System.out.println(arr[rmax][c]);
                tele--;
            }
            rmax--;
            for (int r = rmax; r >= rmin && tele > 0; r--) {
                System.out.println(arr[r][cmax]);
                tele--;
            }
            cmax--;
            for (int c = cmax; c >= cmin && tele > 0; c--) {
                System.out.println(arr[rmin][c]);
                tele--;

            }
            rmin++;
        }
    }

    //exit point of matrix

    public static void exitPoint(String[] args){
        // write your code here
        Scanner sc= new Scanner(System.in);
	int n= sc.nextInt();
	int m= sc.nextInt();
	int[][] arr= new int[n][m];
	for(int i=0;i<n;i++){
	    for(int j=0;j<m;j++){
	        arr[i][j]= sc.nextInt();
	    }
	}
	int dir=0;
	int i=0,j=0;
	while(true){
	     dir=(dir+arr[i][j])%4;
	     if(dir==0){ //east
	         j++;
	         if(j==m){
	             System.out.println(i+""+(j-1));
	             break;
	         }
	     }
	     if(dir==1){ //south
	         i++;
	         if(i==n){
	             System.out.println((i-1)+""+j);
	             break;
	         }
	     }
	     if(dir==2){
	         j--;
	         if(j==-1){
	             System.out.println(i+""+j+1);
	             break;
	         }
	     }
	     if(dir==3){
	         i--;
	         if(i==-1){
	             System.out.println(i+1+""+j);
	             break;
	         }
	     }
	}
    }

    //saddle point

    public static void saddlePoint(){
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flag = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int minValue = Integer.MAX_VALUE;
            int c = -1;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < minValue) {
                    minValue = arr[i][j];
                    c = j;
                }
            }
            int row = ColMax(arr, c);
            if (row == i) {
                System.out.println(arr[row][c]);
                flag = 1;
            }
        }
        if (flag == 0)
            System.out.println("Invalid input");

    }

    public static int ColMax(int[][] arr, int c) {
        int maxValue = Integer.MIN_VALUE;
        int r = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][c] > maxValue) {
                maxValue = arr[i][c];
                r = i;
            }
        }

        return r;
    }

    //search in sorted 2d array

    public static void searchInSorted(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flag = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        int x = sc.nextInt();

        int i=0;
        int j=n-1;

        while(i<n && j>=0){
            if(arr[i][j]==x){
                System.out.println(i);
                System.out.println(j);
            }

            else if(x<arr[i][j]){
                j--;
            }
            else{
                i++;
            }
        }

        System.out.println("Not Found");
    }
}
