package universe.animal.parazoa;

import universe.animal.Animal;
import universe.animal.feature.Breathable;
import universe.animal.feature.Moveable;

public class Parazoa extends Animal implements Breathable, Moveable {


    public Parazoa(int weight) {
        super(weight);
    }

    @Override
    public void breath() {
        // 물에서 숨쉬기
    }

    @Override
    public void move() {
        // 물에서 떠 다니기
    }
}
