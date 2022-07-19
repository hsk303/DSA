import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Solution {
	// Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row, pre = null;
		for (int i = 0; i < numRows; ++i) {
			row = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j)
				if (j == 0 || j == i)
					row.add(1);
				else
					row.add(pre.get(j - 1) + pre.get(j));
			pre = row;
			res.add(row);
		}
		return res;
    }

	// kadane's Algorithm

		public int maxSubArray(int[] nums) {
			int msf = nums[0];
			int meh = 0;
			int j = 0;

			for (int i = 0; i < nums.length; i++) {
				meh += nums[i];

				if (meh > msf) {
					msf = meh;
				}
				if (meh < 0) {
					meh = 0;
					j = i + 1;
				}
			}
			return msf;
		}

	// sort arrays of 0,1,2

		public void sortColors(int[] nums) {
			int low = 0;
			int high = nums.length - 1;
			int mid = 0;
			int temp;

			while (mid <= high) {
				switch (nums[mid]) {
					case 0: {
						temp = nums[low];
						nums[low] = nums[mid];
						nums[mid] = temp;
						low++;
						mid++;
						break;
					}

					case 1: {
						mid++;
						break;
					}
					case 2: {
						temp = nums[mid];
						nums[mid] = nums[high];
						nums[high] = temp;
						high--;
						break;
					}
				}
			}
		}

	// Stock buy and sell

	public int maxProfit(int[] prices) {
		int maxPro = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxPro = Math.max(maxPro, prices[i] - minPrice);
		}
		return maxPro;
	}

	// rotate by 90

	static void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = 0;
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix.length - 1 - j];
				matrix[i][matrix.length - 1 - j] = temp;
			}
		}
	}

	// merge intervals

	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();

		if (intervals.length == 0 || intervals == null) {
			return res.toArray(new int[0][]);
		}

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int[] i : intervals) {
			if (i[0] <= end) {
				end = Math.max(end, i[1]);
			} else {
				res.add(new int[] { start, end });
				start = i[0];
				end = i[1];
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[0][]);
	}

	// merge two sorted arrays without space

	static void merge(int[] arr1, int arr2[], int n, int m) {
    // code here
    int i, k;
    for (i = 0; i < n; i++) {
      // take first element from arr1 
      // compare it with first element of second array
      // if condition match, then swap
      if (arr1[i] > arr2[0]) {
        int temp = arr1[i];
        arr1[i] = arr2[0];
        arr2[0] = temp;
      }

      // then sort the second array
      // put the element in its correct position
      // so that next cycle can swap elements correctly
      int first = arr2[0];
      // insertion sort is used here
      for (k = 1; k < m && arr2[k] < first; k++) {
        arr2[k - 1] = arr2[k];
      }
      arr2[k - 1] = first;
    }
}

// find duplicates in n+1

	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		fast = nums[0];

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}

	// Inversion of an array

	int merge(int arr[], int temp[], int left, int mid, int right) {
		int inv_count = 0;
		int i = left;
		int j = mid;
		int k = left;
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inv_count = inv_count + (mid - i);
			}
		}

		while (i <= mid - 1)
			temp[k++] = arr[i++];

		while (j <= right)
			temp[k++] = arr[j++];

		for (i = left; i <= right; i++)
			arr[i] = temp[i];

		return inv_count;
	}

	int merge_Sort(int arr[], int temp[], int left, int right) {
		int mid, inv_count = 0;
		if (right > left) {
			mid = (left + right) / 2;

			inv_count += merge_Sort(arr, temp, left, mid);
			inv_count += merge_Sort(arr, temp, mid + 1, right);

			inv_count += merge(arr, temp, left, mid + 1, right);
		}
		return inv_count;
	}

	//span of array

	public static void span(String[] args) throws Exception{
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int span = arr[n - 1] - arr[0];
		System.out.print(span);
	}

	//find element in array

	public static void findElement(String[] args){
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int d = sc.nextInt();
		Boolean flag = false;
		int index = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] == d) {
				index = i;
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println(index);
		} else
			System.out.println(-1);
	}

	//reverse an array

	public static void reverse(int[] a) {
		// write your code here
		int n = a.length;
		for (int i = n - 1; i >= n / 2; i--) {
			int temp = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = temp;
		}
	}

	//Inversion of array

	public static int[] inverse(int[] a) {
		// write your code here
		int n = a.length;
		int[] inv = new int[n];
		for (int i = 0; i < n; i++) {
			inv[a[i]] = i;
		}

		return inv;
	}

	//rotate an array

	public static void rotate(int[] a, int k){
    // write your code here
   k=k%a.length;
   if(k<0)
      k=k+a.length;
    reverse(a, 0,a.length-k-1);
    reverse(a,a.length-k, a.length-1);
    reverse(a,0,a.length-1);
   
  }
  public static void reverse(int[] arr, int i, int j){
      int left=i;
      int right=j;
      while(left<=right){
          int temp=arr[left];
          arr[left]=arr[right];
          arr[right]=temp;
        left++;
        right--;
      }
  }

  // sum of two arrays

  	public static void sumodTwoArray(String[] args){
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int[] a1 = new int[n1];
		for (int i = 0; i < n1; i++)
			a1[i] = sc.nextInt();
		int n2 = sc.nextInt();
		int[] a2 = new int[n2];
		for (int i = 0; i < n2; i++)
			a2[i] = sc.nextInt();
		int[] sum = new int[n1 > n2 ? n1 : n2];
		int i = a1.length - 1;
		int j = a2.length - 1;
		int k = sum.length - 1;
		int c = 0;
		while (k >= 0) {
			int d = c;
			if (i >= 0)
				d += a1[i];
			if (j >= 0)
				d += a2[j];
			c = d / 10;
			d = d % 10;
			sum[k] = d;
			i--;
			j--;
			k--;
		}
		if (c != 0)
			System.out.println(c);
		for (int val : sum)
			System.out.println(val);
	}

	//diff of array

	public static void diffofTwoArray(String[] args){
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1[] = new int[n1];
		for (int i = 0; i < n1; i++)
			a1[i] = sc.nextInt();
		int n2 = sc.nextInt();
		int[] a2 = new int[n2];
		for (int i = 0; i < n2; i++)
			a2[i] = sc.nextInt();
		int[] diff = new int[n2];
		int i = a1.length - 1;
		int j = a2.length - 1;
		int k = diff.length - 1;
		int c = 0;
		while (k >= 0) {
			int d = 0;
			int av = i >= 0 ? a1[i] : 0;
			if (c + a2[j] >= av) {
				d = a2[j] + c - av;
				c = 0;
			} else {
				d = a2[j] + c + 10 - av;
				c = -1;
			}
			diff[k] = d;
			i--;
			j--;
			k--;
		}
		int idx = 0;
		while (idx < diff.length) {
			if (diff[idx] == 0)
				idx++;
			else
				break;
		}
		while (idx < diff.length) {
			System.out.println(diff[idx]);
			idx++;
		}

	}
	// all subarrays of an array

	public static void subarray(String[] args) {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(arr[k] + "	");
				}
				System.out.println();
			}
		}
	}

	// subsets of array

	public static void subsets(String[] args){
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int limit = (int) Math.pow(2, arr.length);
		for (int i = 0; i < limit; i++) {
			String set = "";
			int temp = i;
			for (int j = arr.length - 1; j >= 0; j--) {
				int r = temp % 2;
				temp = temp / 2;
				if (r == 0)
					set = "-	" + set;
				else
					set = arr[j] + "	" + set;
			}
			System.out.println(set);
		}

	}

	//First and last idx

	public static void FLIndex(){
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int d = sc.nextInt();
		int fi = FirstIndex(arr, d);
		int li = LastIndex(arr, d);
		System.out.println(fi);
		System.out.println(li);
	}

	public static int FirstIndex(int[] arr, int d) {
		int si = 0, ei = arr.length - 1;
		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (arr[mid] == d) {
				if (mid - 1 >= 0 && arr[mid - 1] == d)
					ei = mid - 1;
				else
					return mid;
			} else if (d < arr[mid])
				ei = mid - 1;
			else
				si = mid + 1;
		}
		return -1;
	}

	public static int LastIndex(int[] arr, int d) {
		int si = 0, ei = arr.length - 1;
		while (si <= ei) {
			int mid = (si + ei) / 2;
			if (arr[mid] == d) {
				if (mid + 1 < arr.length && arr[mid + 1] == d)
					si = mid + 1;
				else
					return mid;
			} else if (d < arr[mid])
				ei = mid - 1;
			else
				si = mid + 1;
		}
		return -1;
	}

	
}