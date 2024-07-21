package heap;

import java.util.Arrays;

public class PriorityQueueMinHeap {
    int size;
    MinHeap minHeap;

    public PriorityQueueMinHeap(int size) {
        this.size = size;
        minHeap = new MinHeap(size);
    }

    int extractMin(int[] heap) {
        int minItem = heap[1];
        heap[1] = heap[minHeap.size];
        minHeap.size--;
        minHeap.minHeapify(heap, 1);
        return minItem;
    }

    void insertNode(int[] heap, int node) {
        minHeap.size++;
        int i = minHeap.size;
        heap[minHeap.size] = node;
        while (i > 1 && heap[i] < heap[minHeap.parent(i)]) {
            int p = minHeap.parent(i);
            int temp = heap[i];
            heap[i] = heap[p];
            heap[p] = temp;
            i = p;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] ara = {0, 2, 4, 5, 1, 7};
        PriorityQueueMinHeap priorityQueueMinHeap = new PriorityQueueMinHeap(ara.length - 1);
        priorityQueueMinHeap.minHeap.buildMinHeap(ara);
        System.out.println("Without extract: " + Arrays.toString(ara));
        System.out.println(priorityQueueMinHeap.extractMin(ara));
        System.out.println("After 1st extract: " + Arrays.toString(ara));
        System.out.println(priorityQueueMinHeap.extractMin(ara));
        System.out.println("After 2nd extract: " + Arrays.toString(ara));
        System.out.println(priorityQueueMinHeap.extractMin(ara));
        System.out.println("After 3rd extract: " + Arrays.toString(ara));
        System.out.println(priorityQueueMinHeap.extractMin(ara));
        System.out.println("After 4th extract: " + Arrays.toString(ara));

        priorityQueueMinHeap.insertNode(ara, 1);
        System.out.println(Arrays.toString(ara));
        priorityQueueMinHeap.insertNode(ara, 4);
        System.out.println(Arrays.toString(ara));

    }
}