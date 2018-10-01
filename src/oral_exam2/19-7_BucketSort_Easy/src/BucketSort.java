import java.util.Random;
/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles behaviors most behaviors for the BucketSort.
 * Implements both of the required arrays, the sort method, and
 * several helper functions.
 */
public class BucketSort
{
    /**
     * 1D int array that holds values that are to be sorted.
     * Values expected to be in order after the sort method.
     */
    private final int[] toSort;
    /**
     * 2D array that holds values from the toSort array
     * based on modulo arithmetic.
     */
    private final int[][] isSorted;
    Random random = new Random();

    /**
     * Constructor for bucket sort. Creates a new array with size n
     * and assigns random values to each index.
     * @param n Size of the toSort array.
     */
    public BucketSort(int n)
    {
        toSort = new int[n];
        for(int i = 0; i < toSort.length; i++)
        {
            toSort[i] = random.nextInt(100);
        }
        isSorted = new int[10][n-1];
    }

    /**
     * Sort method for BucketSort. Copies elements from toSort to isSorted array,
     * copies the newly sorted numbers back to the toSort array, and reassigns all the values of
     * isSorted back to 0. Repeats this process 3 times.
     */
    public void sort()
    {
        for(int l = 1; l < 101; l*=10)
        {
            for(int i = 0; i < toSort.length; i++)
            {
                int position = (toSort[i]/l)%10;
                //Go through each row
                for(int j = 0; j < isSorted.length; j++)
                {
                    //If it's the correct row
                    if(position == j)
                    {
                        //Go through each column
                        for(int k = 0; k < isSorted[j].length; k++)
                        {
                            //Copy element if it's 0
                            if(isSorted[j][k] == 0)
                            {
                                isSorted[j][k] = toSort[i];
                                break;
                            }
                        }
                    }
                }
            }
            copyBack();
            clearArray();
        }
    }

    /**
     * Helper method to transfer non-zero integers from isSorted to toSort.
     */
    private void copyBack()
    {
        int k = 0;
        for(int i = 0; i < isSorted.length; i++)
        {
            for(int j = 0; j < isSorted[i].length; j++)
            {
                if(isSorted[i][j] != 0)
                {
                    toSort[k] = isSorted[i][j];
                    k++;
                }
            }
        }
    }

    /**
     * Helper method to assign all of the values of isSorted back to 0.
     */
    private void clearArray()
    {
        for(int i = 0; i < isSorted.length; i++)
        {
            for(int j = 0; j < isSorted[i].length; j++)
            {
                isSorted[i][j] = 0;
            }
        }
    }

    /**
     * Prints the toSort Array.
     */
    public void printToSortArray()
    {
        for(int i = 0; i < toSort.length; i++)
        {
            if(i != toSort.length-1)
            {
                System.out.print(toSort[i] + ", ");
            }
            else
            {
                System.out.print(toSort[i]);
            }
        }
        System.out.println();
    }

    /**
     * Prints the isSorted array.
     */
    public void printIsSortedArray()
    {
        for(int i = 0; i < isSorted.length; i++)
        {
            for(int j = 0; j < isSorted[i].length; j++)
            {
                if(i != toSort.length-1)
                {
                    System.out.print(isSorted[i][j] + ", ");
                }
                else
                {
                    System.out.print(toSort[i]);
                }

            }
            System.out.println();
        }
    }


}
