import java.util.Scanner;

// Class to simulate missionaries and cannibals river crossing problem
public class MissionariesCannibalsManual {
    private int missionariesLeft;  // Number of missionaries on left bank
    private int cannibalsLeft;     // Number of cannibals on left bank
    private int missionariesRight; // Number of missionaries on right bank
    private int cannibalsRight;    // Number of cannibals on right bank
    private boolean boatLeft;      // Boat position: true for left, false for right

    // Constructor to initialize the problem with 3 missionaries and 3 cannibals
    public MissionariesCannibalsManual() {
        this.missionariesLeft = 3;   // Start with 3 missionaries on left
        this.cannibalsLeft = 3;      // Start with 3 cannibals on left
        this.missionariesRight = 0;  // Start with 0 missionaries on right
        this.cannibalsRight = 0;     // Start with 0 cannibals on right
        this.boatLeft = true;        // Boat starts on left bank
    }

    // Check if current state is valid (missionaries not outnumbered by cannibals)
    private boolean isValidState() {
        if (missionariesLeft < 0 || cannibalsLeft < 0 || missionariesRight < 0 || cannibalsRight < 0)
            return false;  // Negative counts are invalid
        if (missionariesLeft > 0 && missionariesLeft < cannibalsLeft) return false;  // Left bank invalid
        if (missionariesRight > 0 && missionariesRight < cannibalsRight) return false;  // Right bank invalid
        return true;  // State is valid if all conditions pass
    }

    // Move boat with specified number of missionaries and cannibals
    public void move(int m, int c) {
        if (boatLeft) {  // Boat moving from left to right
            missionariesLeft -= m;    // Remove missionaries from left
            cannibalsLeft -= c;       // Remove cannibals from left
            missionariesRight += m;   // Add missionaries to right
            cannibalsRight += c;      // Add cannibals to right
        } else {  // Boat moving from right to left
            missionariesRight -= m;   // Remove missionaries from right
            cannibalsRight -= c;      // Remove cannibals from right
            missionariesLeft += m;    // Add missionaries to left
            cannibalsLeft += c;       // Add cannibals to left
        }
        boatLeft = !boatLeft;  // Switch boat position
        if (isValidState()) {
            printState();  // Print state if valid
        } else {
            System.out.println("Invalid move!");  // Notify if move creates invalid state
        }
    }

    // Check if problem is solved (all on right bank)
    public boolean isSolved() {
        return missionariesLeft == 0 && cannibalsLeft == 0 && !boatLeft;  // All on right, boat on right
    }

    // Print current state
    private void printState() {
        System.out.println("Left: " + missionariesLeft + "M " + cannibalsLeft + "C | " +
                          "Right: " + missionariesRight + "M " + cannibalsRight + "C | " +
                          "Boat: " + (boatLeft ? "Left" : "Right"));  // Show counts and boat position
    }

    // Method to handle interactive gameplay
    public void play() {
        Scanner scanner = new Scanner(System.in);  // Create scanner for user input
        while (!isSolved()) {  // Continue until all are across
            System.out.println("\nEnter number of missionaries and cannibals to move (max 2 total):");
            System.out.print("Missionaries: ");  // Prompt for missionaries
            int m = scanner.nextInt();           // Read missionary count
            System.out.print("Cannibals: ");     // Prompt for cannibals
            int c = scanner.nextInt();           // Read cannibal count
            
            if (m + c > 2 || m < 0 || c < 0) {  // Validate input
                System.out.println("Invalid move! Maximum 2 can cross, no negative numbers.");
                continue;  // Ask again if invalid
            }
            move(m, c);  // Attempt the move
        }
        System.out.println("Problem solved! All crossed safely!");  // Success message
        scanner.close();
    }

    // Main method to start the program
    public static void main(String[] args) {
        MissionariesCannibalsManual game = new MissionariesCannibalsManual();  // Create new game
        System.out.println("Initial state:");  // Print initial state label
        game.printState();                     // Show starting state
        game.play();                           // Start interactive gameplay
    }
}