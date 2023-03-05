package greedy;

/**
 * Greedy Practice 3
 * 숫자 카드 게임
 * 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
 * 숫자가 쓰인 카드들이 N x M 형태로 놓여 있다.
 * 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
 * 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
 * 그 다음 선택된 행에 포함된 카드들 중에서 숫자가 가장 낮은 카드를 뽑아야 한다.
 * 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를
 * 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.
 */
public class Practice3 {

    private static final int[] ARRAY_X = {7, 3, 1, 8};
    private static final int[] ARRAY_Y = {3, 3, 3, 4};

    public static void main(String[] args) {
        int result = solution(2, 4, ARRAY_X, ARRAY_Y);
        System.out.println("가장 큰 수 : " + result);
    }

    /**
     * @param N 행 length (1 <= N <= 100)
     * @param M 열 length (1 <= N <= 100)
     * @param arrs arrays (1 <= data <= 10000)
     * @return 가장 높은 수
     */
    private static int solution(int N, int M, int[]... arrs) {
        int result = 0;

        for(int[] arr : arrs) {
            int minValue = 10001;

            for(int value : arr) {
                minValue = Math.min(minValue, value);
            }

            result = Math.max(result, minValue);
        }

        return result;
    }
}
