package Demo;

/**
 * @author: fs
 * @date: 2022/4/10 20:25
 * @Description:
 */
import java.util.*;
public class dskjf {
    public static void func(String strExce,String strActual) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : strActual.toUpperCase().toCharArray()) {
            set.add(ch);
        }

        HashSet<Character> broken = new HashSet<>();

        for (char ch : strExce.toUpperCase().toCharArray()) {
            if(!set.contains(ch) && !broken.contains(ch)) {
                System.out.print(ch);
                broken.add(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            func(str1,str2);
        }
    }
}
