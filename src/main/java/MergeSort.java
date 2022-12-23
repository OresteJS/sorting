import java.util.Arrays;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        // Wenn das Array leer oder nur ein Element hat, ist es bereits sortiert.
        if (array.length <= 1) {
            return;
        }

        // Finde die Mitte des Arrays.
        int middle = array.length / 2;

        // Kopiere die linken und rechten Hälften des Arrays in separate Arrays.
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        // Sortiere die linken und rechten Hälften rekursiv.
        sort(left);
        sort(right);

        // Führe die beiden sortierten Hälften zu einem einzigen, sortierten Array zusammen.
        merge(array, left, right);
    }

    private void merge(int[] array, int[] left, int[] right) {
        // Indizes für die drei Arrays.
        int i = 0, j = 0, k = 0;

        // Solange noch Elemente in beiden Hälften vorhanden sind, vergleiche sie und füge das kleinere Element dem Ergebnis-Array hinzu.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Füge alle verbleibenden Elemente aus der linken Hälfte dem Ergebnis-Array hinzu.
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Füge alle verbleibenden Elemente aus der rechten Hälfte dem Ergebnis-Array hinzu.
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}