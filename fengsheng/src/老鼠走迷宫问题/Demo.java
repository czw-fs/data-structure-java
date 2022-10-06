package 老鼠走迷宫问题;

public class Demo {
   public  static int exitx=8;
    public static int exity=10;
public static int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
               {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
               {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1},
               {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
               {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
               {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
               {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
               {1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1},
               {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
               {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };


    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        NodeList L = new NodeList();
        System.out.println("老鼠走前");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        while (x <=exitx&&y<=exity){
            arr[x][y]=2;
            if(arr[x-1][y]==0){
                x--;
                L.push(x,y);
            }else if(arr[x+1][y]==0){
                x++;
                L.push(x,y);
            }else if(arr[x][y-1]==0){
                y--;
                L.push(x,y);
            }else if(arr[x][y+1]==0){
                y++;
                L.push(x,y);
            }else{
                if(chkExit(x,y,exitx,exity)){
                    break;
                }
                else{
                    arr[x][y]=2;
                    L.pop();
                    x=L.last.x;
                    y=L.last.y;
                }
            }
        }
        System.out.println("老鼠走后");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
   public static boolean chkExit(int x,int y,int exitx,int exity) {
       if (x == exitx && y == exity) {
           if(arr[x-1][y]==1||arr[x+1][y]==1||arr[x][y-1]==1||arr[x][y+1]==2){
               return true;
           }else if(arr[x-1][y]==1||arr[x+1][y]==1||arr[x][y-1]==2||arr[x][y+1]==1){
               return true;
           }else if(arr[x-1][y]==1||arr[x+1][y]==2||arr[x][y-1]==1||arr[x][y+1]==1){
               return true;
           }else if(arr[x-1][y]==2||arr[x+1][y]==1||arr[x][y-1]==1||arr[x][y+1]==1)
               return true;
           else
               return false;
       }else{
           return false;
       }
   }
}
