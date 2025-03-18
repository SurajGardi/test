// MissionariesCannibalsDFS.java
import java.util.*;

public class MissionariesCannibalsDFS {
    // State class to track game state and path
    static class State {
        int mLeft, cLeft, mRight, cRight;  // Numbers of missionaries and cannibals on each side
        boolean boatLeft;                   // Boat position
        List<String> path;                  // Path to reach this state

        State(int mLeft, int cLeft, int mRight, int cRight, boolean boatLeft, List<String> path) {
            this.mLeft = mLeft;          // Set missionaries on left
            this.cLeft = cLeft;          // Set cannibals on left
            this.mRight = mRight;        // Set missionaries on right
            this.cRight = cRight;        // Set cannibals on right
            this.boatLeft = boatLeft;    // Set boat position
            this.path = new ArrayList<>(path);  // Copy path
        }
    }

    private Set<String> visited;  // Track visited states

    // Constructor
    public MissionariesCannibalsDFS() {
        this.visited = new HashSet<>();  // Initialize visited set
    }

    // Check if state is valid
    private boolean isValid(int mLeft, int cLeft, int mRight, int cRight) {
        if (mLeft < 0 || cLeft < 0 || mRight < 0 || cRight < 0) return false;  // Negative counts invalid
        if (mLeft > 0 && mLeft < cLeft) return false;  // Left bank invalid
        if (mRight > 0 && mRight < cRight) return false;  // Right bank invalid
        return true;  // State is valid
    }

    // Solve using DFS
    public List<String> solve() {
        Stack<State> stack = new Stack<>();  // Stack for DFS
        stack.push(new State(3, 3, 0, 0, true, new ArrayList<>()));  // Initial state

        while (!stack.isEmpty()) {  // Explore until solution found or all states checked
            State current = stack.pop();  // Get next state
            String key = current.mLeft + "," + current.cLeft + "," + current.boatLeft;  // Unique state key

            if (visited.contains(key)) continue;  // Skip if visited
            visited.add(key);  // Mark as visited

            if (current.mLeft == 0 && current.cLeft == 0 && !current.boatLeft) {  // Solution check
                return current.path;  // Return path if solved
            }

            // Try all possible moves (1 or 2 people, max 2 in boat)
            int[][] moves = {{2,0}, {1,0}, {1,1}, {0,1}, {0,2}};  // Possible combinations
            for (int[] move : moves) {
                int m = move[0], c = move[1];  // Missionaries and cannibals to move
                State next;
                if (current.boatLeft) {  // Left to right
                    next = new State(current.mLeft - m, current.cLeft - c,
                                   current.mRight + m, current.cRight + c,
                                   false, current.path);
                } else {  // Right to left
                    next = new State(current.mLeft + m, current.cLeft + c,
                                   current.mRight - m, current.cRight - c,
                                   true, current.path);
                }
                if (isValid(next.mLeft, next.cLeft, next.mRight, next.cRight)) {  // Check validity
                    next.path.add("Move " + m + "M " + c + "C to " + (next.boatLeft ? "left" : "right"));
                    stack.push(next);  // Add valid state to explore
                }
            }
        }
        return null;  // No solution found
    }

    // Main method to run DFS solution
    public static void main(String[] args) {
        MissionariesCannibalsDFS game = new MissionariesCannibalsDFS();  // Create game
        List<String> solution = game.solve();  // Find solution
        if (solution != null) {  // Check if solution exists
            for (String step : solution) {  // Print each step
                System.out.println(step);
            }
        } else {
            System.out.println("No solution");
        }
    }
}