/*
 * 
 * This class will holde all the information of the map and will have approperiate
 * methods to perform diffrent tasks on map.
 */
package bomborman;


public class Map {
    
    private int rows, cols;
    private MapBasicBlock[][] map; 
    
    public Map(int _rows, int _cols){
        rows = _rows;
        cols = _cols;
        map = new MapBasicBlock[rows][cols];
    }
    
    
}
