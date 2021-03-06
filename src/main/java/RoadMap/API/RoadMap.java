package RoadMap.API;

import RoadMap.domain.City;
import RoadMap.domain.Road;

import java.util.List;

/**
 * Created by Alex on 14.01.2016.
 */
public interface RoadMap {
    public City addCity(String name, int x, int y);
    public Road addRoad(String name, int length, String cityName1, String cityName2);
    public Road deleteRoad(String name);
    public City getCityByName(String name);
    public List<Road> getRoadListByCityName(String name);
}
