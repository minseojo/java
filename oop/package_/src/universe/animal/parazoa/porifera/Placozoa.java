package universe.animal.parazoa.porifera;

import universe.animal.parazoa.Parazoa;
import universe.animal.parazoa.WaterRelationshipStructure;

public class Placozoa extends Parazoa {

    private final WaterRelationshipStructure waterRelationshipStructure;

    public Placozoa(int weight, WaterRelationshipStructure waterRelationshipStructure) {
        super(weight);
        this.waterRelationshipStructure = waterRelationshipStructure;
    }

}
