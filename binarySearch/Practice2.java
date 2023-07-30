package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Practice2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 떡의 개수(N)와 요청한 떡의 길이(M)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 개별 높이 정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 탐색 실행
        int result = binarySearch(arr, m, 0, Arrays.stream(arr).max().getAsInt());

        // 결과 출력
        System.out.println(result);
    }

    /**
     * 이진 탐색 (재귀 함수)
     *
     * @param arr 탐색할 배열
     * @param target 찾고자 하는 값
     * @param start 시작점
     * @param end 끝점
     * @return 찾고자 하는 값의 위치 (중간점)
     */
    public static int binarySearch(int[] arr, int target, int start, int end) {
        // 시작점보다 끝잠이 크다면 -1 반환
        if(start > end) return -1;

        // 탐색 번복 실행
        int result = 0;
        while(start <= end) {
            long total = 0;

            // 중간점
            int mid = (start + end) / 2;

            // 떡 자르고 남은 떡 길이 계산
            for(int i = 0; i < arr.length; i++) {
                // 잘랐을 때 떡의 양 계산
                if(arr[i] > mid) total += arr[i] - mid;
            }

            // 떡의 양이 부족하다면 더 많이 자르기(왼쪽 부분 탐색)
            if(total < target) {
                end = mid - 1;
            }
            // 떡의 양이 충분하다면 덜 자르기(오른쪽 부분 탐색)
            else {
                result = mid; // 최대한 덜 잘랐을때가 정답이므로 여기서 result 기록
                start = mid + 1;
            }
        }

        // 결과 반환
        return result;
    }

}
