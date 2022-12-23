import java.util.Arrays;

public class SortingApplication {

    public static void main(String[] args) {
        int[] numbers = Utilities.getRandomNumbers(10000);
        int[] originalNumbers = Arrays.copyOf(numbers, numbers.length);

        SortAlgorithm[] algorithms = {
                new BubbleSort(), new QuickSort(), new MergeSort(), new HeapSort(), new InsertionSort()
        };

        for (SortAlgorithm algorithm : algorithms) {
            numbers = Arrays.copyOf(originalNumbers, originalNumbers.length);

            double startTime = System.nanoTime() / 1000000.0;
            algorithm.sort(numbers);
            double endTime = System.nanoTime() / 1000000.0;
            double duration = endTime - startTime;
            String algorithmName = algorithm.getClass().getSimpleName();
            System.out.println(algorithmName + ":");
            System.out.println("Duration: " + duration + " ms");
            System.out.println();
        }
    }

}
