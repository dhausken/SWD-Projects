import java.util.Random;

/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Handles most behaviors for the merge sort.
 *
 */
public class MergeSort
{
    /**
     * Array of integers of size 100 to be assigned random values.
     */
    private final int arrayToSort[] = new int[99];

    /**
     * MergeSort constructor. Assigns random values
     * to each index of the arrayToSort.
     */
    public MergeSort()
    {
        for(int i = 0; i < arrayToSort.length; i++)
        {
            Random rand = new Random();
            arrayToSort[i] = rand.nextInt(1000);
        }
    }

    /**
     * Sort method for the merge sort. Uses recursion to go through
     * the values and merges the indexes at the end.
     * @param low Lower element
     * @param high Higher element
     */
    public void sortArray(int low, int high)
    {
        if((high-low) >= 1) //Base case
        {
            int leftHalf = (low + high)/2; //Middle of array
            int rightHalf = leftHalf + 1; //Middle of array+1

            sortArray(low, leftHalf);
            sortArray(rightHalf,high);
            merge(low,high);
        }
    }

    /**
     * Merge two subarrays into a single sorted array.
     * @param left Left subarray
     * @param right Right subarray
     */
    private void merge(int left, int right)
    {
        //left index of the subarray to be sorted
        int leftIndex = left;
        //Where the left index stops.
        int leftBound = (left + right) / 2;
        //right of index of the subarray to tbe sorted.
        int rightIndex = leftBound + 1;
        int combinedIndex = left;
        int[] combined = new int[arrayToSort.length];

        while(leftIndex <= leftBound && rightIndex <= right) //Merge arrays until it reaches the end.
        {
            if(arrayToSort[leftIndex] <= arrayToSort[rightIndex])  //Place smallest element into result and shift
            {                                                      //to next space.
                combined[combinedIndex] = arrayToSort[leftIndex];
                leftIndex++;
            }
            else
            {
                combined[combinedIndex] = arrayToSort[rightIndex];
                rightIndex++;
            }
            combinedIndex++;
        }
        if(leftIndex == leftBound + 1)//Left array empty
        {
            while(rightIndex <= right)//Copy right array
            {
                combined[combinedIndex] = arrayToSort[rightIndex];
                rightIndex++;
                combinedIndex++;
            }
        }
        else
        {
            while(leftIndex <= leftBound)//Copy left array
            {
                combined[combinedIndex] = arrayToSort[leftIndex];
                leftIndex++;
                combinedIndex++;
            }
        }
        for(int i = left; i <= right; i++) //Copy values back into the array
        {
            arrayToSort[i] = combined[i];
        }
    }


    /**
     * Prints all values in the array toSort array.
     */
    public void printarrayToSort()
    {
        for(int i = 0; i < arrayToSort.length; i++)
        {
            System.out.print(arrayToSort[i]);
            if(i != arrayToSort.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    /**
     * Gets value of index of the array.
     * @param i Specified index of the array.
     * @return Value at the index.
     */
    public int getarrayToSortIndex(int i)
    {
        return arrayToSort[i];
    }

    /**
     * Getter for arrayToSort
     * @return int array of arrayToSort
     */
    public int[] getArrayToSort() {
        return arrayToSort;
    }
}
