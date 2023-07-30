package binarySearch;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n(가게의 부품 개수) 입력 받기
        int n = sc.nextInt();

        // 가게에 있는 전체 부품 번호를 입력 받아 set 자료형에 저장
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            set.add(x);
        }

        // m(손님이 확인 요청한 부품 개수) 입력 받기
        int m = sc.nextInt();
        int[] targets = new int[m];
        for(int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for(int target : targets) {
            if(set.contains(target)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }

}
