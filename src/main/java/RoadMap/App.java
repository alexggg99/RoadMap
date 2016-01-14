package RoadMap;

import RoadMap.API.RoadMap;
import RoadMap.API.RoadMapImpl;
import RoadMap.domain.City;
import RoadMap.domain.Road;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RoadMap roadMap = new RoadMapImpl();
        City city1 = roadMap.addCity("T9", 0 , 0);
        City city2 = roadMap.addCity("T10", 0 , 0);
        City city3 = roadMap.addCity("T11", 0 , 0);
        Road road1 = roadMap.addRoad("R9", 10, "T9", "T10");
        Road road2 = roadMap.addRoad("R10", 12, "T11", "T10");
        List<Road> roadList = roadMap.getRoadListByCityName("T9");
    }
}
