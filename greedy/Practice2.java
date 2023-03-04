package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Greedy Practice 2
 * 큰 수의 법칙
 * 다양한 수로 이루어진 배열이 있을 떄 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다.
 * 단, 배열의 특정한 인젝스(번호)에 해당하는 수가
 * 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징이다.
 */
public class Practice2 {

    public static void main(String[] args) {
        // 시작 시간
        long startTime = System.currentTimeMillis();

        int result = getResult(5, 8, 3);
        System.out.println("가장 큰 수 : " + result);

        // 종료 시간
        long endTime = System.currentTimeMillis();
        // 총 소요 시간
        long durationTimeSec = endTime - startTime;
        System.out.println("총 소요 시간 : " + (durationTimeSec / 1000) + "sec"); // 세컨드(초 단위 변환)
    }

    /**
     * 입력으로 주어지는 K는 항상 M보다 작거나 같다.
     *
     * @param N 배열의 크기 (2 <= N <= 1000)
     * @param M 숫자가 더해지는 횟수 (1 <= M <= 10000)
     * @param K 초과하여 더해질 수 없는 횟수 (1 <= K <= 10000)
     * @return 가장 큰 수
     */
    private static int getResult(int N, int M, int K) {
        // result
        int result = 0;
        // scanner
        Scanner sc = new Scanner(System.in);

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.print((i + 1) + "번째 숫자 : ");
            arr[i] = sc.nextInt();
        }

        // 입력받은 배열 정렬
        Arrays.sort(arr);

        // 가장 큰 수
        int first = arr[N - 1];
        // 두번째로 큰 수
        int second = arr[N - 2];

        // 가장 큰 수가 더해지는 횟수
        int firstCount = (M / (K + 1)) * K;
        firstCount += M % (K + 1);

        // 가장 큰 수 더하기
        result += firstCount * first;
        // 두번째로 큰 수 더하기
        result += (M - firstCount) * second;

        return result;
    }

}
