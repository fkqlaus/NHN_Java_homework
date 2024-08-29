import java.util.Arrays;
import java.util.Scanner;

public class Player {

  static String[] names = {
    "Oliver", "Emma", "Liam", "Ava", "Noah", "Sophia", "James", "Isabella", "Benjamin", "Mia",
    "Lucas", "Charlotte", "Henry", "Amelia", "Alexander", "Harper", "William", "Evelyn", "Elijah", "Abigail",
    "Mason", "Ella", "Logan", "Aria", "Michael", "Scarlett", "Ethan", "Grace", "Daniel", "Chloe",
    "Matthew", "Lily", "Sebastian", "Victoria", "Jackson", "Hannah", "Jack", "Zoey", "Aiden", "Riley",
    "Samuel", "Nora", "David", "Luna", "Joseph", "Layla", "Carter", "Zoe", "Owen", "Mila"
  };
  static Scanner sr = new Scanner(System.in);
  static int playerNum;
  static String playerName;

  static int[][] player;
  static String[] name;

  //생성자
  public Player(){
    setPlayer();
    Deck d = new Deck();
    for(int i=0;i<playerNum;i++){
      for(int j=0;j<5;j++){

          player[i][j] = d.card_list[j+i*5];
      }
    }
    sort_player();

    for(int i=0;i<playerNum;i++){
      System.out.print(name[i]+": ");
      for(int j=0;j<5;j++){

          System.out.print(player[i][j]+" ");
      }
      System.out.println();
    }
  }

  


  public static void setPlayer(){
    System.out.println("플레이 할 인원을 입력하세요");
    playerNum = sr.nextInt();
    sr.nextLine();
    System.out.println("사용자의 이름을 입력해주세요");
    playerName = sr.nextLine();
    System.out.println("총 인원은 " + playerNum + " 이고, 사용자 이름은 " + playerName + " 입니다");
    name = new String[playerNum];
    player = new int[playerNum][5];

    int ran = (int)(Math.random()*playerNum-1);

    name[0] = playerName;
    for(int i=1;i<playerNum;i++){
        name[i]=names[ran+i];
    } 
  }
  public static void sort_player(){
    for(int i=0;i<playerNum;i++)
      Arrays.sort(player[i]);
  }
}
