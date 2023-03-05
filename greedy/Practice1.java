package greedy;

/**
 * Greedy Practice 1
 * 거스름돈
 * 카운터에는 거스름돈으로 사양할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정한다.
 * 손님에게 거슬러 줘야 할 돈이 N원일 때 거슬러줘야 할 동전의 최소 개수를 구하라.
 * 단 거슬러 줘야 할 돈 N은 항상 10의 배수이다.
 */
public class Practice1 {

    private static final int[] COIN_TYPES = {500, 100, 50, 10};

    public static void main(String[] args) {
        int coinCount = solution(1260);
        System.out.println("동전의 개수 : " + coinCount);
    }

    private static int solution(int N) {
        int count = 0;

        for(int coin : COIN_TYPES) {
            System.out.println(coin + "원짜리 동전의 개수 : " + (N / coin));
            count += N / coin;

            N %= coin;
        }

        return count;
    }
}
