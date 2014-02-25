
public class Gamer {

    private String name = new String();

    private char figure;

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
}
