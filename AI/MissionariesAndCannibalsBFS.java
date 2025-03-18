import java.util.*;

class State {
    int leftM, leftC, rightM, rightC, boatPos;
    List<String> path;

    public State(int leftM, int leftC, int rightM, int rightC, int boatPos, List<String> path) {
        this.leftM = leftM;
        this.leftC = leftC;
        this.rightM = rightM;
        this.rightC = rightC;
        this.boatPos = boatPos;
        this.path = new ArrayList<>(path); // Make a copy of the path
    }
}

public class MissionariesAndCannibalsBFS {

    public static void main(String[] args) {
        bfs();
    }

    public static void bfs() {
        int leftM = 3, leftC = 3, rightM = 0, rightC = 0, boatPos = 0; // Boat on the left
        State startState = new State(leftM, leftC, rightM, rightC, boatPos, new ArrayList<>());
        
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startState);
        visited.add(stateToString(startState));

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.leftM == 0 && curr.leftC == 0) {
                System.out.println("Solution found!");
                printSolution(curr);
                return;
            }

            List<State> nextStates = generateNextStates(curr);

            for (State next : nextStates) {
                String stateStr = stateToString(next);
                if (!visited.contains(stateStr)) {
                    visited.add(stateStr);
                    queue.add(next);
                }
            }
        }
        
        System.out.println("No solution found.");
    }

    public static List<State> generateNextStates(State curr) {
        List<State> nextStates = new ArrayList<>();
        int boatPos = curr.boatPos;
        
        if (boatPos == 0) {
            for (int m = 0; m <= 2; m++) {
                for (int c = 0; c <= 2; c++) {
                    if ((m + c) >= 1 && (m + c) <= 2 && m <= curr.leftM && c <= curr.leftC) {
                        int newLeftM = curr.leftM - m;
                        int newLeftC = curr.leftC - c;
                        int newRightM = curr.rightM + m;
                        int newRightC = curr.rightC + c;
                        
                        if ((newLeftM == 0 || newLeftM >= newLeftC) && (newRightM == 0 || newRightM >= newRightC)) {
                            List<String> newPath = new ArrayList<>(curr.path);
                            newPath.add("Move " + m + " missionaries and " + c + " cannibals from left to right");
                            nextStates.add(new State(newLeftM, newLeftC, newRightM, newRightC, 1, newPath));
                        }
                    }
                }
            }
        } else {
            for (int m = 0; m <= 2; m++) {
                for (int c = 0; c <= 2; c++) {
                    if ((m + c) >= 1 && (m + c) <= 2 && m <= curr.rightM && c <= curr.rightC) {
                        int newLeftM = curr.leftM + m;
                        int newLeftC = curr.leftC + c;
                        int newRightM = curr.rightM - m;
                        int newRightC = curr.rightC - c;
                        
                        if ((newLeftM == 0 || newLeftM >= newLeftC) && (newRightM == 0 || newRightM >= newRightC)) {
                            List<String> newPath = new ArrayList<>(curr.path);
                            newPath.add("Move " + m + " missionaries and " + c + " cannibals from right to left");
                            nextStates.add(new State(newLeftM, newLeftC, newRightM, newRightC, 0, newPath));
                        }
                    }
                }
            }
        }

        return nextStates;
    }

    public static String stateToString(State state) {
        return state.leftM + "," + state.leftC + "," + state.rightM + "," + state.rightC + "," + state.boatPos;
    }

    public static void printSolution(State solution) {
        for (String step : solution.path) {
            System.out.println(step);
        }
    }
}
