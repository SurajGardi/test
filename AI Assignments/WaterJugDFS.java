// WaterJugDFS.java
import java.util.*;  // Import necessary collections classes

public class WaterJugDFS {
    // Static nested class to represent a state in the search
    static class State {
        int jug1, jug2;              // Current water amounts in jugs
        List<String> path;           // List of steps to reach this state

        // Constructor for State
        State(int jug1, int jug2, List<String> path) {
            this.jug1 = jug1;        // Set jug1's current amount
            this.jug2 = jug2;        // Set jug2's current amount
            this.path = new ArrayList<>(path);  // Create new list from previous path
        }
    }

    // Instance variables for the problem
    private int jug1Capacity;    // Maximum capacity of first jug
    private int jug2Capacity;    // Maximum capacity of second jug
    private int target;          // Target amount to measure
    private Set<String> visited; // Set to track visited states

    // Constructor to initialize the problem
    public WaterJugDFS(int capacity1, int capacity2, int target) {
        this.jug1Capacity = capacity1;  // Set first jug's capacity
        this.jug2Capacity = capacity2;  // Set second jug's capacity
        this.target = target;           // Set target amount
        this.visited = new HashSet<>(); // Initialize visited set
    }

    // Method to solve the problem using DFS
    public List<String> solve() {
        Stack<State> stack = new Stack<>();      // Stack for DFS exploration
        stack.push(new State(0, 0, new ArrayList<>()));  // Start with empty jugs

        while (!stack.isEmpty()) {               // Continue until all states explored
            State current = stack.pop();         // Get next state to explore
            String stateKey = current.jug1 + "," + current.jug2;  // Create unique state identifier

            if (visited.contains(stateKey)) continue;  // Skip if state already visited
            visited.add(stateKey);                    // Mark state as visited

            if (current.jug1 == target || current.jug2 == target) {  // Check if solution found
                return current.path;                 // Return solution path if target reached
            }

            // Try all possible operations and add resulting states to stack
            // Fill jug1
            addState(stack, new State(jug1Capacity, current.jug2, current.path), "Fill Jug1");
            // Fill jug2
            addState(stack, new State(current.jug1, jug2Capacity, current.path), "Fill Jug2");
            // Empty jug1
            addState(stack, new State(0, current.jug2, current.path), "Empty Jug1");
            // Empty jug2
            addState(stack, new State(current.jug1, 0, current.path), "Empty Jug2");
            // Pour jug1 to jug2
            int pour1to2 = Math.min(current.jug1, jug2Capacity - current.jug2);  // Calculate pour amount
            addState(stack, new State(current.jug1 - pour1to2, current.jug2 + pour1to2, current.path), 
                    "Pour Jug1 to Jug2");
            // Pour jug2 to jug1
            int pour2to1 = Math.min(current.jug2, jug1Capacity - current.jug1);  // Calculate pour amount
            addState(stack, new State(current.jug1 + pour2to1, current.jug2 - pour2to1, current.path), 
                    "Pour Jug2 to Jug1");
        }
        return null;  // Return null if no solution found
    }

    // Helper method to add new state to stack with its action description
    private void addState(Stack<State> stack, State state, String action) {
        state.path.add(action + " -> (" + state.jug1 + "," + state.jug2 + ")");  // Add step to path
        stack.push(state);  // Add state to exploration stack
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        WaterJugDFS problem = new WaterJugDFS(4, 3, 2);  // Create instance with 4-gal, 3-gal jugs, target 2
        List<String> solution = problem.solve();         // Attempt to find solution
        
        if (solution != null) {                         // Check if solution exists
            System.out.println("Solution found:");      // Print success message
            for (String step : solution) {              // Iterate through solution steps
                System.out.println(step);               // Print each step
            }
        } else {
            System.out.println("No solution exists");   // Print failure message
        }
    }
}