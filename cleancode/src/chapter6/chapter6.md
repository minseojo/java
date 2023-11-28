# 🚩 자료 추상화
## Point 클래스
### 구체적인 Point 클래스 : P1 클래스
```java
public class Point {
    public double x;
    public double y;
}
```

### 추상적인 Point 클래스 : P2 클래스
```java
public interface Point {
    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
```
### 공통점
- P1 클래스와 P2 클래스는 모두 2차원 점을 표현한다. <br/>

### 차이점
- 노출 정도
  - P1 클래스는 구현을 외부로 노출한다.
    - P1 클래스는 확실히 직교좌표계를 사용한다. (X, Y)
      - 개별적으로 좌표값을 읽고 설정하게 강제한다.
      - 변수를 private으로 선언 하더라도 각 값마다 Getter, Setter 함수를 제공 한다면 구현을 외부로 노출하는 셈
        - ❗️변수 사이에 메서드 계층을 넣는다고 구현이 감춰지지는 않는다. → 추상화가 필요하다. (추상 인터페이스)
          - 추상 인터페이스를 제공해 사용자가 구현을 모른 채 자료의 핵심을 조작할 수 있어야 진정한 의미의 클래스
  - P2 클래스는 구현을 완전히 숨긴다.
    - P2 클래스는 직교좌표계, 극좌표계 무슨 좌표계를 사용하는지 알 수 없다.
      - P2 클래스는 좌표를 읽을 때는 값 값을 개별적으로 읽고, 좌표를 설정할 때는 두 값을 한꺼번에 설정한다.

---
## Vehicle 클래스

### 구체적인 Vehicle 클래스 : Vehicle1 클래스
```java
public interface Vehicle {
    double getFuelTankCapacityInGallons();
    double getGallonsOfGasoline();
}
```

### 추상적인 Vehicle 클래스 : Vehicle2 클래스
```java
public interface Vehicle {
    double getPercentFuelRemaining();
}
```
### 공통점
- Vehicle1 클래스와 Vehicle2 클래스는 모두 자동차 연료 상태를 표현한다.

### 차이점
- 노출 절도
  - Vehicle1 클래스는 자동차 연료 상태를 구체적인 숫자 값으로 알려준다.
    - Vehicle1 클래스는 두 메서드가 변수값을 읽어 자동차 연료 상태를 반환할 뿐이라는 사실이 거의 확실하다.
  - Vehicle2 클래스는 자동차 연료 상태를 백분율이라는 추상적인 개념으로 알려준다.
    - Vehicle2 클래스의 메서드는 정보가 어디서 오는지 전혀 드러나지 않는다.

---
# ❗️Point, Vehicle 클래스 정리
- P1 클래스 보다는 P2 클래스가, Vehicle1 클래스 보다는 Vehicle2 클래스가 더 좋다. <br/>
- 자료를 세세하게 공개하기 보다는 추상적인 개념으로 표현하는 편이 좋다. <br/>
- 인터페이스나 Getter/Setter 함수만으로는 추상화가 이뤄지지 않는다. <br/>
- 개발자는 객체가 포함하는 자료를 표현할 가장 좋은 방법을 심각하게 고민해야 한다.
- 아무 생각 없이 Getter/Seter 함수를 추가하는 방법이 가장 나쁘다.
- P1 과 Vehicle1은 자료구조다. P2와 Vehicle2는 객체이다.
  - 자료 구조는 자료를 그대로 공개하며 별다른 함수는 제공하지 않는다.
    - public double fuelTankCapacityInGallons;
    - public double gallonsOfGasoline
  - 객체는 추상화 뒤로 자료를 숨긴 채 자료를 다루는 함수만 공개한다.
    - getPercentFuelRemaining() 의 내부 구현(멤버 변수)를 알 수 없다.

# ✅ 느낀 점
평소에 메서드명을 세세하고 명확하는게 더 좋다고 생각했다. 왜냐하면 메서드 의도가 명확했기 떄문이다. <br/>
하지만 너무 명확하면, 클래스의 노출이 쉽게 된다는 점을 알게됐다. 또한 클래스 재사용 범위도 줄 것 같다.


---
# 🚩 자료/객체 비대칭
## 절차적인 코드 vs 객체 지향 코드

### 절차적인 도형 : Shapes1
```java
public class Square {
    public Point topLeft;
    public double side;
}

public class Rectangle {
    public Point topLeft;
    public double height;
    public double width;
}

public class Circle {
    public Point center;
    public double radius;
}

public class Geometry {
    public final double PI = 3.1415926535;

    public double area(Object shape) throws NoSuchElementException {
        if (shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        }
        else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.height * r.width;
        }
        else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        }

        throw new NoSuchElementException();
    }
}
```

### 객체적인 도형 : Shapes2
```java
public class Square implements Shape {
    private Point topLeft;
    private double side;

    public double area() {
        return side * side;
    }
}

public class Rectangle implements Shape {
    private Point topLeft;
    private double height;
    private double width;

    public double area() {
        return height * height;
    }
}

public class Circle implements Shape {
    private Point center;
    private double radius;
    public final double PI = 3.1415926535;

    public double area() {
        return PI * radius * radius;
    }
}
```

### 본인이 코드를 짠다면 무슨 코드를 짤 것인가? 절차지향? 객체지향?

### 만약 Shapes1 Geometry 클래스에 둘레 길이를 구하는 perimeter() 메서드를 추가하고 싶다면?
- shapes1 : 도형 클래스는 아무 영향도 받지 않는다! 도형 클래스에 의존하는 다른 클래스도 마찬가지다!
- shapes2 : 도형 클래스는 모두 영향 받는다. 모든 도형 클래스에 새로운 메서드를 추가해야 한다.

### 만약 새로운 도형을 추가하고 싶다면?
- shapes1 : Geometry 클래스에 속한 메서드를 모두 고쳐야 한다.
- shapes2 : 아무 코드도 건들지 않고, 새로운 도형 클래스를 추가하면 된다.

# ❗️절차적인 코드 vs 객체 지향 코드 정리
- 절차적인 코드는 기존 자료 구조를 변경하지 않으면서 `새 메서드를 추가하기 쉽다.`
- 객체 지향 코드는 기존 메서드를 변경하지 않으면서 `새 클래스를 추가하기 쉽다.`
- 절차적인 코드는 `새로운 자료구조를 추가하기 어렵다.` 그러려면 모든 메서드를 고쳐야 한다.
- 객체 지향 코드는 `새로운 메서드를 추가하기 어렵다.` 그러려면 모든 클래스를 고쳐야 한다.
- `객체 지향 코드에서 어려운 변경은 절차적인 코드에서 쉬우며, 절차적인 코드에서 어려운 변경은 객체 지향 코드에서 쉽다!`
- 복잡한 시스템을 짜다 보면 새로운 메서드가 아니라 새로운 자료 타입이 필요한 경우가 생긴다 → `클래스와 객체 지향 기법`
- 새로운 자료 타입이 아니라 새로운 메서드가 필요한 경우가 생긴다 → `자료구조와 절차 적인 코드`


# ✅  느낀 점
사실 객체 지향 코드를 잘 짜지는 못하지만, 절차적인 코드를 짜면 코드를 너무 쉽게 짜는 기분이 들었고, 부끄러웠다. <br/>
하지만 가끔 객체 지향 코드를 짜다보면, "굳이 이렇게까지 해야하나? 너무 오버 엔지니어링인데" 라는 기분도 많이 들었다. <br/>
때로는 단순한 자료 구조와 절차적인 코드가 가장 적합한 상황이 있다는 것을 알게 되었다. <br/>
그리고 이제는 절차적인 코드를 짜야하는 상황이 온다면 이제는 부끄러워 하지 않고 오히려 절차적인 코드가 효율적임을 증명해야겠다.

--- 


# 🚩 디미터 법칙

## 정의
디미터 법칙은 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다는 법칙이다. <br/>
객체는 자료를 숨기고 메서드를 공개한다. 즉, 객체는 조회 함수로 내부 구조를 공개하면 안 된다는 의미다. <br/>

### 클래스 C의 메서드 f는 다음과 같은 객체의 메서드만 호출해야 한다.
- 클래스 C
- f가 생성한 객체
- f 인수로 넘어온 객체 (메서드 파라미터)
- C 인스턴스 변수에 저장된 객체 (멤버 변수)

하지만 위 객체에서 허용된 메서드가 반환하는 객체의 메서드는 호출하면 안된다. <br/>

---
## 기차 충돌

```java
final String ouputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
```
위와 같은 코드를 `기차 충돌` 이라 부른다. 일반적으로 조잡하다 여겨지는 방식이므로 피하는 편이 좋다. <br/>

위 코드를 다음과 같이 나눠보자.
```java
Options options = ctxt.getOptions();
File scratchDir = options.getScratchDir();
final String outputDir = scratchDir.getAbsolutePath();
```

확실히 위 코드 형태로 구현된 메서드는 ctxt 객체가 Options를 포함하며, Options가 ScartchDir을 포함하며, <br/>
ScratchDir이 AbsolutePath를 포함한다는 사실을 안다. 메서드 하나가 아는 지식이 굉장히 많다. 위 메서드는 많은 객체를 탐색할 줄 앎을 의미한다.

### 그럼 위 둘의 코드는 둘 다 디미터 법칙을 위반할 까?
이 정답은 ctxt, Options, ScratchDir 이 객체인지 아니면 자료구조인지에 달렸다. <br/>
- `객체`라면 내부 구조를 숨겨야 하므로 확실히 `디미터 법칙을 위반한다.`
- 반면, `자료 구조`라면 당연히 내부 구조를 노출하므로 `디미터 법칙이 적용되지 않는다.`

하지만 위 코드는 조회 함수를 사용하는 바람에 혼란을 일으킨다.
```java
final String outputDir = ctxt.options.scratchDir.absoltePath;
```
코드를 위 처럼 구현했다면 디미버 텁칙을 거론할 필요가 없어진다. (자료 구조) <br/>
따라서 자료구조는 무조건 메서드 없이 공개 변수만 포함하고 객체는 비공개 변수와 공개 함수를 포함한다면, 문제는 훨씬 간단하다. <br/>
하지만 단순한 자료 구조에도 Getter/Setter를 정의하라 요구하는 프레임워크와 표준(예시: 빈(bean))이 존재한다.

---
## 구조체 감추기

### 만약 ctxt, options ,scratchDir 이 진짜 객체라면?
그렇다면 앞에 코드처럼 기차 충돌을 내면 안된다. 객체라면 내부 구조를 감춰야 하니까! <br/>

### 그렇다면 임시 디렉토리의 절대 경로는 어떻게 얻어야 할 까?
```java
ctxt.getAbsolutePathOfScraatchDirectoryOption(); // 1 번 코드

ctxt.getScratchDirectoryOption().getAbsoluterPath(); // 2 번 코드
```
- 1번 방법 : ctxt 객체에 공개해야 하는 메서드가 너무 많아진다.
- 2번 방법 : getScratchDirectoryOption()이 객체가 아니라 자료 구조를 반환한다고 가정한다.
  두 방법 모두 내키지 않는다.

ctxt가 객체라면 `뭔가를 하라고` 말해야지 속을 드러내라고 말하면 안 된다.

### 임시 디렉터리의 절대 경로가 왜 필요할까? 절대 경로를 얻어 어디에 쓸려고?
```java
String outFile = outputDir + "/" + className.replace('.', '/') + ".class";
FileOuputStream fout = new FileOuputStream(outFile);
BufferedOutputStream bos = new BufferedOutputStream(fout);
```
다음으 같은 모듈에서 (한참 아래로 내려가서) 가져온 코드다. (참고로 실제에서 점, 슬래시, 파일 확장자, File 개체를 부주의하게 마구 섞으면 안 된다.) <br/>
어찌 되었거나, 위 코드를 살펴보면, 임시 디렉토리의 절대 경로를 얻으려는 이유가 임시 파일을 생성하기 위한 목적이라는 사실이 드러난다. <br/>

### 그렇다면 ctxt객체에 임시 파일을 생성하라고 시키면 어떨까?

```java
BufferedOutputStream bos = ctxt.createScratchFileStream(classFileName);
```
객체에게 맡기기에 적당한 임무로 보인다. ctxt는 내부 구조를 드러내지 않으며, 모듈에서 해당 함수는 자신이 몰라야 하는 여러 객체를 탐색할 필요가 없다. <br/>
따라서 디미터 법칙을 위반하지 않는다.

# ❗️디미터 법칙 정리
- 자료 구조는 디미터 법칙을 생각할 필요가 없다.
- 객체는 디미터 법칙을 지켜야 한다.
- 객체에게 원하는 행위를 시켜서, 내부 구현을 감추고 디미터 법칙을 지키자.

---

# 🚩 자료 전달 객체 (DTO)
- 자료 구조체의 전형적인 형태는 공개 변수만 있고 함수가 없는 클래스다. <br/>
- 이런 자료 구조체를 때로는 `자료 전달 객체(Data Transfer Object, DTO)` 라 한다. DTO 는 유용한 구조체다. <br/>
- 흔히 DTO는 데이터베이스에 저장된 가공되지 않은 정보를 애플리케이션 코드에서 사용할 객체로 변환하는 일련의 단계에서 `가장 처음으로 사용하는 구조체다.` <br/>

## 일반적인 DTO 형태
```java
public class Address {
    private String street;
    private String streetExtra;
    private String city;

    public Address(String street, String streetExtra, String city) {
        this.street = street;
        this.streetExtra = streetExtra;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetExtra() {
        return streetExtra;
    }

    public String getCity() {
        return city;
    }
}
```
일반적인 형태는 빈(bean) 구조다. 빈은 private 변수를 Getter/Setter 메서드로 조작한다. <br/>
책의 내용을 빌리면 "일종의 사이비 캡슐화로, 일부 ㅇㅇ 순수주의자나 만족시킬 뿐 별다른 이익을 제공하지 않는다."

---
## 활성 레코드
활성 레코드는 DTO의 특수한 형태다. <br/>
공개 변수가 있거나 비공개 변수에 Getter/Setter 메서드가 있는 자료 구조지만, 대개 save()나 find() 같은 탐색 함수도 제공한다. <br/>
활성 레코드는 데이터베이스 테이블이나 다른 소스에서 자료를 직접 변환한 결과다. <br/>


### ❌ ️주의
이런 활성 레코드에 `비즈니스 규칙 메서드를 추가해 이런 자료 구조를 객체로 취급하는 방법은 바람직 하지 않다.` 이러면 자료 구조도 아니고 객체도 아닌 잡종 구조가 나온다. <br/>

### ⭕️ 해결책
활성 레코드는 자료 구조로 취급한다. `비즈니스 규칙을 담으면서 내부 자료를 숨기는 객체는 따로 생성한다.` (여기서 내부 자료는 활성 레코드의 인스턴스 일 가능성이 높다.)

```java
class Person { //잡종 구조 
	private String name;
	private String email;

	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}
	

	public void sendEmail(){
        /**
         * 이메일 보내는 기능
         */
	}	
}



class EmailSender{ // 비즈니스 규칙 분리 
	private Person receiver;
    
	public void sendEmail() {
        /**
         * 이메일 보내는 기능
         */
	}
}
``` 
---

# 🚩 6장 정리

- 객체는 동작을 공개하고 자료를 숨긴다.
  - 기존 동작을 변경하지 않으면서 객체 타입을 추가하기는 쉽다.
  - 반면, 기존 객체에 새 동작을 추가하기는 어렵다.
- 자료 구조는 별다른 동작 없이 자료를 노출한다.
  - 기존 자료 구조에 새 동작을 추가하기는 쉽다.
  - 기존 메서드에 새 자료 구조를 추가하기는 어렵다.
- 시스템을 구현할 때, `새로운 자료 타입을 추가하는 유연성`이 필요하면 `객체가 더 적합하다.`
  - ✅ 객체 지향 설계를 하기 위해서는 동작 설계를 잘 해야 한다.
- 다른 경우로 `새로운 동작을 추가하는 유연성`이 필요하면 `자료구조와 절차적인 코드가 더 적합하다.`
  - ✅ 절₩ 지향 설계를 하기 위해서는 자료 타입 설계를 잘 해야 한다. 