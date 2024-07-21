package heap;

public class MinHeap {
    int size;

    public MinHeap(int size) {
        this.size = size;
    }

    void buildMinHeap(int[] heap) {
        for (int i = size / 2; i >= 1; i--) {
            minHeapify(heap, i);
        }
    }

    void minHeapify(int[] heap, int root) {
        int l = left(root);
        int r = right(root);
        int min;
        if (l <= size && heap[l] < heap[root]) {
            min = l;
        } else {
            min = root;
        }
        if (r <= size && heap[r] < heap[min]) {
            min = r;
        }
        if (min != root) {
            int temp = heap[min];
            heap[min] = heap[root];
            heap[root] = temp;
            minHeapify(heap, min);
        }
    }

    int left(int parent) {
        return parent * 2;
    }

    int right(int parent) {
        return parent * 2 + 1;
    }

    int parent(int child) {
        return child / 2;
    }
}