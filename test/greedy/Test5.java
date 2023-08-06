package test.greedy;

import java.util.Scanner;

public class Test5 {

    // 볼링공 개수(n), 볼링공 무게 상한선(m)
    private static int n, m;
    // 볼링공 리스트
    private static int[] balls = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 볼링공 개수 입력 받기
        n = sc.nextInt();
        // 볼링공 무게 상한선 입력 받기
        m = sc.nextInt();

        // 공 종류 입력 받기
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            balls[x]++;
        }

        // 결과
        int result = 0;
        // 임시 공 개수 저장용
        int tmpN = n;

        // 공 무게 상한선만큼 반복
        for(int i = 1; i <= m; i++) {
            // 현재 볼링공 무게만큼의 개수 빼기
            tmpN -= balls[i];
            // 결과 = 현재 공의 개수 * 남은 공 개수
            result += balls[i] * tmpN;
        }

        // 결과 출력
        System.out.println(result);
    }

}
