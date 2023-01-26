package units;

public class Position {
    public byte x,y;

    public Position(byte x, byte y){
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Position position){
        return (position.x == this.x && position.y == this.y);
    }
}
