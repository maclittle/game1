package game1;

public class Player {

    Posn position;

    Player(Posn position) {
        this.position = position;
    }

    public Player movePlayerLeft() {
        return new Player(position.x - 5, position.y);
    }

    public Player movePlayerRight() {
        return new Player(position.x + 5, position.y);
    }

    public Boolean atLeftHuh() {
        return this.position.x == 0;
    }

    public Boolean atRightHuh() {
        return this.position.x == 500;
    }

}
