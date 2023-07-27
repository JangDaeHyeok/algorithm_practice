package sort;

import java.util.Arrays;

/**
 * 선택정렬 구현 연습
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        selectionSort(array);
    }

    static void selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int minIndex = i; // 가장 작은 원소의 인덱스

            for(int j = i + 1; j < array.length; j++) {
                if(array[minIndex] > array[j])
                    minIndex = j;
            }

            // 스와프
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        // 출력
        System.out.println(Arrays.toString(array));
    }

}
