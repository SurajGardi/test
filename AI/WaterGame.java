import java.util.*;

class A 
{
    int max = 5;
    int curr = 0;

    public void fill() 
    {
        curr = max;
        System.out.println("A is now full.");
    }

    public void empty() 
    {
        curr = 0;
        System.out.println("A is now empty.");
    }

    public int transferTo(B b) 
    {
        int transfer = Math.min(curr, b.max - b.curr);
        curr -= transfer;
        b.curr += transfer;
        return transfer;
    }

    public int getCurr()
    {
        return curr;
    }
}

class B 
{
    int max = 4;
    int curr = 0;

    public void fill() 
    {
        curr = max;
        System.out.println("B is now full.");
    }

    public void empty() 
    {
        curr = 0;
        System.out.println("B is now empty.");
    }

    public int transferTo(A a) 
    {
        int transfer = Math.min(curr, a.max - a.curr);
        curr -= transfer;
        a.curr += transfer;
        return transfer;
    }

    public int getCurr() 
    {
        return curr;
    }
}

class State 
{
    int aCurr, bCurr;
    String actions;

    State(int aCurr, int bCurr, String actions) 
    {
        this.aCurr = aCurr;
        this.bCurr = bCurr;
        this.actions = actions;
    }
}

public class WaterGame 
{
    static A a = new A();
    static B b = new B();

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Water Game!");
        printStatus();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Fill A");
            System.out.println("2. Fill B");
            System.out.println("3. Transfer from A to B");
            System.out.println("4. Transfer from B to A");
            System.out.println("5. Empty A");
            System.out.println("6. Empty B");
            System.out.println("7. Check Capacities");
            System.out.println("8. Solve with BFS");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1: a.fill(); break;
                case 2: b.fill(); break;
                case 3: System.out.println("Transferred " + a.transferTo(b) + " from A to B."); break;
                case 4: System.out.println("Transferred " + b.transferTo(a) + " from B to A."); break;
                case 5: a.empty(); break;
                case 6: b.empty(); break;
                case 7: printStatus(); break;
                case 8: solveUsingBFS(); break;
                case 9: System.out.println("Exiting..."); sc.close(); return;
                default: System.out.println("Invalid choice! Try again."); break;
            }

            if (a.getCurr() == 2) 
            {
                System.out.println("Congratulations! 2 units in A.");
                break;
            }
        }
    }

    private static void printStatus()
    {
        System.out.println("\nCurrent Status:");
        System.out.println("A: " + a.getCurr() + "/" + a.max);
        System.out.println("B: " + b.getCurr() + "/" + b.max);
    }

    private static void solveUsingBFS() 
    {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new State(0, 0, ""));
        visited.add("0,0");

        while (!queue.isEmpty()) 
        {
            State current = queue.poll();
            System.out.println("State: A=" + current.aCurr + ", B=" + current.bCurr);
            System.out.println("Actions: " + current.actions);

            if (current.aCurr == 2) 
            {
                System.out.println("Solution found: " + current.actions);
                printStatus();
                return;
            }

            List<State> nextStates = generateNextStates(current);
            for (State next : nextStates) 
            {
                String stateKey = next.aCurr + "," + next.bCurr;
                if (!visited.contains(stateKey))
                {
                    visited.add(stateKey);
                    queue.offer(next);
                }
            }
        }

        System.out.println("No solution found.");
    }

    private static List<State> generateNextStates(State currentState) 
    {
        List<State> nextStates = new ArrayList<>();

        // Fill A
        if (currentState.aCurr < a.max) {
            nextStates.add(new State(a.max, currentState.bCurr, currentState.actions + "Fill A "));
        }

        // Fill B
        if (currentState.bCurr < b.max) {
            nextStates.add(new State(currentState.aCurr, b.max, currentState.actions + "Fill B "));
        }

        // Empty A
        if (currentState.aCurr > 0) {
            nextStates.add(new State(0, currentState.bCurr, currentState.actions + "Empty A "));
        }

        // Empty B
        if (currentState.bCurr > 0) {
            nextStates.add(new State(currentState.aCurr, 0, currentState.actions + "Empty B "));
        }

        // Transfer from A to B
        if (currentState.aCurr > 0 && currentState.bCurr < b.max) {
            int transfer = Math.min(currentState.aCurr, b.max - currentState.bCurr);
            nextStates.add(new State(currentState.aCurr - transfer, currentState.bCurr + transfer, currentState.actions + "Transfer A to B "));
        }

        // Transfer from B to A
        if (currentState.bCurr > 0 && currentState.aCurr < a.max) {
            int transfer = Math.min(currentState.bCurr, a.max - currentState.aCurr);
            nextStates.add(new State(currentState.aCurr + transfer, currentState.bCurr - transfer, currentState.actions + "Transfer B to A "));
        }
        return nextStates;
    }
}
