package chapter6;

import java.util.Scanner;

public class Ttt {

    private char circle;
    private char ix;
    private String[][] game;
    private char userSymbol;
    private int win;

    public int getWin() {
        return win;
    }

    public char getUserSymbol() {
        return userSymbol;
    }

    public Ttt(char sym) {
        userSymbol = sym;
    }

    public Ttt() {
        this.circle = 'O';
        this.ix = 'X';
        this.game = new String[3][3];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                game[i][j] = " ";
            }
        }
    }

    public void setGame(String[][] game) {
        this.game = game;
    }

    public String[][] getGame() {
        return game;
    }

    public char getCircle() {
        return circle;
    }

    public char getIx() {
        return ix;
    }

    public void display() {
        System.out.println("   A   B   C");
        System.out.println("1  " + game[0][0] + " | " + game[0][1] + " | " + game[0][2] + "  ");
        System.out.println("  ```````````");
        System.out.println("2  " + game[1][0] + " | " + game[1][1] + " | " + game[1][2] + "  ");
        System.out.println("  ```````````");
        System.out.println("3  " + game[2][0] + " | " + game[2][1] + " | " + game[2][2] + "  ");
    }

    public String userIn() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Podaj pole");
        String pole = keyboard.nextLine();
        return pole;
    }

    public void areas(String user, char symbol) {
        if (user.equalsIgnoreCase("A1")) {
            game[0][0] = new String(game[0][0].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("A2")) {
            game[1][0] = new String(game[1][0].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("A3")) {
            game[2][0] = new String(game[2][0].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("B1")) {
            game[0][1] = new String(game[0][1].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("B2")) {
            game[1][1] = new String(game[1][1].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("B3")) {
            game[2][1] = new String(game[2][1].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("C1")) {
            game[0][2] = new String(game[0][2].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("C2")) {
            game[1][2] = new String(game[1][2].replace(' ', symbol));
        } else if (user.equalsIgnoreCase("C3")) {
            game[2][2] = new String(game[2][2].replace(' ', symbol));
        }
    }

    public void begin() {
        System.out.println("Gra w kółko i krzyżyk.");
        System.out.println("Najpierw wybierz swój symbol (\"O\" lub \"X\").");
        System.out.println("Następnie pole w którym chcesz go wstawić.");
    }

    public void symbol() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Wybierz swój symbol");
        String symbol = keyboard.nextLine();
        while (!((symbol.equalsIgnoreCase("X")) || (symbol.equalsIgnoreCase("O")))) {
            System.out.println("Podaj prawidłowy symbol");
            symbol = keyboard.nextLine();
        }
        if (symbol.equalsIgnoreCase("x")) {
            userSymbol = ix;
        } else {
            userSymbol = circle;
        }
    }

    public void comuterTurn(char symbol) {
        int i = 0;
        while (i == 0) {
            int turn = (int) (Math.random() * 9);
            switch (turn) {
                case 0:
                    if (isEmpty(game[0][0])) {
                        game[0][0] = new String(game[0][0].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 1:
                    if (isEmpty(game[1][0])) {
                        game[1][0] = new String(game[1][0].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 2:
                    if (isEmpty(game[2][0])) {
                        game[2][0] = new String(game[2][0].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 3:
                    if (isEmpty(game[0][1])) {
                        game[0][1] = new String(game[0][1].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 4:
                    if (isEmpty(game[1][1])) {
                        game[1][1] = new String(game[1][1].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 5:
                    if (isEmpty(game[2][1])) {
                        game[2][1] = new String(game[2][1].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 6:
                    if (isEmpty(game[0][2])) {
                        game[0][2] = new String(game[0][2].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 7:
                    if (isEmpty(game[1][2])) {
                        game[1][2] = new String(game[1][2].replace(' ', symbol));
                        i = 1;
                        break;
                    }
                case 8:
                    if (isEmpty(game[2][2])) {
                        game[2][2] = new String(game[2][2].replace(' ', symbol));
                        i = 1;
                        break;
                    }
            }
        }
    }

    private boolean isEmpty(String s) {
        if (s.equals(" ")) {
            return true;
        }
        return false;
    }

    public void winner() {
        if ((game[0][0].equalsIgnoreCase("x") && game[0][1].equalsIgnoreCase("x") &&
                game[0][2].equalsIgnoreCase("x")) || (game[1][0].equalsIgnoreCase("x") &&
                game[1][1].equalsIgnoreCase("x") && game[1][2].equalsIgnoreCase("x")) ||
                (game[2][0].equalsIgnoreCase("x") && game[2][1].equalsIgnoreCase("x") &&
                        game[2][2].equalsIgnoreCase("x")) || (game[0][0].equalsIgnoreCase("x")
                && game[1][0].equalsIgnoreCase("x") && game[2][0].equalsIgnoreCase("x")) ||
                (game[0][1].equalsIgnoreCase("x") && game[1][1].equalsIgnoreCase("x") &&
                        game[2][1].equalsIgnoreCase("x")) || (game[0][2].equalsIgnoreCase("x") &&
                game[1][2].equalsIgnoreCase("x") && game[2][2].equalsIgnoreCase("x")) ||
                (game[0][0].equalsIgnoreCase("x") && game[1][1].equalsIgnoreCase("x") &&
                        game[2][2].equalsIgnoreCase("x")) || (game[0][2].equalsIgnoreCase("x") &&
                game[1][1].equalsIgnoreCase("x") && game[2][0].equalsIgnoreCase("x"))) {
            win = 1;
        }
        if ((game[0][0].equalsIgnoreCase("o") && game[0][1].equalsIgnoreCase("o") &&
                game[0][2].equalsIgnoreCase("o")) || (game[1][0].equalsIgnoreCase("o") &&
                game[1][1].equalsIgnoreCase("o") && game[1][2].equalsIgnoreCase("o")) ||
                (game[2][0].equalsIgnoreCase("o") && game[2][1].equalsIgnoreCase("o") &&
                        game[2][2].equalsIgnoreCase("o")) || (game[0][0].equalsIgnoreCase("o")
                && game[1][0].equalsIgnoreCase("o") && game[2][0].equalsIgnoreCase("o")) ||
                (game[0][1].equalsIgnoreCase("o") && game[1][1].equalsIgnoreCase("o") &&
                        game[2][1].equalsIgnoreCase("o")) || (game[0][2].equalsIgnoreCase("o") &&
                game[1][2].equalsIgnoreCase("o") && game[2][2].equalsIgnoreCase("o")) ||
                (game[0][0].equalsIgnoreCase("o") && game[1][1].equalsIgnoreCase("o") &&
                        game[2][2].equalsIgnoreCase("o")) || (game[0][2].equalsIgnoreCase("o") &&
                game[1][1].equalsIgnoreCase("o") && game[2][0].equalsIgnoreCase("o"))) {
            win = 2;
        }
    }

    public boolean isvalid(String user) {
        while (!(user.equalsIgnoreCase("a1") || user.equalsIgnoreCase("a2") ||
                user.equalsIgnoreCase("a3") || user.equalsIgnoreCase("b1") ||
                user.equalsIgnoreCase("b2") || user.equalsIgnoreCase("b3") ||
                user.equalsIgnoreCase("c1") || user.equalsIgnoreCase("c2") ||
                user.equalsIgnoreCase("c3"))) {
            System.out.println("niewłaściwe pole");
            return false;
        }
        return true;
    }
}
