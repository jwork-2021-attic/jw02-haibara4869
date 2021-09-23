package Task3;

public class Line {

    class Position {

        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    private int row,col;
    private Position[] positions;

    public Line(int row, int col) {
        this.row = row;
        this.col = col;
        this.positions = new Position[row*col];
    }

    public void put(Linable linable, int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(linable);
    }

    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }

    @Override
    public String toString() {
        String lineString = "\t";
        for (int i = 0;i<this.row;i++) {
            for(int j = 0;j<this.col;j++){
                lineString += this.positions[i*this.col+j].linable.toString();
            }
            lineString += "\n";
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }
}
