public class Card{

  static final String[] num = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
  static final String[] rank = {"클로버", "하트", "다이아몬드", "스페이드"};


  public Card(){


  }

  void check_hand(int[] hand){
    int[] num = new int[13];
    int[] rank = new int[4];

    for(int h: hand){

      num[h % 13]++;
      rank[h / 13]++;
    }


  }



}