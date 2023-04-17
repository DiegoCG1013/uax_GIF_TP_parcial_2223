import java.util.ArrayList;

public class Battleship extends Ship {
    ArrayList<Point> puntos = new ArrayList<>();
    public Battleship(Point punto_Partida, CardinalPoints orientacion) {
        super(5, punto_Partida, orientacion);
    }

    @Override
    public void get_Shot(Point point) {
        if (punto_Partida.x == point.x && punto_Partida.y == point.y && !puntos.contains(point)){
            System.out.println("¡Tocado!");
            puntos.add(point);
            vida--;
        }
    }
}