package Task3;

import java.util.ArrayList; 
import Task3.Line.Position;

public class Monster implements Linable {

    static ArrayList<Monster> values = new ArrayList<Monster>();
    
    private final int r;
    private final int g;
    private final int b;

    private Position position;

    public Monster(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        values.add(this);
    }

    public int rank() {
        return (this.r<<16)+(this.g<<8)+this.b;
    }

    public static Monster getMonsterByRank(int rank) {

        for (Monster monster : Monster.values) {
            if (monster.rank() == rank) {
                return monster;
            }
        }
        return null;

    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + values.indexOf(this)+ "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getValue() {
        return this.rank();
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

}
