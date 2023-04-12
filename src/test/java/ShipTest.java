import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @org.junit.jupiter.api.Test
    void is_Sunk_Get_Shot() {
        Ship ship = new Ship(3, new Point(1, 1), CardinalPoints.SOUTH);
        ship.get_Shot(new Point(1, 1));
        ship.get_Shot(new Point(1, 2));
        ship.get_Shot(new Point(1, 3));
        assertTrue(ship.is_Sunk());
    }

    @org.junit.jupiter.api.Test
    void on_Ship() {
        Ship ship = new Ship(3, new Point(1, 1), CardinalPoints.SOUTH);
        assertTrue(ship.on_Ship(new Point(1, 1)));
        assertTrue(ship.on_Ship(new Point(1, 2)));
        assertTrue(ship.on_Ship(new Point(1, 3)));
    }

    @org.junit.jupiter.api.Test
    void esPosicionValida(){
        //Test
        assertTrue(Ship.esPosicionValida(3, new Point(1, 1), CardinalPoints.SOUTH));
        assertFalse(Ship.esPosicionValida(3, new Point(1, 1), CardinalPoints.NORTH));
        assertTrue(Ship.esPosicionValida(3, new Point(1, 1), CardinalPoints.EAST));
    }
}