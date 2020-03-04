package prac_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);

		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		int max = Integer.MIN_VALUE;

		str = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(str[i - 1]);

		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			int ck = 0;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					ck = Math.max(ck, dp[j]);
					dp[i] = ck + 1;
				}
			}
		}

		for (int i = 1; i <= N; i++)
			max = Math.max(max, dp[i]);
		System.out.println(max);

		br.close();
	}

}
