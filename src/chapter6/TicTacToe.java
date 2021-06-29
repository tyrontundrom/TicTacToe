package chapter6;

public class TicTacToe {
    public static void main(String[] args) {
        Ttt ttt = new Ttt();
        char comp;
        ttt.begin();
        ttt.symbol();
        System.out.println("Twój symbol to " + "\"" + ttt.getUserSymbol() + "\"");
        if (ttt.getUserSymbol() == 'X') {
            System.out.println("Komputer ma symbol " + "\"" + ttt.getCircle() + "\"");
            comp = ttt.getCircle();
        } else {
            System.out.println("Komputer ma symbol " + "\"" + ttt.getIx() + "\"");
            comp = ttt.getIx();
        }
        ttt.display();
        String s;
        int x = 0;
        while (ttt.getWin() == 0) {
            s = ttt.userIn();
            if (ttt.isvalid(s) == false) {
                s = ttt.userIn();
            }
            ttt.areas(s, ttt.getUserSymbol());
            System.out.println("twój ruch");
            ttt.display();
            ttt.comuterTurn(comp);
            System.out.println("Ruch komputera");
            ttt.display();
            ttt.winner();
        }
        System.out.println("Koniec gry");
        if ((ttt.getWin() == 1 && ttt.getUserSymbol() == 'X') || (ttt.getWin() == 2 && ttt.getUserSymbol() == 'O')) {
            System.out.println("Gratulacje! Wygraleś.");
        } else if ((ttt.getWin() == 1 && comp == 'X') || (ttt.getWin() == 2 && comp == 'O')) {
            System.out.println("Komputer wygrywa.");
        }
    }
}
