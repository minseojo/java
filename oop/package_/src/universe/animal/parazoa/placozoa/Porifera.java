package universe.animal.parazoa.placozoa;

import universe.animal.parazoa.Parazoa;
import universe.animal.parazoa.WaterRelationshipStructure;

public class Porifera extends Parazoa {

    private final WaterRelationshipStructure waterRelationshipStructure;
    private int myFiled;

    public Porifera(int weight, int myFiled, WaterRelationshipStructure waterRelationshipStructure) {
        super(weight);
        this.myFiled = myFiled;
        this.waterRelationshipStructure = waterRelationshipStructure;
    }

    public void MyFeature() {
        return;
    }
}
