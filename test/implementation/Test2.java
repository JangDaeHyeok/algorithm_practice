package test.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test2 {

    // 입력된 문자열
    private static String str;
    // 문자열의 문자만 저장할 List
    private static List<Character> list = new ArrayList<>();
    // 문자열에 포함된 숫자의 합
    private static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 문자열을 하나씩 확인
        for(int i = 0; i < str.length(); i++) {
            // 문자인 경우
            if(Character.isLetter(str.charAt(i))) {
                list.add(str.charAt(i));
            }
            // 숫자인 경우
            else {
                sum += str.charAt(i) - '0';
            }
        }

        // 문자 리스트 오름차순 정렬
        Collections.sort(list);

        // 문자를 하나씩 출력
        list.forEach(System.out::print);

        // 숫자가 하나라도 존재하는 경우 맨 뒤에 출력
        if(sum > 0) System.out.print(sum);
        System.out.println();
    }

}
