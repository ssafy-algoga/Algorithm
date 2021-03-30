package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day1_BOJ9935_¹Ú¿ø¼® {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String str = in.readLine();
		String bombStr = in.readLine();
		int strLen = str.length();
		int bombStrLen = bombStr.length();
		char[] result = new char[strLen];
		int size = 0;
		
		for(int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			if(c == bombStr.charAt(bombStrLen - 1)) {
				result[size] = c;
				boolean flag = true;
				for(int j = size; j >= size - bombStrLen + 1; j--) {
					if(result[j] != bombStr.charAt(j - size + bombStrLen - 1)) {
						flag = false;
						break;
					}
				}
				if(flag) size -= bombStrLen - 1;
				else size++;
			} else {
				result[size++] = c;
			}
		}
		
		if(size == 0) System.out.println("FRULA");
		else {
			for(int i = 0; i < size; i++) {
				System.out.print(result[i]);
			}
		}
	}
}
