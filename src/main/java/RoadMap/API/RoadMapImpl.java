package RoadMap.API;


import RoadMap.domain.City;
import RoadMap.domain.CityDomain;
import RoadMap.domain.Road;
import RoadMap.domain.RoadDomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alexggg99 on 14.01.16.
 */
public class RoadMapImpl implements RoadMap {

    private HashMap<String, CityDomain> cityHashMap = new HashMap<String, CityDomain>();
    private HashMap<String, RoadDomain> roadHashMap = new HashMap<String, RoadDomain>();

    public City addCity(String name, int x, int y) {
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("no name argument");
        }
        CityDomain city = cityHashMap.get(name);
        if(city == null){
            city = new CityDomain(name, x, y);
            cityHashMap.put(name, city);
        }else{
            throw new RuntimeException("duplicate city");
        }
        return city;
    }

    public Road addRoad(String name, int length, String cityName1, String cityName2) {
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("no name argument");
        }
        RoadDomain roadDomain = roadHashMap.get(name);
        if(roadDomain != null){
            throw new RuntimeException("duplicate road");
        }
        if(cityName1.equals(cityName2)) {
            throw new RuntimeException("cities are equal");
        }
        CityDomain city1 = cityHashMap.get(cityName1);
        CityDomain city2 = cityHashMap.get(cityName2);
        if(city1 == null || city2 == null){
            throw new IllegalArgumentException("city does not exist");
        }
        RoadDomain road = new RoadDomain(name, length, city1, city2);
        roadHashMap.put(name, road);
        return road;
    }

    public Road deleteRoad(String name) {
        return roadHashMap.remove(name);
    }

    public City getCityByName(String name) {
        return cityHashMap.get(name);
    }

    public List<Road> getRoadListByCityName(String name) {
        if(name == null || name.equals("")){
            throw new IllegalArgumentException("no name argument");
        }
        List<Road> roadList = new ArrayList<Road>();
        for(Map.Entry<String, RoadDomain> entry : roadHashMap.entrySet()){
            String roadName = entry.getKey();
            RoadDomain roadDomain = entry.getValue();
            if(roadDomain.getCity1().getName().equals(name) ||
                    roadDomain.getCity2().getName().equals(name)){
                roadList.add(roadDomain);
            }
        }
        return roadList;
    }

}
