public class FilmManager {
    private String[] films;
    private int lastFilmsCountToShow;

    public int getLastFilmsCountToShow() {
        return lastFilmsCountToShow;
    }

    public FilmManager(int lastFilmsCountToShow) {
        this.lastFilmsCountToShow = lastFilmsCountToShow;

        films = new String[0];
    }

    public FilmManager() {
        this.lastFilmsCountToShow = 5;

        films = new String[0];
    }

    public void add(String filmName) {
        String[] tmp = new String[films.length + 1];

        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }

        tmp[tmp.length - 1] = filmName;

        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength;

        if (films.length > lastFilmsCountToShow) {
            resultLength = lastFilmsCountToShow;
        } else {
            resultLength = films.length;
        }

        String[] outputArray = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            outputArray[i] = films[films.length - i - 1];
        }

        return outputArray;
    }
}
