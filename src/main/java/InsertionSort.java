public class InsertionSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        // Durchlaufe das Array von links nach rechts und füge das aktuelle Element an der richtigen Stelle ein.
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            // Verschiebe alle Elemente, die größer als das aktuelle Element sind, eine Stelle nach rechts.
            // Setze das aktuelle Element an die freigewordene Stelle.
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}