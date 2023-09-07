import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 언체크 예외 기본 이해
 * RuntimeException 과 그 하위 예외들이 언체크 예외
 *
 * 장점
 * 신경쓰고 싶지 않은 언체크 예외를 무시 할 수 있다. > 바로바로 처리하지않고, 최상단에서 한번에 처리 할 수 있다.
 * 신경쓰고 싶지 않은 의존관계를 참조하지 않아도 된다.
 *
 * 단점
 * 개발자 실수를 누락할 수 있다.
 *
 * 체크 예외 vs  언체크 예외
 * 예외를 밖으로 명시적으로 던져준다 vs 예외를 밖으로 명시적으로 던지지 않아도 된다.
 */
public class UncheckExceptionBasic {
    @Test
    void uncheck() {
        Service service = new Service();
        //service.callCatch();
        Assertions.assertThrows(MyUncheckedException.class, () -> service.callThrow());
    }

    static class MyUncheckedException extends RuntimeException {
        public MyUncheckedException(String message) {
            super(message);
        }
    }

    /**
     * Unchecked 예외는 예외를 잡거나, 던지지 않아도 된다.
     * 예외를 잡지 않으면 자동으로 던진다.
     */
    static class Service {
        Repository repository = new Repository();

        public void callCatch() {
            try {
                repository.call();
            } catch (MyUncheckedException e) {
                System.out.println(e);
            }
        }

        public void callThrow() { // 예외를 직접 안던져도 알아서 던진다.
            repository.call();
        }
    }

    static class Repository {
        public void call() {
            throw  new MyUncheckedException("ex");
        }
    }
}
