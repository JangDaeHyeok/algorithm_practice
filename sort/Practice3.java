package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Practice3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n과 k 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 배열 A의 원소 입력받기
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // 배열 B의 원소 입력받기
        Integer[] b = new Integer[n];
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // A배열 오름차순 정렬
        Arrays.sort(a);
        // B배열 내림차순 정렬
        Arrays.sort(b, Comparator.reverseOrder());

        // 첫 번째 인덱스부터 확인하며, 두 배열의 원소를 최대 k번 비교
        for(int i = 0; i < k; i++) {
            // a의 원소가 b의 원소보다 작은 경우 swap
            if(a[i] < b[i]) {
                swap(a, b, i);
            }
            // a의 원소가 b의 원소보다 큰 경우 break
            else {
                break;
            }
        }

        // 결과 출력
        int sum = Arrays.stream(a).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }


    private static void swap(Integer[] a, Integer[] b, int i) {
        int temp = a[i];
        a[i] = b[i];
        b[i] = temp;
    }
}
