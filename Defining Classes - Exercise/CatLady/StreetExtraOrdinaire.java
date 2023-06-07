package DefiningClasses_Exercise._X_CatLady;

public class StreetExtraOrdinaire extends Cat {
    private double decibelsOfMeows;

    public StreetExtraOrdinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", getName(), decibelsOfMeows);
    }
}
