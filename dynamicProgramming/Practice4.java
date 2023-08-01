package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Practice4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N, M을 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        // N개의 화폐 단위 정보를 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(바텀업)
        d[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = arr[i]; j <= m; j++) {
                d[j] = Math.min(d[j], d[j - arr[i]] + 1);
            }
        }

        // 결과 출력
        System.out.println(d[m] == 10001 ? -1 : d[m]);
    }

}
