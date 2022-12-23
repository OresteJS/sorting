public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int low, int high) {
        if (low < high) {
            // Wähle ein Pivotelement und partitioniere das Array entsprechend.
            int pivotIndex = partition(array, low, high);
            // Sortiere den linken Teil des Arrays rekursiv.
            sort(array, low, pivotIndex - 1);
            // Sortiere den rechten Teil des Arrays rekursiv.
            sort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        // Wähle das letzte Element im aktuellen Bereich als Pivotelement.
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Wenn das aktuelle Element kleiner oder gleich dem Pivotelement ist, tausche es mit dem nächsten Element links vom Pivotelement.
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}