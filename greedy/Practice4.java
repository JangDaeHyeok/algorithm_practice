package greedy;

import java.util.Scanner;

/**
 * Greedy Practice 4
 * 1이 될 때까지
 * 어떠한 수 N이 1이 될 때까지 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
 * 단, 두 번째 연산은 N이 K로 나누어떨어질 때만 선택할 수 있다.
 * 1. N에서 1을 뺀다.
 * 2. N을 K로 나눈다.
 * 최소 횟수를 구하라.
 */
public class Practice4 {

    public static void main(String[] args) {
        int result = solution();
        System.out.println("최소 횟수 : " + result);
    }

    private static int solution() {
        int result = 0;

        int N = 0;
        int K = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("N : ");
        N = sc.nextInt();
        System.out.print("K : ");
        K = sc.nextInt();

        while(N > 1) {
            if(N % K == 0) {
                N /= K;
            }else {
                N--;
            }

            result++;
        }

        return result;
    }
}
