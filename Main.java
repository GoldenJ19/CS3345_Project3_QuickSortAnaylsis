/** TO DO: "Almost-sorted" arrays thing */

/*
 * Justin Hardy
 * JEH180008
 */

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Random;
import java.io.PrintWriter;
import java.io.IOException;
import static java.lang.System.*;
import java.time.Duration;

public class Main
{
    /**
     * Command Line Arguments:
     * 1. Array Size
     * 2. Output File Name (Report)
     * 3. Output File Name (Unsorted Array Storage)
     * 4. Output File Name (Sorted Array Storage)
     */
    public static void main( String[] args ) throws IOException {
        // Print argument instructions if incorrect arguments are passed in
        if( args.length < 4 ) {
            out.println("Four arguments are required:");
            out.println("1. Array Size");
            out.println("2. Output File Name (Report)");
            out.println("3. Output File Name (Unsorted Array Storage)");
            out.println("4. Output File Name (Sorted Array Storage)");
            exit(1); // Exit code 1 due to incorrect # of arguments being used
        }

        // Convert size argument to integer
        int size = Integer.parseInt(args[0]);
        // Create Printwriters using files
        PrintWriter writer_Report = new PrintWriter(args[1]);
        PrintWriter writer_Unsorted = new PrintWriter(args[2]);
        PrintWriter writer_Sorted = new PrintWriter(args[3]);

        // Created lists
        ArrayList<Integer> unsortedList = QuickSorter.generateRandomList(size);
        ///Collections.sort(unsortedList);
        ///swapTenPercent(unsortedList);
        ArrayList<Integer> sortedList = new ArrayList<Integer>(unsortedList);

        // Create duration variables
        Duration duration_FE, duration_RE, duration_MTRE, duration_MTE;

        // Sort the sortedList using FIRST_ELEMENT, and save Duration
        duration_FE = QuickSorter.timedQuickSort(sortedList, QuickSorter.PivotStrategy.FIRST_ELEMENT);
        // Reset the sortedList to sort again with different strategy
        sortedList = new ArrayList<Integer>(unsortedList);

        // Sort the sortedList using RANDOM_ELEMENT, and save Duration
        duration_RE = QuickSorter.timedQuickSort(sortedList, QuickSorter.PivotStrategy.RANDOM_ELEMENT);
        // Reset the sortedList to sort again with different strategy
        sortedList = new ArrayList<Integer>(unsortedList);

        // Sort the sortedList using MEDIAN_OF_THREE_RANDOM_ELEMENTS, and save Duration
        duration_MTRE = QuickSorter.timedQuickSort(sortedList, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS);
        // Reset the sortedList to sort again with different strategy
        sortedList = new ArrayList<Integer>(unsortedList);

        // Sort the sortedList using MEDIAN_OF_THREE_ELEMENTS, and save Duration
        duration_MTE = QuickSorter.timedQuickSort(sortedList, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS);
        // Don't reset this time since we want to output the sorted list.

        // Output to report file & close
        writer_Report.printf("FIRST_ELEMENT : %s\n", duration_FE);
        writer_Report.printf("RANDOM_ELEMENT : %s\n", duration_RE);
        writer_Report.printf("MEDIAN_OF_THREE_RANDOM_ELEMENTS : %s\n", duration_MTRE);
        writer_Report.printf("MEDIAN_OF_THREE_ELEMENTS : %s\n", duration_MTE);
        writer_Report.close();

        // Output to unsorted array file & close
        for( int i : unsortedList ) {
            writer_Unsorted.println(i);
        }
        writer_Unsorted.close();

        // output to sorted array file & close
        for( int i : sortedList ) {
            writer_Sorted.println(i);
        }
        writer_Sorted.close();
    }
    
    /**
     * Randomly swaps 10% of the passed-in list's elements.
     * Used to generate an almost-sorted list, as specified by the Project 3 instructions, for the README file.
     */
    private static <E extends Comparable<E>> void swapTenPercent( ArrayList<E> list ) {
        Random random = new Random();
        for( int i = 0; i < list.size()/10; i++ ) {
            // Randomly swap 10% of the array's elements
            int pos1 = random.nextInt(list.size()), pos2 = random.nextInt(list.size()); 
            E temp = list.get( pos1 );
            list.set( pos1, list.get(pos2) );
            list.set( pos2, temp );
        }
    }
}