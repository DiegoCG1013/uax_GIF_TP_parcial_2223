import java.util.Scanner;

public class User {
    private boolean alive;
    private Ship[] ships;
    private static Scanner sc = new Scanner(System.in);

    public User(Ship[] ships) {
        this.ships = ships;
        alive = true;
    }

    public static User init (){
        //Programa inicial para crear un usuario, pidiendo los barcos
        Ship[] ships = {null, null, null};
        System.out.println("Cuantos barcos quieres?(1 - 3)");
        int numShips = sc.nextInt();
        for (int i = 0; i < numShips; i++) {
            int size = elegirTamanio();
            System.out.println("Coordenada inicial X del barco " + (i + 1) + ":");
            int x = sc.nextInt();
            System.out.println("Coordenada inicial Y del barco " + (i + 1) + ":");
            int y = sc.nextInt();
            System.out.println("Orientación del barco (North, South, East, West) " + (i + 1) + ":");
            String orientation = sc.next();
            ships[i] = new Ship(size, new Point(x, y), CardinalPoints.valueOf(orientation.toUpperCase()));
        }
        return new User(ships);
    }

    public static int elegirTamanio(){
        System.out.println("Elige el tamaño del barco (1, 3 o 5):");
        try {
            int size = sc.nextInt();
            if (size == 1 || size == 3 || size == 5) {
                return size;
            } else {
                System.out.println("Tamaño no válido");
                return elegirTamanio();
            }
        } catch (Exception e){
            System.out.println("Tamaño no válido");
            return elegirTamanio();
        }

    }

    public void attack (){

    }

    public void get_Shot (Point point){
        for(Ship ship : ships){
            ship.get_Shot(point);
        }
    }

    public void is_Alive (){
        boolean vivo = false;
        for(Ship ship : ships){
            if(!ship.is_Sunk()){
                vivo = true;
            }
        }
        if (!vivo)die();
    }

    public void die (){
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Ship[] getShips() {
        return ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }
}
