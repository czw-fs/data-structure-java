package 八皇后问题;

public class Demo {
    static int TRUE = 1, FALSE = 0, EIGHT = 8;
    static int[] queen = new int[EIGHT];
    static int number = 0;
    static int count=0;
    //构造函数
    public Demo() {
        number = 0;
    }

    //打印一维数组结果
    public static void print1(){
        count++;
        for(int i=0;i<EIGHT;i++){
            System.out.print(queen[i]+" ");
        }
        System.out.println();
    }
    //打印棋盘式结果
    public static void print2(){
        String[][] arr={{" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}};
        for(int i=0;i<EIGHT;i++){
            arr[i][queen[i]]="*";
        }
        for(int i=0;i<EIGHT;i++){
            for(int j=0;j<EIGHT;j++) {
                if(j<EIGHT-1) {
                    System.out.print(" " + arr[i][j] + " ");
                    System.out.print("|");
                }else{
                    System.out.print(" " + arr[i][j] + " ");
                }
            }
            System.out.println();

                if(i<EIGHT-1){
                    for (int k = 0; k < EIGHT; k++) {
                        if(k==7)
                        System.out.print("---");
                        else
                            System.out.print("---|");
                    }
                }
            System.out.println();
        }
    }
    //判断在（row，col）上的皇后是否遭受攻击
    public static boolean attack(int row) {
        for(int i=0;i<row;i++){
            if(queen[i]==queen[row]||Math.abs(i-row)==Math.abs(queen[i]-queen[row])){
                return false;
            }
        }
        return true;
    }
    //确定皇后放的位置
    public static void thePlace(int row){
        if(row==EIGHT){
            print1();
            print2();
            return;
        }
        for(int i=0;i<EIGHT;i++){
            queen[row]=i;
            if(attack(row))
                thePlace(row+1);
        }
    }
    public static void main(String[] args){
        thePlace(0);
        System.out.println(count);
    }


}
