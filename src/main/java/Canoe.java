public class Canoe extends Ship {
    public Canoe(Point punto_Partida, CardinalPoints orientacion) {
        super(1, punto_Partida, orientacion);
    }

    @Override
    public void get_Shot(Point point) {
        if (punto_Partida.x == point.x && punto_Partida.y == point.y){
            System.out.println("¡Tocado!");
            vida--;
        }
    }
}