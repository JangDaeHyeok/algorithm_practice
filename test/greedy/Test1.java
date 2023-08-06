package test.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test1 {

    private static int n;
    private static List<Integer> inputList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 모험가 수 입력받기
        n = sc.nextInt();

        // 각 모험가의 공포도 입력받기
        for(int i = 0; i < n; i++) {
            inputList.add(sc.nextInt());
        }

        // 공포도 리스트 오름차순 정렬
        Collections.sort(inputList);

        // 총 그룹의 수
        int result = 0;
        // 현재 그룹에 포함된 모험가의 수
        int count = 0;

        for(int x : inputList) {
            // 현재 그룹에 포함된 모험가의 수 1 증가
            count++;

            // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
            if(count >= x) {
                result++;
                count = 0;
            }
        }

        // 결과 출력
        System.out.println(result);
    }

}
