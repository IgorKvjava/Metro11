package ua.depo;

/**
 * Created by univer3 on 12/12/2015.
 */
public class DepoVagon {
    private String nameVagon;
    private boolean mainVagon;

    public DepoVagon(String nameVagon, boolean mainVagon) {
        this.nameVagon = nameVagon;
        this.mainVagon = mainVagon;
    }

    public String getNameVagon() {
        return nameVagon;
    }

    public void setNameVagon(String nameVagon) {
        this.nameVagon = nameVagon;
    }

    public boolean isMainVagon() {
        return mainVagon;
    }

    public void setMainVagon(boolean mainVagon) {
        this.mainVagon = mainVagon;
    }

    @Override
    public String toString() {
        return "DepoVagon{" +
                "nameVagon='" + nameVagon + '\'' +
                ", mainVagon=" + mainVagon +
                '}'+"\n";
    }
}
