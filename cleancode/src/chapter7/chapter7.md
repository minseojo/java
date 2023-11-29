# 정리

- 오류 코드 대신 예외를 사용하라
- check 예외는 OCP를 위반한다. 
  - 해결 방법 → unchecked 예외를 사용하라.
  
- 예외에 의미를 제공하라.
  - 실패한 코드의 의드롤 파악하려면 호출 스택만으로 부족하다.
- 호출자를 고려해 예외 클래스를 정의하라.
- null을 반환하지 않는다.
- null을 전달하지 않는다.
- 정상 흐름을 정의한다.

---
## 오류 코드 대신 예외를 사용한 예시

### 오류 코드를 사용한 예시
```java
public class DeviceController {
    ...

    public void sendShutDown() {
        DeviceHandle handle = getHandle(DEV1);
        // 디바이스 상태를 점검한다.
        if (handle != DeviceHandle.INVALID) {
            // 레코드 필드에 디바이스 상태를 저장한다.
            retrieveDeviceRecord(handle);
            // 디바이스가 일시정지 상태가 아니라면 종료한다.
            if (record.getStatus() != DEVICE_SUSPENDED) {
                closeDevice(handle);
            } else {
                logger.log("Device suspended. Unable to shut down");
            }
        } else {
            logger.log("Invalid handle");
        }
    }

    ...
}
```

### 오류 코드 대신 예외를 사용한 예시
```java
public class DeviceController {
    ...

    public void sendShutDown() {
        try {
            tryToShutDown();
        }
        catch (DeviceShutDownError e) {
            logger.log(e);
        }
    }

    private void tryToShutDown() {
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);

        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }

    private DeviceHandle getHandle(DeviceId id) {
		...
        throw new DeviceShutDownError("Invalid handle for: " + id.toString());
		...
    }

    private DeviceRecord retrieveDeviceRecord(DeviceHandle handle) {
		...
        throw new DeviceShutDownError("Invalid handle for: " + handle.toString());
		...
    }
}
```

---

## 정상 흐름을 정의 예시
### 정상 흐름을 정의 하지 않은 코드
```java
try {
    MealExpenses expenses = expenseReportDAO.getMeals(employee.getId());
    m_total += expenses.getTotal();
} catch (MealExpenseNotFound e) {
    m_total += getMealPerDiem();
}
```

### 정상 흐름을 정의 한 코드
```java
MealExpenses expenses = expenseReportDAO.getMeals(employee.getId());
m_total += expenses.getTotal(); // 청구한 식비가 없다면, 기본 식비 반환
```