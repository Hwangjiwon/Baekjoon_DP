package prac_11054;

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
		int[] dpUp = new int[N + 1];
		int[] dpDown = new int[N + 2];
		int[] dp = new int[N + 1];
		int max = 0;

		str = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(str[i - 1]);

		dpUp[0] = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dpUp[i] < dpUp[j] + 1) {
					dpUp[i] = dpUp[j] + 1;
				}
			}
		}

		dpDown[N + 1] = 0;
		for (int i = N; i >= 1; i--) {
			for (int j = N; j > i; j--) {
				if (arr[j] < arr[i] && dpDown[i] < dpDown[j] + 1) {
					dpDown[i] = dpDown[j] + 1;
				}
			}
		}
		
		for (int i = 0; i <= N; i++) {
			dp[i] = dpUp[i] + dpDown[i];
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
		br.close();
	}

}
