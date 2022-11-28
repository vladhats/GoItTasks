package HW11;

public class Compound {
    private String name;
    private Double energy;

    public Compound(String name, Double energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "Compound{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                '}';
    }
}
