/*
 * This class assist in handling with the positions of diffrent objects. 
 */
package bomborman;




public class Position {
    
    private int row, col;
    
    public Position(int _row, int _col){
        row = _row;
        col = _col;
    }
    
    public boolean equals(Position position){
    
        if( position.getColumn() == col && position.getRow() == row){
            return true;
        }else{
            return false;
        }
    }
    
    public int getColumn(){ return col;}
    
    public int getRow(){ return row;}
    
    public void setPosition(Position position){
    
            row = position.getRow();
            col = position.getColumn();
    }
    
    public void setPosition(int _row, int _col){
    
            row = _row;
            col = _col;
    }
    
}
