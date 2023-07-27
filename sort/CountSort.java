package sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 계수 정렬 구현 연습
 */
public class CountSort {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

        countSort(array);
    }

    static void countSort(int[] array) {
        // 모든 범위를 포함하는 배열 선언
        int[] count = new int[Arrays.stream(array).max().getAsInt() + 1];

        // 각 데이터에 해당하는 인덱스의 값 증가
        Arrays.stream(array)
                .forEach(i -> count[i]++);

        // 배열에 기록된 정렬 정보 확인
        for(int i = 0 ; i < count.length; i++) {
            int tempI = i;

            IntStream.range(0, count[i])
                    .forEach(c -> System.out.print(tempI + " "));
        }
        System.out.println(); // 마지막에 줄바꿈
    }

}
