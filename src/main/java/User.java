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
        try {
            System.out.println("Cuantos barcos quieres?(1 - 3)");
            int numShips = sc.nextInt();
            if (numShips < 1 || numShips > 3) throw new Exception();
            Ship[] ships = new Ship[numShips];
            for (int i = 0; i < numShips; i++) {
                Ship shipx = crearBarco(i);
                if (!collide(ships, shipx)) ships[i] = shipx;
                else {
                    System.out.println("Barco colisionado");
                    i--;
                }
            }
            return new User(ships);
        } catch (Exception e){
            System.out.println("Número de barcos no válido");
            return init();
        }
    }

    public static Ship crearBarco(int i){
        try {
            int size = elegirTamanio();
            System.out.println("Coordenada inicial X del barco " + (i + 1) + ":");
            int x = sc.nextInt();
            System.out.println("Coordenada inicial Y del barco " + (i + 1) + ":");
            int y = sc.nextInt();
            System.out.println("Orientación del barco (North, South, East, West) " + (i + 1) + ":");
            String orientation = sc.next();
            if (Ship.esPosicionValida(size, new Point(x, y), CardinalPoints.valueOf(orientation.toUpperCase()))) {
                if (size == 1) return new Canoa(new Point(x, y), CardinalPoints.valueOf(orientation.toUpperCase()));
                else if (size == 3) return new Fragata(new Point(x, y), CardinalPoints.valueOf(orientation.toUpperCase()));
                else return new Portaaviones(new Point(x, y), CardinalPoints.valueOf(orientation.toUpperCase()));
            } else {
                System.out.println("Posición no válida");
                return crearBarco(i);
            }
        } catch (Exception e){
            System.out.println("Orientacion no válida");
            return crearBarco(i);
        }
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

    public void attack (User enemy){
        try {
            System.out.println("Coordenada X del ataque (Entre 0 y 19):");
            int x = sc.nextInt();
            System.out.println("Coordenada Y del ataque (Entre 0 y 19):");
            int y = sc.nextInt();
            if (x < 0 || x > 19 || y < 0 || y > 19) throw new Exception();
            System.out.println("Atacando a las coordenadas (" + x + ", " + y + ")");
            enemy.get_Shot(new Point(x, y));
        } catch (Exception e){
            System.out.println("Coordenadas no válidas");
            attack(enemy);
        }
    }

    public static  boolean collide (Ship[] ships, Ship ship){
        boolean collide = false;
        for (int i = 0; i < 3; i++){
            if (ships[i] != null) {
                collide = ship.collide(ships[i]);
            }
        }
        return collide;
    }

    public void get_Shot (Point point){
        for(Ship ship : ships){
            ship.get_Shot(point);
        }
    }

    public boolean is_Alive (){
        boolean vivo = false;
        for(Ship ship : ships){
            if(!ship.is_Sunk()){
                vivo = true;
            }
        }
        if (!vivo)die();
        return vivo;
    }

    public void die (){
        alive = false;
    }

    public boolean getIsAlive() {
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
