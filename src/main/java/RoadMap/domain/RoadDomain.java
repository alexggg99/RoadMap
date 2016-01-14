package RoadMap.domain;

/**
 * Created by Alex on 14.01.2016.
 */
public class RoadDomain implements Road {

    private String name;
    private int length;
    private CityDomain cityDomain1;
    private CityDomain cityDomain2;

    public RoadDomain(String name, int length, CityDomain cityDomain1, CityDomain cityDomain2) {
        this.name = name;
        this.length = length;
        this.cityDomain1 = cityDomain1;
        this.cityDomain2 = cityDomain2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public City getCity1() {
        return cityDomain1;
    }

    public City getCity2() {
        return cityDomain2;
    }

    public CityDomain getCityDomain1() {
        return cityDomain1;
    }

    public void setCityDomain1(CityDomain cityDomain1) {
        this.cityDomain1 = cityDomain1;
    }

    public CityDomain getCityDomain2() {
        return cityDomain2;
    }

    public void setCityDomain2(CityDomain cityDomain2) {
        this.cityDomain2 = cityDomain2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoadDomain that = (RoadDomain) o;

        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
