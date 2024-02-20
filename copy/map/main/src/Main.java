import java.util.HashMap;
import java.util.Map;

public class Main {
    static int mapChangeId = 1;

    public static void main(String[] args) {
        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "A");

        deepcopyWithConstructor(originalMap); // 생성자를 이용한 [깊은 복사]
        deepcopyWithClone(originalMap); // clone()을 이용한 [깊은 복사]
        deepcopyWithPutAll(originalMap); // putAll()을 이용한 [깊은 복사]
        deepcopyWithFor(originalMap); // for문을 이용한 [깊은 복사]

        shallowCopy(originalMap); // [얕은 복사]


    }

    private static void deepcopyWithConstructor(Map<Integer, String> originalMap) {
        HashMap<Integer, String> copiedMap = new HashMap<>(originalMap);

        changeOriginalMap(originalMap); // originalMap 내부 변경
        printMap("생성자를 이용한 Map 복사 (깊은 복사)", originalMap, copiedMap);
        revertOriginalMap(originalMap); // originalMap 변경된 내부 복구
    }

    private static void deepcopyWithClone(Map<Integer, String> originalMap) {
        HashMap<Integer, String> copiedMap = (HashMap<Integer, String>) ((HashMap<Integer, String>) originalMap).clone();

        changeOriginalMap(originalMap);
        printMap("clone() 내장 메서드를 이용한 Map 복사 (깊은 복사)", originalMap, copiedMap);
        revertOriginalMap(originalMap);
    }

    private static void deepcopyWithPutAll(Map<Integer, String> originalMap) {
        HashMap<Integer, String> copiedMap = new HashMap<>();
        copiedMap.putAll(originalMap);

        changeOriginalMap(originalMap);
        printMap("putAll() 내장 메서드를 Map 복사 (깊은 복사)", originalMap, copiedMap);
        revertOriginalMap(originalMap);
    }

    private static void deepcopyWithFor(Map<Integer, String> originalMap) {
        HashMap<Integer, String> copiedMap = new HashMap<>();
        for (Map.Entry<Integer, String> entry : originalMap.entrySet()) {
            copiedMap.put(entry.getKey(), entry.getValue());
        }

        changeOriginalMap(originalMap);
        printMap("for문을 이용한 직접 Map 복사 (깊은 복사)", originalMap, copiedMap);
        revertOriginalMap(originalMap);
    }

    private static void shallowCopy(Map<Integer, String> originalMap) {
        HashMap<Integer, String> copiedMap = (HashMap<Integer, String>) originalMap;
        changeOriginalMap(originalMap);
        printMap("Map (얕은 복사)", originalMap, copiedMap);
        revertOriginalMap(originalMap);
    }

    private static void changeOriginalMap(Map<Integer, String> originalMap) {
        originalMap.put(mapChangeId, "C");
    }

    private static void revertOriginalMap(Map<Integer, String> originalMap) {
        originalMap.put(mapChangeId, "A");
    }

    private static void printMap(String message, Map<Integer, String> originalMap, Map<Integer, String> copiedMap) {
        System.out.println(message);
        System.out.println("originalMap.get(1) = " + originalMap.get(mapChangeId));
        System.out.println("copiedMap.get(1) = " + copiedMap.get(mapChangeId));
        System.out.println();
    }
}
