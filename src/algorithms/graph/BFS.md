# [알고리즘] 8. BFS : 너비우선탐색 (Java)

> 그래프 혹은 트리를 너비 우선으로 탐색하는 알고리즘이다.
> 쉽게 말해 가로로 탐색한다고 생각

![BFS](https://upload.wikimedia.org/wikipedia/commons/4/46/Animated_BFS.gif)

## 생각한 로직

1. 해쉬맵으로 그래프를 만든다
2. 방문할 예정인 리스트를 만든다.
3. 방문했던 노드들의 리스트를 만든다.
4. 시작 노드의 값을 방문할 예정 리스트에 저장
5. 방문했던 노드 리스트에 현재 노드값이 존재하는지를 확인한다.
6. 시작 노드의 인접 노드들을 방문할 예정 리스트에 저장한다.
7. 시작 노드를 방문할 예정 리스트에서 제거하고 방문헀던 노드 리스트에 저장한다.
8. 방문할 예정 리스트의 크기가 0이 될 때까지 반복한다.

## 코드 구현 (Java)

```java
package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {
    public ArrayList<String> search(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisited = new ArrayList<>();

        needVisited.add(startNode);

        while (needVisited.size() > 0) {
            String node = needVisited.remove(0);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisited.addAll(graph.get(node));
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

        BFS bfs = new BFS();
        System.out.println(bfs.search(graph, "A"));
    }
}

```

## 고민한 부분

- 큐를 사용해야 한다는 것을 떠올리기가 생각보다 힘들었다.
- 직접 그림을 그려보면서 코드를 작성하면 생각보다 용이하다.
- 작년 초에 그래프 부분에서 학습을 종료했는데 다시보니까 생각보다 할 만 했다는 점