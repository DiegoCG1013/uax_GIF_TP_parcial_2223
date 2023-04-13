public class Main {
    public static void main(String[] args) {
        inicio();
    }

    private static void inicio (){
        System.out.println("----------INICIO USER 1----------");
        User user1 = User.init();
        System.out.println("----------INICIO USER 2----------");
        User user2 = User.init();
        while (user1.is_Alive()){
            System.out.println("-------------TURNO USER 1-------------");
            user1.attack(user2);
            if (!user2.is_Alive()) break;
            System.out.println("-------------TURNO USER 2-------------");
            user2.attack(user1);
        }
        if (user1.getIsAlive()) System.out.println("El ganador es el jugador 1");
        else System.out.println("El ganador es el jugador 2");
    }
}
