import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

P P P P | P P <- this pair

needs one more (P, P)

P P P P | P P P P

P P | P P | P P | P P

8 elements or 4 pairs

count2 must be >= 4 (2 pairs for square + 2 pairs for rectangle)

 */

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			int[] freq = new int[100_001];
			Arrays.fill(freq, 0);
			int count2 = 0, count4 = 0;
			for (int i = 0; i < n; i++) {
				count2 -= freq[a[i]] / 2;
				count4 -= freq[a[i]] / 4;
				freq[a[i]]++;
				count2 += freq[a[i]] / 2;
				count4 += freq[a[i]] / 4;
			}
			int q = fs.nextInt();
			for (int i = 0; i < q; i++) {
				char op = fs.next().charAt(0);
				int num = fs.nextInt();
				count2 -= freq[num] / 2;
				count4 -= freq[num] / 4;
				if (op == '+') {
					freq[num]++;
				} else {
					freq[num]--;
				}
				count2 += freq[num] / 2;
				count4 += freq[num] / 4;
				if (count4 >= 1 && count2 >= 4) {
					out.println("YES");
				} else {
					out.println("NO");
				}
			}
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
