# [알고리즘] 9. DFS : 깊이우선탐색 (Java)

> 그래프 혹은 트리를 깊이 우선으로 탐색하는 알고리즘이다.
> 쉽게 말해 세로로 탐색한다고 생각.

![DFS](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Depth-First-Search.gif/220px-Depth-First-Search.gif)

## 생각한 로직

1. 해쉬맵으로 그래프를 만든다.
2. 방문할 예정인 리스트를 만든다.
3. 방문했던 노드들의 리스트를 만든다.
4. 시작 노드의 값을 방문할 예정 노드에 저장한다.
5. 방문했던 노드 리스트에 현재 노드값이 존재하는지를 확인한다.
6. 시작 노드의 인접 노드들을 방문할 예정 리스트에 저장한다.
7. 시작 노드를 방문할 예정 리스트에서 제거하고 방문했던 노드 리스트에 저장한다.
8. 방문할 예정 리스트의 크기가 0이 될 떄까지 반복한다.

## 코드 구현 (Java)

```java
package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
    public ArrayList<String> search(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1);

            if (!visited.contains(node)) {
                needVisit.addAll(graph.get(node));
                visited.add(node);
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        DFS dfs = new DFS();
        System.out.println(dfs.search(graph, "A"));

    }
}

```

## 고민한 부분

- BFS와 다르게 방문할 예정 리스트에서 큐 대신 스택을 사용하면 마법같이 변한다.
- 직접 그림을 그리면서 코드를 작성하면 매우 쉽게 이해된다.