import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @org.junit.jupiter.api.Test
    void is_Sunk_Get_Shot() {
        Ship ship = new Ship(3, new int[]{1, 1}, CardinalPoints.NORTH);
        ship.get_Shot(1, 1);
        ship.get_Shot(1, 2);
        ship.get_Shot(1, 3);
        assertTrue(ship.is_Sunk());
    }

    @org.junit.jupiter.api.Test
    void on_Ship() {
        Ship ship = new Ship(3, new int[]{1, 1}, CardinalPoints.NORTH);
        assertTrue(ship.on_Ship(1, 1));
        assertTrue(ship.on_Ship(1, 2));
        assertTrue(ship.on_Ship(1, 3));
    }
}