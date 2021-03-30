package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_BOJ2110_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기의 개수
		int[] x = new int[N]; // 집의 좌표
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; // 집의 좌표 최소값, 최대값
		for(int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(in.readLine());
			if(x[i] < min) min = x[i];
			if(x[i] > max) max = x[i];
		}
		
		// 이분 탐색으로 최대 거리 결정
		int lt = 0, rt = max - min, mid = 0, cnt = 0, prev = 0;
		while(lt < rt) {
			mid = (lt + rt) / 2; // 최대 거리
			cnt = 1; // x[0] 선택하고 시작
			prev = x[0];
			
			for(int i = 1; i < N; i++) {
				// 최대 거리 이상 떨어진 집만 선택하기
				if(x[i] - prev >= mid) {
					cnt++;
					prev = x[i];
				} 
			}
			
			if(cnt < C) {
				rt = mid - 1;
			} else {
				lt = mid + 1;
			}
		}
		
		System.out.println(mid);
	}
}
