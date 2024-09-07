import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);

        Calurator cal = new Calurator<>();
        String str = sr.nextLine();

        cal.add(str);
        
      
        cal.postOrder(cal.getRootNode());
        System.out.println(cal.size);
    }
}
