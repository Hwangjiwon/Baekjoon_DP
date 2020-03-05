package prac_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		int max = 0;

		str = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(str[i]);

		dp[N] = 0;
		for (int i = N; i >= 0; i--) {
			for (int j = N; j > i; j--) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		for (int i = 0; i < N; i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);

		br.close();
	}

}
