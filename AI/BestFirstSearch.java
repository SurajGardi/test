import java.util.*;

class Node {
    String state;
    int h;
    Node parent;

    public Node(String state, int h, Node parent) {
        this.state = state;
        this.h = h;
        this.parent = parent;
    }
}

public class BestFirstSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter start state:");
        String startState = sc.nextLine();

        System.out.println("Enter goal state:");
        String goalState = sc.nextLine();

        System.out.println("Enter heuristic for each state:");

        Map<String, Integer> heuristics = new HashMap<>();
        System.out.println("Enter heuristic values (state followed by heuristic value, type 'done' to finish):");

        while (true) {
            System.out.print("State: ");
            String state = sc.nextLine();
            if (state.equalsIgnoreCase("done")) break;

            System.out.print("Heuristic: ");
            try {
                int hValue = Integer.parseInt(sc.nextLine());
                heuristics.put(state, hValue);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numeric value for the heuristic.");
            }
        }

        search(startState, goalState, heuristics);
    }

    public static void search(String startState, String goalState, Map<String, Integer> heuristics) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.h));
        Set<String> visited = new HashSet<>();

        Node start = new Node(startState, heuristics.getOrDefault(startState, Integer.MAX_VALUE), null);
        pq.add(start);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.state.equals(goalState)) {
                printPath(curr);
                return;
            }

            visited.add(curr.state);

            List<Node> neighbors = getNeighbors(curr, heuristics);
            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor.state)) {
                    pq.add(neighbor);
                }
            }
        }

        System.out.println("No solution found.");
    }

    public static List<Node> getNeighbors(Node curr, Map<String, Integer> heuristics) {
        List<Node> neighbors = new ArrayList<>();

        if (curr.state.equals("A")) {
            neighbors.add(new Node("B", heuristics.getOrDefault("B", Integer.MAX_VALUE), curr));
            neighbors.add(new Node("C", heuristics.getOrDefault("C", Integer.MAX_VALUE), curr));
        } else if (curr.state.equals("B")) {
            neighbors.add(new Node("G", heuristics.getOrDefault("G", Integer.MAX_VALUE), curr));
        } else if (curr.state.equals("C")) {
            neighbors.add(new Node("G", heuristics.getOrDefault("G", Integer.MAX_VALUE), curr));
        }

        return neighbors;
    }

    public static void printPath(Node goal) {
        List<String> path = new ArrayList<>();
        Node curr = goal;
        while (curr != null) {
            path.add(curr.state);
            curr = curr.parent;
        }
        Collections.reverse(path);
        System.out.println("Path: " + String.join(" -> ", path));
    }
}
