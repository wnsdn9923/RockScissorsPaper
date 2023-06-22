package RPSGame;

import java.util.Scanner;

public class hjw_mid1 {
    public static void main(String[] args) {
        System.out.println("가위바위보 게임을 시작해요");
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("유저 이름을 입력하세요: ");
        String userName = scanner.nextLine(); // 사용자로부터 이름을 입력받음

        while (true) { // 무한 루프 시작
            System.out.println("가위(1) 바위(2) 보(3) 중에 골라주세요.");
            int userChoice = scanner.nextInt(); // 사용자의 선택을 입력받음
            String userHand = null;

            int computerChoice = (int) ((Math.random() * 3) + 1); // 컴퓨터의 선택을 무작위로 생성
            String computerHand = null;

            if (userChoice == 1) { // 사용자의 선택에 따라 문자열로 변환
                userHand = "가위";
            } else if (userChoice == 2) {
                userHand = "바위";
            } else if (userChoice == 3) {
                userHand = "보";
            }

            if (computerChoice == 1) { // 컴퓨터의 선택에 따라 문자열로 변환
                computerHand = "가위";
            } else if (computerChoice == 2) {
                computerHand = "바위";
            } else if (computerChoice == 3) {
                computerHand = "보";
            }

            if (userHand.equals(computerHand)) { // 사용자와 컴퓨터의 선택이 같으면 무승부
            	System.out.printf("%s님은 %s, 컴퓨터는 %s를 냈어요.\n무승부!\n", userName, userHand, computerHand);
                continue;
            } else if ((userChoice == 1 && computerChoice == 3) || (userChoice == 2 && computerChoice == 1) || (userChoice == 3 && computerChoice == 2)) {
            	System.out.printf("%s님은 %s, 컴퓨터는 %s를 냈어요.\n승리!\n", userName, userHand, computerHand); // 사용자가 이기는 경우
                break; // 게임 종료
            } else if ((userChoice == 1 && computerChoice == 2) || (userChoice == 2 && computerChoice == 3) || (userChoice == 3 && computerChoice == 1)) {
            	System.out.printf("%s님은 %s, 컴퓨터는 %s를 냈어요.\n패배!\n", userName, userHand, computerHand); // 사용자가 지는 경우
                System.out.println("재도전 하시겠습니까? 1(Yes)/2(No)");
                int retry = scanner.nextInt(); // 재도전 선택 입력 받음
                if (retry == 1) {
                    continue; // 재도전 선택한 경우, 다음 루프로 이동하여 게임을 다시 진행
                } else {
                    break; // 재도전 선택하지 않은 경우, 게임 종료
                }
            } else {
                continue;
            }
        }

        scanner.close(); // 스캐너를 닫고 프로그램을 종료
    }
}