package Quarter;

import javafx.scene.layout.Pane;

public abstract class Quarter {

    //Construction cost, consumption, upgrade cost, variable
    protected int level;
    protected int maxLevel;
    protected int crew;

    protected int[] maxCrew;
    protected int[] bitCost;
    protected int[] codeDataCost;
    protected int[] cryptomoneyCost;
    protected int[] electricityConsumption;

    protected long[] production;

    protected Pane infoPane = new Pane();

    protected String style;
    protected String selectedStyle;

    protected String name;

    protected int x;
    protected int y;


    public Quarter() {
        infoPane.setPrefSize(200,500);
        infoPane.setLayoutX(1340);
        infoPane.setLayoutY(50);
        production[0]=0;
    }


    public int getCrew() {
        return crew;
    }

    public int getLevel() {
        return level;
    }

    public void crewUp() {
        if (crew<maxCrew[level-1]) {
            crew++;
        }
    }

    public void crewDown() {
        crew--;
    }

    public void upgrade() {
        //RAJOUTER SI LOCK PAR TECH
        level++;
    }

    public long getCryptomoneyConsumption() {
        return 1;
    }


    public void setX(int xPos) {
        x=xPos;
    }

    public void setY(int yPos) {
        y=yPos;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Test functions
    public int getMaxCrew() {
        return maxCrew[level-1];
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getCodeDataCost() {
        return codeDataCost[level-1];
    }

    public int getBitCost() {
        return bitCost[level-1];
    }

    public int getCryptomoneyCost() {
        return cryptomoneyCost[level-1];
    }

    public int getElectricityConsumption() {
        return electricityConsumption[level-1];
    }

    public Pane getInfoPane() {
        return infoPane;
    }

    public String getStyle() {
        return style;
    }

    public String getSelectedStyle() {
        return selectedStyle;
    }

    public long[] getProduction() {
        return production;
    }

    public abstract void adjacentBonuses(Quarter adjQuarter);

    public String getName() {
        return name;
    }
}
