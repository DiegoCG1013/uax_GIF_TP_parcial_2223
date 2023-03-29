public class Ship {

    protected int tamanio;
    protected int vida;
    protected int[] punto_Partida = new int[2];
    CardinalPoints orientacion;

    public Ship(int tamanio, int[] punto_Partida, CardinalPoints orientacion) {
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

    public int[] getPunto_Partida() {
        return punto_Partida;
    }

    public void setPunto_Partida(int[] punto_Partida) {
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

    public void get_Shot(int x, int y){
        if (on_Ship(x, y)){
            vida--;
        }
    }

    public boolean on_Ship(int x, int y){
        int[] shot = {x, y};
        if (orientacion == CardinalPoints.NORTH || orientacion == CardinalPoints.SOUTH){
            if(shot[0] == punto_Partida[0]){
                if (shot[1] >= punto_Partida[1] && shot[1] <= punto_Partida[1] + tamanio * orientacion.getMovimiento()){
                    return true;
                }
            }
        } else {
            if(shot[1] == punto_Partida[1]){
                if (shot[0] >= punto_Partida[0] && shot[0] <= punto_Partida[0] + tamanio * orientacion.getMovimiento()){
                    return true;
                }
            }
        }
        return false;
    }

}
