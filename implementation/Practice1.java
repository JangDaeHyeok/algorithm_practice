package implementation;

import java.util.Scanner;

/**
 * Implementation Practice 1 (이론)
 * 상하좌우
 * 여행자 A는 N x N 크기의 정사각형 공간 위에 서 있다. 이 공간은 1 x 1 크기의 정사각형으로 나누어져 있다. 가장 왼쪽 위 좌표는 (1, 1)이며,
 * 가장 오른쪽 아래 좌표는 (N, N)에 해당한다. 여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1, 1)이다.
 * 우리 앞에는 여행가 A가 이동할 계획이 적힌 계획서가 놓여 있다.
 * 계획서에는 하나의 줄에 띄어쓰기를 기준으로 하여 L, R, U, D 중 하나의 문자가 반복적으로 적혀있다.
 * 여행가 A가 정사각형 공간을 벗어나는 우밎ㄱ임은 무시된다.
 * 계획서가 주어졌을 때 여행가 A가 최종적으로 도착할 지점의 좌표를 출력하는 프로그램을 작성하시요.
 * 1 <= N <= 100
 * 1 <= 이동횟수 <= 100
 */
public class Practice1 {

    private static final int[] D_X = {0, 0, -1, 1};
    private static final int[] D_Y = {-1, 1, 0, 0};
    private static final char[] MOVE_TYPES = {'L', 'R', 'U', 'D'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("공간의 크기 : ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.print("계획서 내용 : ");
        String[] plans = sc.nextLine().split(" ");

        int x = 1, y = 1;
        for(String plan : plans) {
            char planChar = plan.charAt(0);

            for(int i = 0; i < 4; i ++) {
                if(MOVE_TYPES[i] == planChar) {
                    int nx = x + D_X[i];
                    int ny = y + D_Y[i];

                    if(nx > n || nx < 1)
                        continue;
                    if(ny > n || ny < 1)
                        continue;

                    x = nx;
                    y = ny;
                }
            }
        }

        System.out.println("좌표 x : " + x + ", y : " + y);
    }

}
