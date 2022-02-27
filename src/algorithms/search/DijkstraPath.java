package algorithms.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * packageName            : algorithms.search
 * fileName              : DijkstraPath
 * author                : sunkyu
 * date                  : 2022/02/27
 * description           :
 * ===========================================================
 * DATE              AUTHOR              NOTE
 * -----------------------------------------------------------
 * 2022/02/27           sunkyu             최초 생성
 */
public class DijkstraPath {
    private static class Edge implements Comparable<Edge> {
        String vertex;
        Integer distance;

        public Edge(String vertex, Integer distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex='" + vertex + '\'' +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }
    }

    public HashMap<String, Integer> search(HashMap<String, ArrayList<Edge>> graph, String start) {
        HashMap<String, Integer> distances = new HashMap<>();
        Edge edgeNode;
        Integer currentDistance;
        String currentNode;
        ArrayList<Edge> nodeList;
        Edge adjacentNode;
        String adjacent;
        Integer weight;
        Integer distance;
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));

        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);

            for (Edge node : nodeList) {
                adjacent = node.vertex;
                weight = node.distance;
                distance = weight + currentDistance;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(adjacent, distance));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge("B", 8), new Edge("C", 1), new Edge("D", 2))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge("B", 5), new Edge("D", 2))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge("E", 3), new Edge("F", 5))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge("F", 1))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge("A", 5))));
        System.out.println(graph);
        DijkstraPath dijkstraPath = new DijkstraPath();
        System.out.println(dijkstraPath.search(graph, "A"));
    }

}
