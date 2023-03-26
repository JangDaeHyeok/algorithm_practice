package implementation;

import java.util.Scanner;

/**
 * Implementation Practice 2 (이론)
 * 시각
 * 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서
 * 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램을 작성하시오.
 * 0 <= N <= 23
 */
public class Practice2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("시간 n : ");
        int h = sc.nextInt();
        int cnt = 0;

        for(int i = 0; i <= h; i++) {
            for(int m = 1; m <= 60; m++) {
                for(int s = 1; s <= 60; s++) {
                    // 매 상황마다 3이 포함되어 있는지 체크
                    if(check(i, m, s))
                        cnt++;
                }
            }
        }

        System.out.println("3이 하나라도 포함된 시각의 수 : " + cnt);
    }

    private static boolean check(int i, int m, int s) {
        if(i % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s % 10 == 3 || s / 10 == 3) {
            return true;
        }

        return false;
    }

}
