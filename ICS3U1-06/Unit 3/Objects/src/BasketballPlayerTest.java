public class BasketballPlayerTest {

    public static void main(String[] args) {

        BasketballPlayer player1 = new BasketballPlayer("Lebron James", "Los Angeles Lakers",
                2.08, 6, 39);

        BasketballPlayer player2 = new BasketballPlayer("Michael Jordan", "Chicago Bulls",
                2.05, 23, 53);


        System.out.println(player1.toString());
        System.out.println(player2);    //implicit method call (calls .toString() anyways)

        player1.setTeam("Toronto Raptors");
        System.out.println(player1.getTeam());

    }

}
