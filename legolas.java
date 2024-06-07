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
  
   private static int tiketawaldankota(int n, int c, int[][] alliances) {
        Map<Integer, List<Integer>> aliansiKota = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (int aliansiIndex = 0; aliansiIndex < alliances.length; aliansiIndex++) {
            int[] alliance = alliances[aliansiIndex];
            for (int i = 0; i < alliance.length; i++) {
                int kota = alliance[i];
                aliansiKota.putIfAbsent(kota, new ArrayList<>());
                aliansiKota.get(kota).add(aliansiIndex);
            }
        }

    for (int aliansiIndex = 0; aliansiIndex < alliances.length; aliansiIndex++) {
            int[] alliance = alliances[aliansiIndex];
            for (int i = 0; i < alliance.length; i++) {
                for (int j = i + 1; j < alliance.length; j++) {
                    String key1 = alliance[i] + "-" + aliansiIndex;
                    String key2 = alliance[j] + "-" + aliansiIndex;
                    graph.putIfAbsent(key1, new ArrayList<>());
                    graph.putIfAbsent(key2, new ArrayList<>());
                    graph.get(key1).add(key2);
                    graph.get(key2).add(key1);
                }
            }
        }

        for (int kota = 0; kota < n; kota++) {
            List<Integer> aliansiSetiapkota = aliansiKota.getOrDefault(kota, new ArrayList<>());
            for (int i = 0; i < aliansiSetiapkota.size(); i++) {
                int alliance = aliansiSetiapkota.get(i);
                if (searching(kota, alliance, n, aliansiKota, graph)) {
                    return kota;
                }
            }
        }

        return -1;
    }

 private static boolean searching(int kotaAwal, int aliansiAwal, int n, Map<Integer, List<Integer>> aliansiKota, Map<String, List<String>> graph) {
        Queue<Node> queue = new LinkedList<>();
        int[] jalurAwal = new int[n];
        jalurAwal[0] = kotaAwal;
        queue.offer(
                new Node(kotaAwal, aliansiAwal, new HashSet<>(Collections.singleton(kotaAwal)), jalurAwal, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int kotaSekarang = node.kota;
            int aliansiSekarang = node.aliansi;
            Set<Integer> visited = node.visited;
            int[] path = node.jalur;
            int pathIndex = node.urutanJalur;

            if (visited.size() == n) {
                return true;
            }

            List<Integer> aliansiBerikutnya = aliansiKota.getOrDefault(kotaSekarang, new ArrayList<>());
            for (int i = 0; i < aliansiBerikutnya.size(); i++) {
                int nextAlliance = aliansiBerikutnya.get(i);
