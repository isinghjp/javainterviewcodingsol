package com.codesmentors.interview;
import java.util.*;

public class TaskScheduler {

    public static List<String> getTopologicalOrder(List<Map<String, Object>> tasks) throws Exception {
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        
        // 1. Build the graph and in-degree map
        for (Map<String, Object> task : tasks) {
            String id = (String) task.get("id");
            List<String> deps = (List<String>) task.get("deps");
            
            inDegree.putIfAbsent(id, 0);
            for (String dep : deps) {
                adjList.computeIfAbsent(dep, k -> new ArrayList<>()).add(id);
                inDegree.put(id, inDegree.getOrDefault(id, 0) + 1);
            }
        }

        // 2. Initialize Queue with tasks having 0 dependencies
        Queue<String> queue = new LinkedList<>();
        for (String task : inDegree.keySet()) {
            if (inDegree.get(task) == 0) {
                queue.add(task);
            }
        }

        List<String> result = new ArrayList<>();
        // 3. Process the queue
        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);

            if (adjList.containsKey(current)) {
                for (String neighbor : adjList.get(current)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // 4. Cycle detection
        if (result.size() != inDegree.size()) {
            throw new Exception("LOOP DETECTED");
        }

        return result;
    }

    public static void main(String[] args) {
        // Example of a test case with a loop
        List<Map<String, Object>> tasksWithLoop = List.of(
            Map.of("id", "A", "deps", List.of("B")),
            Map.of("id", "B", "deps", List.of("A"))
        );

        try {
            System.out.println("Result: " + getTopologicalOrder(tasksWithLoop));
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Outputs: LOOP DETECTED
        }
    }
}
