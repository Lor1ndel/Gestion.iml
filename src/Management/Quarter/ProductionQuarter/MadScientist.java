package Management.Quarter.ProductionQuarter;

import Management.Quarter.Quarter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class wraps the property of a MadScientist.
 */
public class MadScientist extends ProductionQuarter{

    //production[0VirtualQuantumComputer, 1VirtualQuantumComputer, 2ParadoxalGenerator, 3ParadoxalGenerator, 4TemporalCamboose, 5TemporalCamboose,
    //6IaSynthesisTank, 7IaSynthesisTank, 8DataCentre, 9DataCentre, 10DimensionlessSpace, 11dimensionlessSpace, 12Probawin, 13Probawin, 14Probalose, 15Probalose]
    /**
     * Creates a new instance of MadScientist.
     * @param level the level of the quarter
     */
    public MadScientist(int level) {

        super(level);
        name = "Mad Scientist's Lab";
        trueName = "MadScientist";
        quarterIcon = new ImageView(new Image("madScientistIcon.png"));
        selectedQuarterIcon = new ImageView(new Image("selectedMadScientistIcon.png"));
        indexConstructionPane = new int[]{1, 0, 1};
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
            case "MadScientist" -> {
                double rnd = Math.random();
                if (rnd < 0.2) {
                    productionPerCrewBonusRate += (0.6 - 0.2 * (level-adjQuarter.getLevel())) * adjQuarter.getCrew();
                } else if (rnd >= 0.4) {
                    productionPerCrewBonusRate -= (0.9 - 0.3 * (level-adjQuarter.getLevel())) * adjQuarter.getCrew();
                }
            }
            case "Berth" -> productionPerCrewBonusRate -= 0.1*adjQuarter.getLevel();
            case "VirtualQuantumComputer" -> productionPerCrewBonusRate += 0.2;
            case "HellishBoss" -> productionPerCrewBonusRate -= 0.5*adjQuarter.getCrew();
            case "CryptoInvestor" -> productionPerCrewBonusRate -= 0.05*adjQuarter.getCrew();
        }
    }
}
