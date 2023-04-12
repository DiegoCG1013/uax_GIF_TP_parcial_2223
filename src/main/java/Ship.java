public class Ship {

    protected int tamanio;
    protected int vida;
    protected Point punto_Partida;
    CardinalPoints orientacion;

    public Ship(int tamanio, Point punto_Partida, CardinalPoints orientacion) {
        this.tamanio = tamanio;
        vida = tamanio;
        this.punto_Partida = punto_Partida;
        this.orientacion = orientacion;
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

}
