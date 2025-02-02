import java.util.ArrayList;
import java.util.Arrays;

public class nqueens {
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[n][n];
        boolean[][] visited= new boolean[n][n];
        sol(arr, 0, n - 1, 0, n - 1, 0, n, visited);

    }

    public static void sol(int[][] arr, int cr, int er, int cc, int ec, int pq, int tq, boolean[][] visited) {
        String res[]=new String[pq*4];
        String ans="";
        if (tq == pq){
        for(int i=0;i<pq;i++)
        {
            for (int j = 0; j < pq; j++) {
                ans=ans+String.valueOf(visited[i][j])+" ";
                res[i+j]=ans;
                ans="";
            }

        }
            System.out.println(Arrays.toString(res));
            return;
        }
        if (cc > ec) {
            sol(arr, cr + 1, er, 0, ec, pq, tq, visited);
            return;
        }
        if (cr > er) return;
        if (isItPossible(cr, cc, visited) == true) {
            visited[cr][cc] = true;
            sol(arr, cr + 1, er, 0, ec, pq + 1, tq, visited);
            visited[cr][cc] = false;
        }
        sol(arr, cr, er, cc + 1, ec, pq, tq, visited);


    }

    public static boolean isItPossible(int cr, int cc, boolean[][] visited) {

        for (int st = cr; st >= 0; st--) {
            if (visited[st][cc] == true)
                return false;
        }
        for (int sr = cr, sc = cc; sr >= 0 && sc >= 0; sr--, sc--) {
            if (visited[sr][sc]) {
                return false;
            }
        }
        for (int sr = cr, sc = cc; sr >= 0 && sc < visited.length; sr--, sc++) {
            if (visited[sr][sc]) {
                return false;
            }
        }
        return true;
    }
    public static void display(boolean [][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j< arr.length;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

}

