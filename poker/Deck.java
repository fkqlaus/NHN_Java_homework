/*
카드 게임에 널리 쓰이는 카드로, 트럼프 카드라고도 불립니다. 이 카드는 다이아몬드(♦), 스페이드 (♠), 하트( ♥), 클럽(♣) 등 네 가지 문양과 각각의 무늬를 가지는 1~13을 의미하는 A, 2, ~ 10, J, Q, K의 숫자를 가진 카드로 구성됩니다. 각각의 숫자 카드는 각각의 무늬를 가지며, 총 52장의 카드로 게임을 진행합니다.

플레잉 카드의 숫자 순위는 높은 순에서 낮은 순으로 다음과 같습니다.

A → K → Q → J → 10 → 9 → 8 → 7 → 6 → 5 → 4 → 3 → 2

무늬 순위는 높은 순에서 낮은 순으로 다음과 같습니다.

스페이드(♠) → 다이아몬드(♦) → 하트(♥) → 클럽(♣)

가장 높은 카드는 스페이드 A(♠) 이며, 가장 낮은 카드는 2(♣) 가 됩니다.
 */


 /*
  * 
  0~12 클로버 0 = 2 , 1 = 3 , 2 = 4, 3 = 5 , 4 = 6 , 5 = 7 , 6 = 8, 7 = 9, 8 = 10, 9 = J, 10 = Q , 11 = K , 12 = A

  13~25 하트
  26~38 다이아몬드
  39~51 스페이드
  */


public class Deck {

    final static int card_num = 52;
    
    int[] card_list = new int[card_num];


    public Deck(){
        make_deck();
        suffle();
    }



    public void make_deck(){

        for(int i=0;i<card_num;i++){
            card_list[i] = i;
        }

    }

    public void suffle(){

        for(int i=0;i<card_num;i++){
            int j = (int)(Math.random()*card_num);
            int temp = card_list[0];
            card_list[0] = card_list[j];
            card_list[j] = temp;
        }
    }

}
