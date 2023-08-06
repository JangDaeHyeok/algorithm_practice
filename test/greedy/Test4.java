package test.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test4 {

    // 동전 개수
    private static int n;
    // 동전 종류
    private static List<Integer> coins = new ArrayList<>();

    public static void main(String[] args) {
        // 동전 개수 입력받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 동전 종류 입력받기
        for(int i = 0; i < n; i++)
            coins.add(sc.nextInt());

        // 동전 종류 오름차순 정렬
        Collections.sort(coins);

        // 결과
        int result = 1;

        // 동전 개수만큼 반복
        for(int i = 0; i < coins.size(); i++) {
            if(result < coins.get(i))
                break;

            result += coins.get(i);
        }

        // 결과 출력 (결과 + 1)
        System.out.println(result);
    }

}
