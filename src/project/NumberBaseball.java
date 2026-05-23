package project;

import java.util.Scanner;
import java.util.Random;

public class NumberBaseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] answer = new int[3];
        int[] user = new int[3];

        // 1. 중복되지 않는 3자리 난수 생성 (1~9)
        for (int i = 0; i < 3; i++) {
            answer[i] = random.nextInt(9) + 1;

            // 중복 검사 로직
            for (int j = 0; j < i; j++) {
                if (answer[i] == answer[j]) {
                    i--;
                    break;
                }
            }
        }

        // 게임 시작 안내
        System.out.println("숫자 야구 게임을 시작합니다!");
        System.out.println("1부터 9까지의 중복되지 않는 숫자 3개를 맞춰보세요.");
        System.out.println("총 9번의 기회가 주어집니다.\n");

        int maxAttempts = 9;
        boolean isWin = false;

        // 2. 게임 루프 시작
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("[" + attempt + "번째 시도] 숫자 3개를 띄어쓰기로 구분하여 입력하세요. : ");

            for (int i = 0; i < 3; i++) {
                user[i] = scanner.nextInt();
            }

            int strike = 0;
            int ball = 0;

            // 3. 스트라이크와 볼 판정 로직
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (answer[i] == user[j]) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            // 4. 결과 출력
            if (strike == 3) {
                System.out.println("3 Strike! 축하합니다, 정답을 맞히셨습니다!");
                isWin = true;
                break;
            } else if (strike == 0 && ball == 0) {
                System.out.println("아웃 (Out)!");
            } else {
                System.out.println(strike + " Strike, " + ball + " Ball");
            }
            System.out.println();
        }

        // 5. 게임 종료 후 처리
        if (!isWin) {
            System.out.println("9번의 기회를 모두 소진했습니다. 게임 오버!");
            System.out.print("정답은 [ ");
            for (int i = 0; i < 3; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println("] 였습니다.");
        }

        scanner.close();
    }
}
