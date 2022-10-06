package 汉诺塔问题;

import java.util.Scanner;

public class Demo {
    static int a;
    public static void main(String[] args){
        int j;
        String str;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入盘子数量");
        j=sc.nextInt();
        solve(j,1,2,3);
    }
    public static void solve(int n,int p1,int p2,int p3){

        if(n==1){
            a++;
            System.out.println(p1+"->"+p3);
        }else{
            a++;
            solve(n-1,p1,p3,p2);
            System.out.println(p1+"->"+p3);
            solve(n-1,p2,p1,p3);
        }
        System.out.println(a);
    }
}
