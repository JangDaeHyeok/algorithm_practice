package sort;

import java.util.Arrays;

/**
 * 삽입 정렬 구현 연습
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        insertionSort(array);
    }

    static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) { // 인덱스 i부터 1까지 감소하며 반복
                if(array[j] < array[j - 1]) { // 한 칸씩 왼쪽으로 이동
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                else { // 본인보다 작은 데이터를 만나면 멈춤
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

}
