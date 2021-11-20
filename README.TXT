--------------------------------------------------------------------
--------------------------------------------------------------------

SECTION: Project Information

--------------------------------------------------------------------
--------------------------------------------------------------------
PROJECT: Project 3 
NAME: Justin Hardy
NET ID: jeh180008
CLASS: 3345.0W3
IDE: BlueJ
VERSION: Java 11+
FILES: Main.java  QuickSorter.java  README.txt
FILE W/ MAIN FUNCTION: Main.java
--------------------------------------------------------------------
--------------------------------------------------------------------

SECTION: Randomly Generated List Reports

--------------------------------------------------------------------
--------------------------------------------------------------------
Sample Report File 1: (ten elements)

FIRST_ELEMENT : PT0.0021754S
RANDOM_ELEMENT : PT0.0000434S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0000504S
MEDIAN_OF_THREE_ELEMENTS : PT0.0035067S
--------------------------------------------------------------------
Sample Report File 2: (one thousand elements)

FIRST_ELEMENT : PT0.0036925S
RANDOM_ELEMENT : PT0.0019131S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0013091S
MEDIAN_OF_THREE_ELEMENTS : PT0.0009968S
--------------------------------------------------------------------
Sample Report File 3: (ten thousand elements)

FIRST_ELEMENT : PT0.0127026S
RANDOM_ELEMENT : PT0.0099941S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0133835S
MEDIAN_OF_THREE_ELEMENTS : PT0.0072952S
--------------------------------------------------------------------
Sample Report File 4: (one hundred thousand elements)

FIRST_ELEMENT : PT0.1084534S
RANDOM_ELEMENT : PT0.1175401S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0824258S
MEDIAN_OF_THREE_ELEMENTS : PT0.0426825S
--------------------------------------------------------------------
Sample Report File 5: (one million elements)

FIRST_ELEMENT : PT0.6609184S
RANDOM_ELEMENT : PT0.7321096S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.7040383S
MEDIAN_OF_THREE_ELEMENTS : PT0.6122212S
--------------------------------------------------------------------
--------------------------------------------------------------------

SECTION: Almost-Sorted & Sorted List Reports

--------------------------------------------------------------------
--------------------------------------------------------------------
Sample Almost-Sorted Report File 1: (one thousand elements)

FIRST_ELEMENT : PT0.004949S
RANDOM_ELEMENT : PT0.0007675S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0006793S
MEDIAN_OF_THREE_ELEMENTS : PT0.0005142S
--------------------------------------------------------------------
Sample Almost-Sorted Report File 2: (one hundred thousand elements)

FIRST_ELEMENT : PT0.1592565S
RANDOM_ELEMENT : PT0.0821792S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0574139S
MEDIAN_OF_THREE_ELEMENTS : PT0.0393531S
--------------------------------------------------------------------
Sample Sorted Report File 1: (one hundred elements)

FIRST_ELEMENT : PT0.0021665S
RANDOM_ELEMENT : PT0.0001214S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0001236S
MEDIAN_OF_THREE_ELEMENTS : PT0.0001061S
--------------------------------------------------------------------
Sample Sorted Report File 2: (one thousand elements)

FIRST_ELEMENT : PT0.0247275S
RANDOM_ELEMENT : PT0.0008118S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0008079S
MEDIAN_OF_THREE_ELEMENTS : PT0.0007321S
--------------------------------------------------------------------
--------------------------------------------------------------------

SECTION: Summaries

--------------------------------------------------------------------
--------------------------------------------------------------------
Summary over Pivot Strategies:

Based off of these results, it's apparent that for smaller sample
sizes, the random element pivot strategy has the greatest potential
for being the fastest strategy. However, this is hindered by the
aspects of random chance, as there is the cance for the pivot that
is chosen to be a bad pivot. It is also apparent that for larger
sample sizes, the median of three elements strategy is objectively
the fastest pivot strategy. Starting around ten thousand elements,
the strategy had the fastest run-time for every time.

In summary, the random element and median of three elements pivot
strategies are the fastest strategies, with random element being
best for smaller array sizes, and median of three elements being
best for larger array sizes.
--------------------------------------------------------------------
Summary over Allmost-Sorted and Sorted Arrays:

Based off of these results, it's apparent that the sorting algorithm
performs slower the more sorted it is. Furthermore, this applies for
both possibilites; if it is sorted the way we want it already, or if
it is sorted the direct opposite of the way we want it. Therefore,
the algorithm is most efficient when the list is not at all sorted.
This is supported by the fact that for the almost-sorted results,
the one thousand element trials performed faster in all cases than 
the sorted results.

Additionally, for a sorted list, the FIRST_ELEMENT pivot strategy 
will always result in a stack overflow when dealing with
approximately ten thousand or more elements. I didn't test this for
the other pivot strategies, but it is fair to assume that this
wouldn't be that case for all of the other pivot strategies. This
serves as another example as to why the algorithm, albeit with its
worst pivot strategy, is inefficient with sorted arrays.
--------------------------------------------------------------------