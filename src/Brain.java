
import java.io.*;

class Brain {


    // Main method to read the integers, store counts for each in an
    // array, and to report how many of each number there was.
    static void InputManager (){

        DataInputStream inputIn = new DataInputStream(System.in);
        final int maxRange = 10; //Largest range (times 10)
        final int minRange = 1; //Smallest range
        final int intervalRange = 10; //10 values in each interval

        int[] list = new int[maxRange]; //Array has counters for each range

        //Initialize all locations in the array to zero
        for (int i=0; i<list.length; i++) {
            list[i] = 0;
        }

        //Prompt user to enter a list of integers
        System.out.println("Enter a list of integers between 1 and 100.");
        System.out.println("To stop, enter an integer not in this range");

        //Enter first integer value before loop
        System.out.println("Enter integer: ");

        int value = 0;
        try {
            value = Integer.parseInt(inputIn.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // As long as the integers entered are within the desired range,
        // keep entering integers and increasing the appropriate histogram
        // range index in the 'list' array.
        while ( value >= minRange && value <= (maxRange* intervalRange)) {

            // Divide by range to determine which range to increment
            list[(value-1)/intervalRange] = list[(value-1)/intervalRange] + 1;

            // Enter next integer value
            System.out.print ("Enter Integer: ");
            try {
                value = Integer.parseInt (inputIn.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Print the histogram
        System.out.println ("\nHere is your histogram:");
        for (int i=0; i<list.length; i++) {
            // Print histogram labels
            System.out.print ("   " + (i*maxRange+1) + " - " + (i+1)*maxRange + "\t| ");

            // Print as many asterisks as the value in list[i]
            for (int j=0 ; j<list[i] ; j++) {
                System.out.print ("*");
            }
            System.out.println ();   // starts new histogram line
        }
    }
}
