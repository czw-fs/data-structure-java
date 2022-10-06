package 汉诺塔问题;

import java.util.Scanner;

public class Demo2 {
    static int times;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入盘子数量");
        int j=sc.nextInt();
        hanoi(j,'A','B','C');
    }
    public static void move(int disk,char p1,char p3){
        System.out.println("第"+(++Demo2.times)+"次将"+disk+"从"+p1+"移动到"+p3);
    }

    public static void hanoi(int n,char p1,char p2,char p3){
        if(n==1) {
            move(n,p1, p3);
        }else{
            hanoi(n-1,p1,p3,p2);
            move(n,p1,p3);
            hanoi(n-1,p2,p1,p3);
        }
    }
}
