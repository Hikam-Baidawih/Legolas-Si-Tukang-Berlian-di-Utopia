import java.util.*;

public class legolas {
  
    static class Node {
        int kota;
        int aliansi;
        Set<Integer> visited;
        int[] jalur;
        int urutanJalur;
        
        Node(int k, int a, Set<Integer> v, int[] j, int uj) {
            kota = k;
            aliansi = a;
            visited = v;
            jalur = j;
            urutanJalur = uj;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] results = new int[100]; // Assume at most 100 results
        int resultIndex = 0;

        while (true) {
            int n = scanner.nextInt();
            int c = scanner.nextInt();

            if (n == 0 && c == 0) {
                break;
            } else if (n < 1 || n > 100) {
                break;
            } else if (c < 1 || c > 100) {
                break;
            }

            int[][] alliances = new int[c][];
            for (int i = 0; i < c; i++) {
                int k = scanner.nextInt();
                alliances[i] = new int[k];
                for (int j = 0; j < k; j++) {
                    alliances[i][j] = scanner.nextInt();
                }
            }

            int result = tiketawaldankota(n, c, alliances);
            results[resultIndex++] = result;
        }

        for (int i = 0; i < resultIndex; i++) {
            System.out.println(results[i]);
        }
        scanner.close();
    }
