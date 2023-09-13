package src.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * 체크 예외 기본 이해
 장점
 예외처리를 컴파일러가 확인해주기 때문에, 개발자의 실수를 방지해준다.

 단점
 개발자가 모든 예외를 반드시 잡거나, 던져야 하기 때문 번거로운 과정이 된다.
 ex) JDBC 쓰다가 JPA로 바꿀 시 예외처리 코드를 모두 바꿔야한다. -> 이 경우 언체크 예외로 처리

 체크예외는 잘 안쓰려고 한다. 하지만 예외처리를 반드시 처리해야 하는경우 명시적으로 처리하기위해 체크예외를 쓴다.
 ex) 계좌 실패 예외, 결제시 포인트 부족 예외, 로그안 ID, PW 불일치 예외 -> 이 경우들도 100% 체크는 아니므로 유동적으로.
 */
public class CheckExceptionBasic {
    @Test
    void check() {
        Service service = new Service();
        // 에러를 메인 호출전에 처리하는 코드
        // service.callCatch();

        // 에러를 계속 던져서, 최상단 메인문에서까지 던지면 프로그램이 터진다.
        // 즉 처리를 어디선가는 해줘야함.
        Assertions.assertThrows(MyCheckedException.class, () -> service.callThrow());
    }

    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();
        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException e) {
                //MyCheckedException -> Exception 바꿀시에 캐치범위가 늘어남, 원치 않는 에러도 잡음
                // > 나중에 에러를 만든 의도파악 힘듦
                System.out.println("예외 처리, message=" + e.getMessage());
                System.out.println(e);
                //log.info("예외 처리, message={}". e.getMessage(), e);
            }
        }

        public void callThrow() throws MyCheckedException {
            repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedException {
            throw new MyCheckedException("myCheckException 터짐");
        }
    }
}
