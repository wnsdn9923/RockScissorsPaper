package RPSGame;

import java.util.Scanner;

public class hjw_mid2 {
    public static void main(String[] args) {
        System.out.println("가위바위보 게임을 시작해요");
        System.out.println("승리 시 2점획득, 패배 시 1점차감");
        System.out.println("5점획득시 경품을 지급합니다");

        Scanner scanner = new Scanner(System.in);

        System.out.print("유저 이름을 입력하세요: ");
        String userName = scanner.nextLine();

        int score = 0; // 사용자의 점수 초기화
        while (score < 5) { // 점수가 5점 이상이 될 때까지 반복
            System.out.println("가위(1) 바위(2) 보(3) 중에 골라주세요.");
            int userChoice = scanner.nextInt();
            String userHand = null;

            int computerChoice = (int) ((Math.random() * 3) + 1);
            String computerHand = null;

            if (userChoice == 1) {
                userHand = "가위";
            } else if (userChoice == 2) {
                userHand = "바위";
            } else if (userChoice == 3) {
                userHand = "보";
            }

            if (computerChoice == 1) {
                computerHand = "가위";
            } else if (computerChoice == 2) {
                computerHand = "바위";
            } else if (computerChoice == 3) {
                computerHand = "보";
            }

            if (userHand.equals(computerHand)) {
                System.out.printf("%s님은 %s, 컴퓨터는 %s를 냈어요.\n무승부!\n", userName, userHand, computerHand);
                continue;
            } else if ((userChoice == 1 && computerChoice == 3) || (userChoice == 2 && computerChoice == 1) || (userChoice == 3 && computerChoice == 2)) {
                System.out.printf("%s님은 %s, 컴퓨터는 %s를 냈어요.\n승리!\n", userName, userHand, computerHand);
                score += 2; // 승리 시 2점 추가
            } else if ((userChoice == 1 && computerChoice == 2) || (userChoice == 2 && computerChoice == 3) || (userChoice == 3 && computerChoice == 1)) {
                System.out.printf("%s님은 %s, 컴퓨터는 %s를 냈어요.\n패배!\n", userName, userHand, computerHand);
                score -= 1; // 패배 시 1점 감소
                if (score < 0) {
                    score = 0; // 점수가 음수가 되지 않도록 처리
                }             
            } else {
                continue;
            }

            if (score >= 5) {
                System.out.println("축하합니다! 5점 달성 경품을 지급합니다");
                System.out.println("인생역전의 랜덤 로또번호 6자리를 알려드립니다! ");
                for (int i = 0; i < 6; i++) {
                    int lottoNumber = (int) ((Math.random() * 45) + 1);
                    System.out.print(lottoNumber + " ");
                }
                System.out.println();             
            } else {
                System.out.println("현재 점수: " + score);
                System.out.println("다음 라운드로 진행합니다.");
            }
        }

        scanner.close();
    }
}