 Queue<Node> queue = new LinkedList<>();
        int[] jalurAwal = new int[n];
        jalurAwal[0] = kotaAwal;
        queue.offer(new Node(kotaAwal, aliansiAwal, new HashSet<>(Collections.singleton(kotaAwal)), jalurAwal, 1));

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