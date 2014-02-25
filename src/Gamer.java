
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

        if (figure == 'x' || figure == '0')
            this.figure = figure;
        else
            this.figure = 'x';
    }

    public char getFigure() {

        return figure;

    }
}
