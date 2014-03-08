import java.util.Scanner;

public class Gamer {

    private String name = new String();

    private char figure;

    private int[] cellCoord = new int[2];

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public void setFigure(char figure) {

        this.figure = 'x';

        if (figure == '0' || figure == 'o')
            this.figure = 'o';
    }

    public char getFigure() {

        return figure;

    }

    public int[] setCell(Field field) {

        int[] coord = new int[2];
        Scanner input=new Scanner(System.in);

        System.out.println("Gamer " + getName());
        System.out.println("input i:");
        coord[0] = input.nextInt();
        System.out.println("input j:");
        coord[1] = input.nextInt();

        return coord;

    }
}
