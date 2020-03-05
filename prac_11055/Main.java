package prac_11055;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int[] arr = new int[1001];
		int[] dp = new int[1001];
		int result = 0;

		str = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(str[i - 1]);

		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = arr[i];
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
		}

		for(int i = 1; i <= N; i++)
			result = Math.max(result, dp[i]);
		System.out.println(result);
		
		br.close();
	}

}
