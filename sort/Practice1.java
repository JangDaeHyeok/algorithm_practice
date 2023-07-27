package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수열에 속해 있는 수의 개수 입력
        int n = sc.nextInt();

        int[] array = new int[n];
        // n개의 정수를 입력받아 배열에 저장
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // int -> Integer array 변환
        Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        // 내림차순 정렬
        Arrays.sort(integerArray, Comparator.reverseOrder());

        // 출력
        System.out.println(Arrays.toString(integerArray));
    }

}
