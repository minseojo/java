import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;
public class CheckExceptionApp {

    @Test
    void check() {
        Controller controller = new Controller();
        Assertions.assertThrows(SQLException.class, () -> controller.request());
    }

    static class Controller {
        Service service = new Service();

        public void request() throws SQLException, ConnectException {
            service.logic();
        }
    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        public void logic() throws SQLException, ConnectException {
            /**
             * SQLException, ConnectException 을 Exception 최상위 에러로 변경 가능,
             * 하지만 이런 경우 모든 에러를 던지기 때문에 무슨 예외가 터진지 알기도 쉽지않고, 안티패턴이다.
             * 대안: 언체크 예외를 해결하자.
             */
            repository.call();
            networkClient.call();
        }
    }

    static class NetworkClient {
        public void call() throws ConnectException {
            throw new ConnectException("연결 실패");
        }
    }

    static class Repository {
        public void call() throws SQLException {
            throw new SQLException("ex");
        }
    }
}
