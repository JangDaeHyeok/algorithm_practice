package test.implementation;

import java.util.*;

public class Test11 {

    // 보드의 크기(n), 사과의 개수(k), 방향 전환 횟수(l)
    private static int n, k, l;
    // 맵 정보
    private static int[][] arr;
    // 방향 전환 정보
    private static List<Test11Move> moveList = new ArrayList<>();

    // 처음에는 오른쪽을 보고 있으므로 동, 남, 서, 북
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        // 맵 크기 설정
        arr = new int[n + 1][n + 1];

        // 맵 정보(사과 있는 곳은 1로 표시)
        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        // 방향 정보 입력
        l = sc.nextInt();
        for(int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            moveList.add(new Test11Move(x, c));
        }

        // 결과 출력
        System.out.println(simulate());
    }

    /**
     * 뱀 게임 실행
     *
     * @return 실행 시간(초)
     */
    public static int simulate() {
        int x = 1, y = 1; // 처음 위치는 1, 1
        int direction = 0; // 처음 시작은 오른쪽을 보고 있음
        arr[x][y] = 2; // 뱀의 위치를 2로 표시
        int time = 0; // 총 소요 시간
        int moveIdx = 0; // 방향 전환 index

        // 뱀의 현재 위치 정보(꼬리가 앞)
        Queue<Test11Position> q = new LinkedList<>();
        q.offer(new Test11Position(x, y));

        while(true) {
            int nx = x + dx[direction]; // 뱀의 머리 x축 이동 위치
            int ny = y + dy[direction]; // 뱀의 머리 y축 이동 위치

            // 뱀이 이동하는 위치가 맵 안에 있고, 뱀의 몸통이 없는 위치인 경우
            if(1 <= nx && n >= nx && 1 <= ny && n >= ny) {
                // 뱀의 머리 이동
                arr[nx][ny] = 2;
                q.offer(new Test11Position(nx, ny));

                // 사과가 없는 경우 이동 후에 꼬리 제거
                if(arr[nx][ny] != 1) {
                    Test11Position pos = q.poll();
                    arr[pos.getX()][pos.getY()] = 0;
                }
            }
            // 벽이나 뱀의 몸에 닿은 경우
            else {
                time++;
                break;
            }

            // 뱀의 머리 현재 위치 최신화
            x = nx;
            y = ny;
            // 시간 증가
            time++;

            // 방향 전환이 필요한 경우 방향 전환
            if(moveIdx < l && time == moveList.get(moveIdx).getTime()) {
                // 방향 전환
                direction = turn(direction, moveList.get(moveIdx).getDirection());
                moveIdx++;
            }
        }

        return time;
    }

    /**
     * 현재 방향에서 회전
     *
     * @param direction 현재 방향
     * @param c 회천할 방향
     * @return 회전한 방향
     */
    public static int turn(int direction, char c) {
        // 왼쪽 회전인 경우
        if(c == 'L') return (direction == 0) ? 3 : direction - 1;
        // 오른쪽 회전인 경우
        else return (direction == 3) ? 0 : direction + 1;
    }

}

/**
 * Test11 방향 변환 정보용 class
 */
class Test11Move {

    private int time;
    private char direction;

    public Test11Move(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection() {
        return direction;
    }
}

/**
 * Test11 위치 정보용 class
 */
class Test11Position {

    private int x;
    private int y;

    public Test11Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}