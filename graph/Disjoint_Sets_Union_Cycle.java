package graph;

import java.util.Scanner;

public class Disjoint_Sets_Union_Cycle {

    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    // 노드의 개수는 최대 10,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[10000]; // 부모 테이블 초기화하기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        boolean cycle = false; // 사이클 발생 여부

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 사이클이 발생한 경우 종료
            if (findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }
            // 사이클이 발생하지 않았다면 합집합(Union) 연산 수행
            else {
                unionParent(a, b);
            }
        }

        if (cycle) {
            System.out.println("사이클이 발생했습니다.");
        }
        else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }
    }

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x) {
        if(parent[x] == x)
            return x;

        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

}
