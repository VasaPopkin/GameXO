import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){

        int i,size, maxCountOfSteps, line, row, menuLine;
        boolean gmr = true;
        int[] cellCoords = new int[2];

        Scanner input=new Scanner(System.in);
        Field gameField;
        System.out.println("input size of game field:");
        size = input.nextInt();
        gameField = new Field(size);
        maxCountOfSteps = size * size;
        gameField.fillField();
        gameField.printField();

        Gamer gamerx;

        Gamer gamer1 = new Gamer();
        Gamer gamer2 = new Gamer();

        menuLine = menu();

        System.out.println();
        System.out.println("Gamer 1: ");
        inputGamerName(gamer1);

        if (menuLine == 0){

            System.out.println();
            System.out.println("Gamer 2: ");
            inputGamerName(gamer2);
        }
        else {

            gamer2 = new Comp();

        }

        gamer1.setFigure('x');
        gamer2.setFigure('0');


        for (i = 0; i < maxCountOfSteps; i++){
            for (int j = 0; j<30; j++)
            System.out.println();

            if (gmr)
                gamerx = gamer1;
            else
                gamerx = gamer2;

            gameField.printField();

             cellCoords = gamerx.setCell(gameField);

            if (gameField.setCell(--cellCoords[0], --cellCoords[1], gamerx.getFigure()))
            {
            gmr = !gmr;
            }
            if (gameField.checkForAWin()){

                gameField.printField();
                System.out.println(gamerx.getName() + " wins!");
                break;
            }


        }

        if (i == maxCountOfSteps){

            gameField.printField();
            System.out.println("Draw");
        }
    }



    public static void inputGamerName(Gamer gamer){

        Scanner input=new Scanner(System.in);
        System.out.print("input name: ");
        gamer.setName(input.next());

    }

    public static int menu(){

        int i;
        final int MIN_MENU_VAL = 0;
        final int MAX_MENU_VAL = 1;
        Scanner input=new Scanner(System.in);
        while (true){

        System.out.println();
        System.out.println("0: PvP");
        System.out.println("1: PvC");

        i = input.nextInt();

        if ((i >= MIN_MENU_VAL) && (i <= MAX_MENU_VAL) )
            break;

        }

        return i;
    }
}
