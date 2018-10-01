public class MergeSortDriver
{
    public static void main(String args[])
    {
        MergeSort mergeSort = new MergeSort();
        System.out.println("Unsorted: ");
        mergeSort.printarrayToSort();
        mergeSort.sortArray(0,mergeSort.getArrayToSort().length-1);
        System.out.println("Sorted: ");
        mergeSort.printarrayToSort();
    }
}
