package RoadMap.API;

import RoadMap.domain.City;
import RoadMap.domain.CityDomain;
import RoadMap.domain.Road;
import RoadMap.domain.RoadDomain;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by alexggg99 on 14.01.16.
 */

public class RoadMapTest {

    private RoadMap roadMap;

    @Before
    public void setUp() throws Exception {
        roadMap = new RoadMapImpl();
        City city1 = roadMap.addCity("T9", 0 , 0);
        City city2 = roadMap.addCity("T10", 0 , 0);
        City city3 = roadMap.addCity("T11", 0 , 0);
        Road road1 = roadMap.addRoad("R9", 10, "T9", "T10");
        Road road2 = roadMap.addRoad("R10", 12, "T11", "T10");
    }

    @Test
    public void testAddCityPositive(){
        City city = roadMap.addCity("T15", 0 , 0);
        assertNotNull(city);
        assertEquals("T15", city.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCityNegative1() throws Exception {
        City city = roadMap.addCity("", 0 , 0);
        City city2 = roadMap.addCity(null, 0 , 0);
    }

    @Test(expected = RuntimeException.class)
    public void testAddCityNegative2() throws Exception {
        City city = roadMap.addCity("T10", 0 , 0);
    }

    @Test
    public void testAddRoadPositive() {
        Road road = roadMap.addRoad("R15", 0, "T9", "T10");
        assertNotNull(road);
        assertEquals("R15", road.getName());
    }

    @Test(expected = RuntimeException.class)
    public void testAddRoadNegative1() throws Exception {
        Road road = roadMap.addRoad("R15", 0, "T9", "T9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRoadNegative2() throws Exception {
        Road road = roadMap.addRoad("R15", 0, "T9", "T99");
    }

    @Test
    public void testDeleteRoadPositive1(){
        Road road = roadMap.deleteRoad("R9");
        assertNotNull(road);
        assertEquals("R9", road.getName());
    }

    @Test
    public void testDeleteRoadPositive2(){
        Road road = roadMap.deleteRoad("R99");
        assertNull(road);
    }

    @Test
    public void testGetCityByName1(){
        City city = roadMap.getCityByName("T9");
        assertNotNull(city);
        assertEquals("T9", city.getName());
    }

    @Test
    public void testGetCityByName2(){
        City city = roadMap.getCityByName("T99");
        assertNull(city);
    }

    @Test
    public void testGetCityByNameMockito(){
        City city = new CityDomain("T500", 0, 0);
        RoadMap roadMapMock = Mockito.mock(RoadMap.class);
        when(roadMapMock.getCityByName("T500")).thenReturn(city);
        assertEquals(city.getName(), roadMapMock.getCityByName("T500").getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetRoadListByCityName1() throws Exception {
        List<Road> roadList = roadMap.getRoadListByCityName(null);
    }

    @Test
    public void testGetRoadListByCityName2(){
        List<Road> roadList = roadMap.getRoadListByCityName("T99");
        assertEquals(0, roadList.size());
    }

    @Test
    public void testGetRoadListByCityName3(){
        List<Road> roadList = roadMap.getRoadListByCityName("T9");
        assertEquals(1, roadList.size());
        assertEquals("R9", roadList.get(0).getName());
    }

}