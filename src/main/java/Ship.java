public class Ship {

    protected int tamanio;
    protected int vida;
    protected Point punto_Partida;
    CardinalPoints orientacion;
    //Incluyo aqui el tamaño del tablero, se podria poner en cualquier otro lado
    protected static final int BOARD_SIZE = 20;

    public Ship(int tamanio, Point punto_Partida, CardinalPoints orientacion) {
        this.tamanio = tamanio;
        vida = tamanio;
        this.punto_Partida = punto_Partida;
        this.orientacion = orientacion;
    }

    //Metodo para saber si con la orientacion y el punto de partida se puede colocar el barco
    public static boolean esPosicionValida(int tamanio, Point punto_Partida, CardinalPoints orientacion){
        if (punto_Partida.x < 0 || punto_Partida.y < 0 || punto_Partida.x > BOARD_SIZE || punto_Partida.y > BOARD_SIZE) return false;
        Point puntoFinal;
        if (orientacion == CardinalPoints.NORTH || orientacion == CardinalPoints.SOUTH){
            puntoFinal = new Point(punto_Partida.x, punto_Partida.y + ((tamanio - 1) * orientacion.getMovimiento()));
        } else {
            puntoFinal = new Point(punto_Partida.x + ((tamanio - 1) * orientacion.getMovimiento()), punto_Partida.y);
        }
        return puntoFinal.x >= 0 && puntoFinal.y >= 0 && puntoFinal.x < BOARD_SIZE && puntoFinal.y < BOARD_SIZE;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Point getPunto_Partida() {
        return punto_Partida;
    }

    public void setPunto_Partida(Point punto_Partida) {
        this.punto_Partida = punto_Partida;
    }

    public CardinalPoints getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(CardinalPoints orientacion) {
        this.orientacion = orientacion;
    }

    public boolean is_Sunk(){
        return vida == 0;
    }

    public void get_Shot(Point point){
        if (on_Ship(point)){
            System.out.println("¡Tocado!");
            vida--;
        }
    }

    public boolean on_Ship(Point point){
        int[] shot = {point.x, point.y};
        if (orientacion == CardinalPoints.NORTH || orientacion == CardinalPoints.SOUTH){
            if(shot[0] == punto_Partida.x){
                if (shot[1] >= punto_Partida.y && shot[1] <= punto_Partida.y + tamanio * orientacion.getMovimiento()){
                    return true;
                }
            }
        } else {
            if(shot[1] == punto_Partida.y){
                if (shot[0] >= punto_Partida.x && shot[0] <= punto_Partida.x + tamanio * orientacion.getMovimiento()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean collide (Ship ship){
        if (orientacion == CardinalPoints.NORTH || orientacion == CardinalPoints.SOUTH){
            if (ship.getPunto_Partida().x == punto_Partida.x){
                if (ship.getPunto_Partida().y >= punto_Partida.y && ship.getPunto_Partida().y <= punto_Partida.y + tamanio * orientacion.getMovimiento()){
                    return true;
                }
            }
        } else {
            if (ship.getPunto_Partida().y == punto_Partida.y){
                if (ship.getPunto_Partida().x >= punto_Partida.x && ship.getPunto_Partida().x <= punto_Partida.x + tamanio * orientacion.getMovimiento()){
                    return true;
                }
            }
        }
        return false;
    }

}
