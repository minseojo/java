package BinaryHeap;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class BinaryMinHeap implements BinaryHeap{

    private final List<Integer> elements;

    public BinaryMinHeap() {
        // 클래스 생성 시 빈 리스트를 선언하고, 첫 번째 값은 널을 삽입하여 사용하지 않음. - 인덱스 1번 부터 시작
        elements = new ArrayList<>();
        elements.add(null);
    }

    private void percolateUp() {
        // 마지막 엘리먼트 위치
        int idx = elements.size() - 1;
        // 부모 노드 인덱스
        int parentIdx = idx / 2;
        // 부모 노드가 존재한다면 계속 반복
        while (parentIdx > 0) {
            // 부모 노드가 더 크면 값 스왑
            if (elements.get(idx) < elements.get(parentIdx)) {
                swap(elements, idx, parentIdx);
            }
            // 현재 엘리먼트 값을 부모 노드로 지정
            idx = parentIdx;
            // 현재 엘리먼트의 부모 노드 지정
            parentIdx = idx / 2;
        }
    }

    @Override
    public void insert(int value) {
        elements.add(value);
        percolateUp();
    }

    private void heapify(int i) {
        int left = i * 2;
        int right = i * 2 + 1;
        // 현재 노드의 값을 가장 작은 값을 가정
        int smallest = i;

        if (left <= elements.size() - 1 && elements.get(left) < elements.get(smallest)) {
            smallest = left;
        }
        if (right <= elements.size() - 1&& elements.get(right) < elements.get(smallest)) {
            smallest = right;
        }
        // 가장 작은 값이 현재 노드가 아니라면 값 스왑 진행
        if (smallest != i) {
            swap(elements, smallest, i);
            // 스왑 이후 계속 진행
            heapify(smallest);
        }
    }

    @Override
    public int extract() {
        // 루트 값 추출, 최소 힙이므로 가장 작은 값
        int extracted = elements.get(1);

        // 루트에 마지막 엘리먼트 삽입
        elements.set(1, elements.get(elements.size() - 1));
        // 마지막 엘리먼트 제거
        elements.remove(elements.size() - 1);
        // 루트에 대해 다운힙 연산 수행
        heapify(1);

        return extracted;
    }
}
