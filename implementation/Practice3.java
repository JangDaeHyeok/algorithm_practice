package implementation;

import java.util.Scanner;

/**
 * Implementation Practice 3 (실전)
 * 왕실의 나이트
 */
public class Practice3 {

    private static final int[] D_X = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] D_Y = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("나이트의 위치 : ");
        String nLoc = sc.nextLine();

        int x = nLoc.charAt(0) - 'a' + 1;
        int y = nLoc.charAt(1) - '0';

        int result = 0;
        for(int i = 0; i < 8; i++) {
            int nextX = x + D_X[i];
            int nextY = y + D_Y[i];

            if(nextX > 0 && nextX <= 8 && nextY > 0 && nextY <= 8)
                result++;
        }

        System.out.println("이동 가능 개수 : " + result);
    }

}
