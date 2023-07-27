package sort;

import java.util.Arrays;

/**
 * 퀵 정렬 구현 연습
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    /**
     * 퀵 정렬 메소드
     *
     * @param array 정렬 할 배열
     * @param start 현재 배열의 왼쪽
     * @param end   현재 배열의 오른쪽
     */
    public static void sort(int[] array, int start, int end) {
        // 원소가 1개인 경우 종료
        if(start >= end) {
            return;
        }

        // pivot을 기준으로 파티션을 나누고 정렬
        int pivot = horePartition(array, start, end);

        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
    }

    /**
     * HorePartition 호어 분할 방식을 기준으로 파티션을 나누기 위한 정렬 메소드
     * 리스트에서 첫 번째 데이터를 피벗으로 정한다.
     *
     * @param array 정렬할 배열
     * @param start 현재 배열의 가장 왼쪽 부분
     * @param end   현재 배열의 가장 오른쪽 부분
     * @return      최종적으로 위치한 피벗의 위치를 반환
     */
    public static int horePartition(int[] array, int start, int end) {
        int pivot = start; // 피벗은 첫 번째 원소
        int left = start + 1;
        int right = end;

        // left가 right보다 작을 때 까지만 반복
        while(left < right) {
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while(left <= end && array[left] <= array[pivot])
                left++;

            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while(right > start && array[right] >= array[pivot])
                right--;

            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if(left > right) {
                swap(array, right, pivot);
            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            else {
                swap(array, left, right);
            }
        }

        // 파티션 반환
        return right;
    }

    /**
     * 배열 데이터 스왑
     *
     * @param array 스왑할 배열
     * @param i     스왑할 데이터의 위치
     * @param j     스왑할 데이터의 위치2
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
