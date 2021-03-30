package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_BOJ2110_�ڿ��� {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // ���� ����
		int C = Integer.parseInt(st.nextToken()); // �������� ����
		int[] x = new int[N]; // ���� ��ǥ
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE; // ���� ��ǥ �ּҰ�, �ִ밪
		for(int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(in.readLine());
			if(x[i] < min) min = x[i];
			if(x[i] > max) max = x[i];
		}
		
		// �̺� Ž������ �ִ� �Ÿ� ����
		int lt = 0, rt = max - min, mid = 0, cnt = 0, prev = 0;
		while(lt < rt) {
			mid = (lt + rt) / 2; // �ִ� �Ÿ�
			cnt = 1; // x[0] �����ϰ� ����
			prev = x[0];
			
			for(int i = 1; i < N; i++) {
				// �ִ� �Ÿ� �̻� ������ ���� �����ϱ�
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
