package BinaryHeap;

public class Main {
    public static void main(String[] args) {
        BinaryHeap minHeap = new BinaryMinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.insert(2);
        System.out.print("minHeap: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(minHeap.extract() + " ");
        }

        System.out.println();
        BinaryHeap maxHeap = new BinaryMaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(7);
        maxHeap.insert(1);
        maxHeap.insert(2);
        System.out.print("maxHeap: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(maxHeap.extract() + " ");
        }

    }
}
