import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UncheckExceptionApp {

    @Test
    void uncheck() {
        Controller controller = new Controller();
        Assertions.assertThrows(RuntimeException.class,
                () -> controller.request());
    }

    static class Controller {
        Service service = new Service();

        public void request() {
            service.logic();
        }
    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        public void logic() {
            repository.call();
            networkClient.call();
        }
    }
    static class NetworkClient {
        public void call() {
            throw new RuntimeConnectException("연결 실패");
        }

    }
    static class Repository {
        public void call() {
            try {
                runSQL();
            } catch (SQLException e) {
                // 체크 예외를 언체크 예외로 바꿔서 던져준다.
                // 예외를 던져 줄때는 에러를 같이 넣어줘야 에러 스택 트레이스를 알 수 있음.
                throw new RuntimeSQLException(e);
            }
        }

        public void runSQL() throws SQLException {
            throw new SQLException("ex");
        }
    }

    static class RuntimeConnectException extends RuntimeException{
        public RuntimeConnectException(String message) {
            super(message);
        }
    }

    static class RuntimeSQLException extends RuntimeException{
        public RuntimeSQLException(Throwable cause) {
            super(cause);
        }
    }
}

