package ua.driver;

/**
 * Created by liny on 15.12.15.
 */
public class MetroDriver implements Comparable<MetroDriver>{
    private double skill;
    private String name;
    @Override
    public String toString() {
        return "  " +
                " skill=" + skill +
                "  name - '" + name +"\n";
    }

    public MetroDriver(double skill, String name) {
        this.skill = skill;
        this.name = name;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(MetroDriver o) {

        return Double.compare(o.skill,this.skill);
    }


}
