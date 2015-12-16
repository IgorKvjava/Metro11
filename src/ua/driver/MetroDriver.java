package ua.driver;

/**
 * Created by liny on 15.12.15.
 */
public class MetroDriver implements Comparable<MetroDriver>{
    private double skill;
    private String name;
    @Override
    public String toString() {
        return "MetroDriver{" +
                "skill=" + skill +
                ", name='" + name +"\n";
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

        return Double.compare(this.skill,o.skill);
    }
    public void driverCompareSkills(MetroDriver metroDriver1,MetroDriver metroDriver2){
        MetroDriver metroDriverTime=metroDriver1;
        if (metroDriverTime.compareTo(metroDriver2)>0)
            System.out.println(metroDriver2);
        else System.out.println(metroDriver1);
    }

}
