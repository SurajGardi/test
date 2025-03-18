public class Missionaries_Cannibals 
{
    public static void main(String[] args) 
    {
        int LeftM = 3, LeftC = 3; 
        int RightM = 0, RightC = 0;
        boolean boatPositionLeft = true;

        System.out.println("Initial State:");
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 1: 2 Cannibals cross to the right
        LeftM = 3;
        LeftC = 1;
        RightM = 0;
        RightC = 2; 
        boatPositionLeft = false;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 2: 1 Cannibal returns to the left
        LeftM = 3;
        LeftC = 2;
        RightM = 0;
        RightC = 1;
        boatPositionLeft = true;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 3: 2 Cannibals cross to the right
        LeftM = 3;
        LeftC = 0;
        RightM = 0;
        RightC = 3;
        boatPositionLeft = false;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 4: 1 Cannibal returns to the left
        LeftM = 3;
        LeftC = 1;
        RightM = 0;
        RightC = 2; 
        boatPositionLeft = true;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 5: 2 Missionaries cross to the right
        LeftM = 1;
        LeftC = 1;
        RightM = 2; 
        RightC = 2;
        boatPositionLeft = false;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 6: 1 Missionary and 1 Cannibal return to the left
        LeftM = 2;
        LeftC = 2;
        RightM = 1; 
        RightC = 1;
        boatPositionLeft = true;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 7: 2 Missionaries cross to the right
        LeftM = 0;
        LeftC = 2;
        RightM = 3;
        RightC = 1; 
        boatPositionLeft = false;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft);

        // Step 8: 1 Cannibal returns to the left
        LeftM = 0;
        LeftC = 3;
        RightM = 3; 
        RightC = 0; 
        boatPositionLeft=true ;
        printState(LeftM, LeftC, RightM, RightC, boatPositionLeft); 
        
       // Step9:2 Cannibals cross to the right 
       LeftM=0 ; 
       LeftC=1 ;
       RightM=3 ; 
       RightC=2 ;
       boatPositionLeft=false ;
       printState(LeftM ,LeftC ,RightM ,RightC ,boatPositionLeft ); 

       // Step10:1 Cannibal returns to the left 
       LeftM=0 ; 
       LeftC=2 ;
       RightM=3 ; 
       RightC=1 ;
       boatPositionLeft=true ;
       printState(LeftM ,LeftC ,RightM ,RightC ,boatPositionLeft );

       // Step11:2 Cannibals cross to the right 
       LeftM=0 ;
       LeftC=0 ;
       RightM=3 ;
       RightC=3 ; 
       boatPositionLeft=false ;
       printState(LeftM ,LeftC ,RightM ,RightC ,boatPositionLeft ); 
       System.out.println("All missionaries and cannibals have crossed the river!");
    }

    private static void printState(int leftM,int leftC,int rightM,int rightC ,boolean boatPositionLeft ) 
    {
         System.out.println("----------------------------");
         System.out.println("Left Bank: M =" + leftM + ", C =" + leftC );
         System.out.println("Right Bank: M =" + rightM + ", C =" + rightC ); 
         System.out.println("Boat is on the " + (boatPositionLeft ? "left" : "right") + " bank.");
    }
}
