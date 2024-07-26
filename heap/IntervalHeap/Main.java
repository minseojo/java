package IntervalHeap;

public class Main {
    public static void main(String[] args) {
        IntervalHeap heap = new IntervalHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.insert(2);

        System.out.println("Min: " + heap.getMin());
        System.out.println("Max: " + heap.getMax());

        heap.deleteMin();
        System.out.println("Min after deleteMin: " + heap.getMin());
        heap.deleteMax();
        System.out.println("Max after deleteMax: " + heap.getMax());
    }
}
