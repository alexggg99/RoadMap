package API;

import domain.City;
import domain.Road;

import java.util.List;

/**
 * Created by Alex on 14.01.2016.
 */
public interface RoadMap {
    public City addCity(String name, int x, int y);
    public Road addRoad(String name, int length, City city1, City city2);
    public Road deleteRoad(String name);
    public City getCityByName(String name);
    public List<City> getRoadListByCityName(String name);
}
