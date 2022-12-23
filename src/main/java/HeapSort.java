public class HeapSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        // Erstelle einen Max-Heap aus dem Array.
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            // Führe den Heapify-Prozess für das aktuelle Element aus.
            heapify(array, n, i);
        }

        // Extrahiere das größte Element aus dem Heap und füge es ans Ende des Arrays.
        // Verringere die Größe des Heaps um 1 und führe den Heapify-Prozess erneut aus.
        // Wiederhole diesen Prozess, bis das Array vollständig sortiert ist.
        for (int i = n - 1; i > 0; i--) {
            // Tausche das größte Element mit dem letzten Element im Heap.
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Führe den Heapify-Prozess für das neue Wurzelelement aus.
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        // Finde den größten Wert zwischen dem aktuellen Element, seinem linken Kind und seinem rechten Kind.
        // Wenn das aktuelle Element nicht der größte Wert ist, tausche es mit dem größten Wert und führe den Heapify-Prozess für das getauschte Element erneut aus.
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left] > array[largest]) {
            // Das linke Kind ist größer als das aktuelle Element.
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            // Das rechte Kind ist größer als das aktuelle Element.
            largest = right;
        }
        if (largest != i) {
            // Das aktuelle Element ist nicht der größte Wert. Tausche es mit dem größten Wert und führe den Heapify-Prozess für das getauschte Element erneut aus.
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }
}