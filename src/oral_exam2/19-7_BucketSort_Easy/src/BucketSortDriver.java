public class BucketSortDriver
{
    public static void main(String args[])
    {
        BucketSort bucketSort = new BucketSort(5);
        System.out.println("Unsorted: ");
        bucketSort.printToSortArray();
        bucketSort.sort();
        System.out.println("Sorted: ");
        bucketSort.printToSortArray();
    }
}
