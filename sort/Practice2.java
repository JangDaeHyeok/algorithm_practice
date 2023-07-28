package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Practice2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n 입력받기
        int n = sc.nextInt();

        // n명의 학생 정보를 입력받아 배열에 저장
        List<Student> studentList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            studentList.add(new Student(name, score));
        }

        // 점수 오름차순 정렬
        Collections.sort(studentList);

        // 학생 이름 출력
        studentList.forEach(s -> System.out.println(s.getName()));
    }

}

class Student implements Comparable<Student> {cd

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }


    @Override
    public int compareTo(Student o) {
        return this.score < o.score ? -1 : 1;
    }

}
