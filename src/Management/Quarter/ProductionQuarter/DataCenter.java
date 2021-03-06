package Management.Quarter.ProductionQuarter;

import Management.Quarter.Quarter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class wraps the property of a DataCenter.
 */
public class DataCenter extends ProductionQuarter {

    //production[7science,science]
    /**
     * Creates a new instance of DataCenter.
     * @param level the level of the quarter
     */
    public DataCenter(int level) {

        super(level);
        name = "Data Center";
        trueName = "DataCenter";
        quarterIcon = new ImageView(new Image("dataCenterIcon.png"));
        selectedQuarterIcon = new ImageView(new Image("selectedDataCenterIcon.png"));
        indexConstructionPane = new int[]{0, 0, 2};
        loadAllValues();
        loadConstructionInfoPaneValue();
    }
    /**
     * Computes the bonus inherited from some specific adjacent quarter.
     * @param adjQuarter an adjacent quarter
     */
    @Override
    public void adjacentBonuses(Quarter adjQuarter) {
        switch (adjQuarter.getTrueName()) {
            case "Datacenter" -> productionBonusConstant += 2 * level * crew;
            case "Berth" -> productionPerCrewBonusRate += 0.05 * adjQuarter.getLevel();
            case "MadScientist" -> {
                double rnd = Math.random();
                if (rnd < 0.3) {
                    productionBonusConstant += adjQuarter.getProduction()[1];
                } else if (rnd >= 0.9) {
                    productionBonusConstant -= adjQuarter.getProduction()[1];
                }
            }
            case "InternetFiberProvider" -> {
                double rnd = Math.random();
                if (rnd > 80 + 5 * adjQuarter.getLevel()) {
                    productionBonusRate -= 0.5;
                } else {
                    productionBonusRate += 0.05 * adjQuarter.getCrew();
                }
            }
            case "VirtualQuantumComputer" -> productionBonusRate += 0.1*adjQuarter.getCrew();
        }
    }
}
