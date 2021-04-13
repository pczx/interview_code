package solution;

import java.util.*;

public class NC94 {
    private class LFU {
        int capactiy;
        HashMap<Integer, Node> cache;
        TreeMap<Integer, LinkedList<Node>> track;

        LFU(int capactiy) {
            this.capactiy = capactiy;
            this.cache = new HashMap<>();
            this.track = new TreeMap<>();
        }

        void set(int key, int value) {
            Node node = cache.get(key);
            if (node != null) {
                node.value = value;
            } else {
                node = new Node(key, value, 0);
            }
            cache.put(key, node);
            updateTrack(node);
            if (cache.size() > capactiy) {
                Integer firstKey = track.firstKey();
                track.computeIfPresent(firstKey, (integer, nodes) -> {
                    Node first = nodes.pollFirst();
                    if (first != null) {
                        cache.remove(first.key);
                    }
                    if (nodes.size() == 0) {
                        return null;
                    }
                    return nodes;
                });
            }
        }

        int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            updateTrack(node);
            return node.value;
        }

        void updateTrack(Node node) {
            track.computeIfPresent(node.freq, (integer, nodes) -> {
                nodes.remove(node);
                if (nodes.size() == 0) {
                    return null;
                }
                return nodes;
            });
            node.freq++;
            track.compute(node.freq, (integer, nodes) -> {
                if (nodes == null) {
                    nodes = new LinkedList<>();
                }
                nodes.add(node);
                return nodes;
            });
        }
    }

    private class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    public int[] LFU(int[][] operators, int k) {
        // write code here
        List<Integer> res = new ArrayList<>();
        LFU lfu = new LFU(k);
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                lfu.set(operators[i][1], operators[i][2]);
            } else if (operators[i][0] == 2) {
                res.add(lfu.get(operators[i][1]));
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
