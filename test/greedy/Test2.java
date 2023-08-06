package test.greedy;

import java.util.Scanner;

public class Test2 {

    // 0~9로만 이루어진 문자열
    private static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 입력받기
        s = sc.next();

        // 결과
        int result = s.charAt(0) - '0';;

        // 문자열 길이만큼 반복
        for(int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';

            // 숫자가 1보다 작거나 같은 경우 더하기
            if(num <= 1 || result <= 1)
                result += num;
            // 숫자가 1보다 큰 경우 곱하기
            else
                result *= num;
        }

        // 결과 출력
        System.out.println(result);
    }



}
