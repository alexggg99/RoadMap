package RoadMap.domain;

/**
 * Created by Alex on 14.01.2016.
 */
public class CityDomain implements City {

    private String name;
    private int x;
    private int y;

    public CityDomain(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityDomain cityDomain = (CityDomain) o;

        return name.equals(cityDomain.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
