package test.implementation;

import java.util.Scanner;

public class Test1 {

    // 캐릭터의 점수
    private static String str;
    // 점수의 총 합
    private static int summary = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 왼쪽 부분 합 구하기
        for(int i = 0; i < str.length() / 2; i++) {
            summary += str.charAt(i) - '0';
        }

        // 오른쪽 부분 합 구하기
        for(int i = str.length() / 2; i < str.length(); i++) {
            summary -= str.charAt(i) - '0';
        }

        // 결과 출력
        if(summary == 0) System.out.println("LUCKY");
        else System.out.println("READY");
    }

}
