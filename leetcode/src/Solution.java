import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node[] nodes = new Node[n+1];
        for (int i = 1; i < n; ++i) {
            int m = scan.nextInt();
            int q = scan.nextInt();
            if (nodes[m] == null) {
                nodes[m] = new Node(m,1,0);
            } else {
                nodes[m].num++;
            }
            nodes[q] = new Node(n,0,m);
        }
        int k = 0;
        boolean ok = false;
        while (!ok) {
            k++;
            for (int i = 1; i < nodes.length; ++i) {
                if (nodes[i].num == 0) {
                    if (!nodes[i].book) {
                        nodes[i].res = k;
                        nodes[i].book = true;
                        if (i == 1 && nodes[i].father == 0) {
                            ok = true;
                            break;
                        }
                        nodes[nodes[i].father].num--;

                    }
                }
            }
        }
        for (int i = 1; i < nodes.length; ++i) {
            System.out.print(nodes[i].res + " ");
        }
    }

}


class Node {
    int now;
    int num;
    int father;
    int res;
    boolean book;

    public Node(int now, int num, int father) {
        this.now = now;
        this.num = num;
        this.father = father;
    }
}
