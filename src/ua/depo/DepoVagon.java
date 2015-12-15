package ua.depo;

/**
 * Created by univer3 on 12/12/2015.
 */
public class DepoVagon {
    private String nameVagon;
    private boolean typeVagon;

    public DepoVagon(String nameVagon, boolean mainVagon) {
        this.nameVagon = nameVagon;
        this.typeVagon = mainVagon;
    }

    public String getNameVagon() {
        return nameVagon;
    }

    public void setNameVagon(String nameVagon) {
        this.nameVagon = nameVagon;
    }

    public boolean isTypeVagon() {
        return typeVagon;
    }

    public void setTypeVagon(boolean typeVagon) {
        this.typeVagon = typeVagon;
    }

    @Override
    public String toString() {
        return "DepoVagon -- " +
                "nameVagon - " + nameVagon +
                " typeVagon - " + typeVagon +"\n";
    }
}
