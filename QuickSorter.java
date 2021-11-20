/*
 * Justin Hardy
 * JEH180008
 */

import java.util.ArrayList;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class QuickSorter
{
    /** Static Variables */
    private static Random random = new Random(); // Created to avoid instancing issues that would result in duplicate numbers

    /** Static Methods */
    /**
     * Performs a Timed Quick Sort on the given ArrayList and with a given Pivot Strategy.
     */
    public static <E extends Comparable<E>> Duration timedQuickSort( ArrayList<E> list, PivotStrategy pivotStrategy ) throws NullPointerException {
        // Get Start Time
        long start = System.nanoTime();
        if( list.size() > 1 ) {
            // Create ArrayLists
            ArrayList<E> smaller = new ArrayList<E>(), same = new ArrayList<E>(), larger = new ArrayList<E>();

            // Choose element based on pivot strategy
            E chosenElement = null, r1 = null, r2 = null, r3 = null;
            switch( pivotStrategy ) {
                case FIRST_ELEMENT:
                chosenElement = list.get(0);
                break;

                case RANDOM_ELEMENT:
                chosenElement = list.get(random.nextInt(list.size()));
                break;

                case MEDIAN_OF_THREE_ELEMENTS:
                // Get two random elements
                r1 = list.get(0);
                r2 = list.get(list.size()/2);
                r3 = list.get(list.size()-1);

                // Find median between the three
                chosenElement = getMedianOfThree(r1,r2,r3);
                break;

                case MEDIAN_OF_THREE_RANDOM_ELEMENTS:
                // Get three random elements
                r1 = list.get(random.nextInt(list.size()));
                r2 = list.get(random.nextInt(list.size()));
                r3 = list.get(random.nextInt(list.size()));

                // Find median between the three
                chosenElement = getMedianOfThree(r1,r2,r3);
                break;
            }
            
            // Add elements, based off of pivot, to the associated lists
            for( E element : list ) {
                if( element.compareTo(chosenElement) < 0 )
                    smaller.add(element);
                else if( element.compareTo(chosenElement) > 0 )
                    larger.add(element);
                else
                    same.add(element);
            }
            
            // Sort the smaller and larger lists
            timedQuickSort(smaller, pivotStrategy);
            timedQuickSort(larger, pivotStrategy);
            
            // Clear the list and add the contents of each list
            list.clear();
            list.addAll(smaller);
            list.addAll(same);
            list.addAll(larger);
        }

        // Get End Time
        long end = System.nanoTime();
        Duration duration = Duration.of(end - start, ChronoUnit.NANOS);
        return duration;
    }

    /**
     * Generates a random ArrayList of Integers.
     */
    public static ArrayList<Integer> generateRandomList( int size ) throws IllegalArgumentException {
        // Throw IllegalArgumentException if the passed in size is negative.
        if( size < 0 ) 
            throw new IllegalArgumentException("ERROR! Invalid input. Size cannot be a negative number.");

        // Create needed variables
        ArrayList<Integer> list = new ArrayList<Integer>(size);

        // Fill list with random values within the int ranges.
        for( int i = 0; i < size; i++ ) {
            list.add(random.nextInt());
        }
        return list;
    }
    
    private static <E extends Comparable<E>> E getMedianOfThree( E first, E second, E third ) {
        // Utilizing exclusive or operator ^ to see if the first or second E is greater than only one of the other two E's.
        // If neither are, then the third is greater than the first and second, or they're all equal values.
        return first.compareTo(second) > 0 ^ first.compareTo(third) > 0 ? first : 
            ( second.compareTo(first) > 0 ^ second.compareTo(third) > 0 ? second : third );
    }
    
    // Testing getMedianOfThree() method
    //public static void main(String[] args) {
    //    Random random = new Random();
    //    Integer one = random.nextInt(100) + 1, two = random.nextInt(100) + 1, three = random.nextInt(100) + 1;
    //    
    //    System.out.printf("First Int:\t%d\n", one);
    //    System.out.printf("Second Int:\t%d\n", two);
    //    System.out.printf("Third Int:\t%d\n", three);
    //    System.out.println();
    //    System.out.printf("Median:\t%d\n", getMedianOfThree(one,two,three));
    //}

    /** Enums */
    enum PivotStrategy {
        // States
        FIRST_ELEMENT, RANDOM_ELEMENT, MEDIAN_OF_THREE_ELEMENTS, MEDIAN_OF_THREE_RANDOM_ELEMENTS
    }
}
