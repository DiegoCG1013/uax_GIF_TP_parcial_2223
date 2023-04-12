public class Main {
    public static void main(String[] args) {
        User usuario = User.init();
        System.out.println(usuario.getShips()[0].getTamanio());
    }
}
