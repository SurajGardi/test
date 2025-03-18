import java.util.Scanner;

// Class to simulate water jug problem with user interaction
public class WaterJugManual {
    // Instance variables to store jug capacities and current water amounts
    private int jug1Capacity;  // Maximum capacity of first jug
    private int jug2Capacity;  // Maximum capacity of second jug
    private int jug1Current;   // Current water in first jug
    private int jug2Current;   // Current water in second jug
    private int target;        // Target amount to measure

    // Constructor to initialize the problem with user-specified values
    public WaterJugManual(int capacity1, int capacity2, int target) {
        this.jug1Capacity = capacity1;  // Set first jug's capacity
        this.jug2Capacity = capacity2;  // Set second jug's capacity
        this.target = target;           // Set target amount to achieve
        this.jug1Current = 0;          // Initialize first jug as empty
        this.jug2Current = 0;          // Initialize second jug as empty
    }

    // Method to fill first jug to its capacity
    public void fillJug1() {
        jug1Current = jug1Capacity;    // Set current amount to maximum capacity
        printState();                  // Display current state of both jugs
    }

    // Method to fill second jug to its capacity
    public void fillJug2() {
        jug2Current = jug2Capacity;    // Set current amount to maximum capacity
        printState();                  // Display current state of both jugs
    }

    // Method to empty first jug completely
    public void emptyJug1() {
        jug1Current = 0;              // Set current amount to zero
        printState();                 // Display current state of both jugs
    }

    // Method to empty second jug completely
    public void emptyJug2() {
        jug2Current = 0;              // Set current amount to zero
        printState();                 // Display current state of both jugs
    }

    // Method to pour water from jug1 to jug2
    public void pourJug1toJug2() {
        int spaceInJug2 = jug2Capacity - jug2Current;  // Calculate available space in jug2
        int amountToPour = Math.min(jug1Current, spaceInJug2);  // Determine amount to pour (min of jug1's water and jug2's space)
        jug1Current -= amountToPour;    // Remove poured amount from jug1
        jug2Current += amountToPour;    // Add poured amount to jug2
        printState();                   // Display current state of both jugs
    }

    // Method to pour water from jug2 to jug1
    public void pourJug2toJug1() {
        int spaceInJug1 = jug1Capacity - jug1Current;  // Calculate available space in jug1
        int amountToPour = Math.min(jug2Current, spaceInJug1);  // Determine amount to pour (min of jug2's water and jug1's space)
        jug2Current -= amountToPour;    // Remove poured amount from jug2
        jug1Current += amountToPour;    // Add poured amount to jug1
        printState();                   // Display current state of both jugs
    }

    // Method to check if target amount is achieved
    public boolean isSolved() {
        return jug1Current == target || jug2Current == target;  // Return true if either jug has target amount
    }

    // Helper method to print current state of jugs
    private void printState() {
        System.out.println("Jug1: " + jug1Current + "/" + jug1Capacity + 
                          ", Jug2: " + jug2Current + "/" + jug2Capacity);  // Print current amounts and capacities
    }

    // Method to handle interactive gameplay
    public void play() {
        Scanner scanner = new Scanner(System.in);  // Create scanner for user input
        while (!isSolved()) {  // Continue until target is reached
            System.out.println("\nOptions:");  // Display menu
            System.out.println("1. Fill Jug1");
            System.out.println("2. Fill Jug2");
            System.out.println("3. Empty Jug1");
            System.out.println("4. Empty Jug2");
            System.out.println("5. Pour Jug1 to Jug2");
            System.out.println("6. Pour Jug2 to Jug1");
            System.out.println("7. Quit");
            System.out.print("Choose an action (1-7): ");
            
            int choice = scanner.nextInt();  // Get user's choice
            switch (choice) {  // Execute corresponding action
                case 1: fillJug1(); break;
                case 2: fillJug2(); break;
                case 3: emptyJug1(); break;
                case 4: emptyJug2(); break;
                case 5: pourJug1toJug2(); break;
                case 6: pourJug2toJug1(); break;
                case 7: System.out.println("Game ended"); return;  // Exit game
                default: System.out.println("Invalid choice!");  // Handle invalid input
            }
        }
        System.out.println("Target achieved!");  // Display success message
        scanner.close();
    }

    // Main method to start the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create scanner for initial inputs
        
        System.out.print("Enter capacity of Jug1: ");  // Prompt for jug1 capacity
        int cap1 = scanner.nextInt();                  // Read jug1 capacity
        System.out.print("Enter capacity of Jug2: ");  // Prompt for jug2 capacity
        int cap2 = scanner.nextInt();                  // Read jug2 capacity
        System.out.print("Enter target amount: ");     // Prompt for target
        int target = scanner.nextInt();                // Read target amount
        
        WaterJugManual problem = new WaterJugManual(cap1, cap2, target);  // Create game instance
        System.out.println("Initial state:");          // Print initial state label
        problem.printState();                          // Show starting state
        problem.play();                                // Start interactive gameplay
        scanner.close();
    }
}