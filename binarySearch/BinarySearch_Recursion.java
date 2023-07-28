package binarySearch;

import java.util.Scanner;

/**
 * 재귀 함수를 이용한 이진 탐색 구현 연습
 */
public class BinarySearch_Recursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진탐색 실행
        int result = binarySearch(arr, target, 0, n - 1);

        // 이진탐색 결과 출력
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }

    /**
     * 이진 탐색 소스 코드 구현(재귀 함수)
     * @param arr 탐색할 배열
     * @param target 찾고자 하는 값
     * @param start 시작점
     * @param end 끝점
     * @return 찾고자 하는 값의 위치(중간점)
     */
    public static int binarySearch(int[] arr, int target, int start, int end) {
        // 시작점이 끝점보다 큰 경우 -1 반환
        if(start > end) return -1;

        // 중간점
        int mid = (start + end) / 2;

        // 찾고자 하는 값을 찾은 경우 반환
        if(arr[mid] == target) return mid;
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if(arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else return binarySearch(arr, target, mid + 1, end);
    }

}
