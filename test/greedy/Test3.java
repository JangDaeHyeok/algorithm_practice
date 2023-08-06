package test.greedy;

import java.util.Scanner;

public class Test3 {

    // 0과 1로만 이루어진 문자열
    private static String s;

    public static void main(String[] args) {
        // 0을 1로 바꾸는 경우 결과
        int count0 = 0;
        // 1을 0으로 바꾸는 경우 결과
        int count1 = 0;

        // 문자열 입력받기
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        // 첫 번째 원소 처리
        if(s.charAt(0) == '1')
            count0++;
        else
            count1++;

        // 문자열 길이만큼 반복
        for(int i = 0; i < s.length() - 1; i++) {
            // 현재 문자와 뒤의 문자가 다른 경우
            if(s.charAt(i) != s.charAt(i + 1)) {
                // 0에서 1로 바뀌는 경우
                if(s.charAt(i + 1) == '1') count0++;
                // 1에서 0으로 바뀌는 경우
                else count1++;
            }
        }

        // 결과 출력
        System.out.println(Math.min(count0, count1));
    }

}
