package prac_2579;

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

		for (int i = 1; i <= N; i++) {
			str = br.readLine().split(" ");
			arr[i] = Integer.parseInt(str[0]);
		}

		if (N >= 1)
			dp[1] = arr[1];
		if (N >= 2)
			dp[2] = arr[1] + arr[2];
		if (N >= 3) {
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
			}
		}
		System.out.println(dp[N]);
		br.close();
	}

}
