import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {
    @Test
    public void getLastFilmsCountShouldInitializeCorrectWithoutParameters() {
        FilmManager filmManager = new FilmManager();

        int expected = 5;
        int actual = filmManager.getLastFilmsCountToShow();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getLastFilmsCountShouldInitializeCorrectWithParameters() {
        FilmManager filmManager = new FilmManager(999);

        int expected = 999;
        int actual = filmManager.getLastFilmsCountToShow();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldPerformAddAndFindAllCorrect() {
        FilmManager filmManager = new FilmManager();

        String[] testedFilmNames = PrepareTestFilmNames();

        filmManager.add(testedFilmNames[0]);
        filmManager.add(testedFilmNames[1]);
        filmManager.add(testedFilmNames[2]);

        String[] expected = filmManager.findAll();
        String[] actual = testedFilmNames;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindAllCorrectEmptyArray() {
        FilmManager filmManager = new FilmManager();

        String[] expected = filmManager.findAll();
        String[] actual = new String[0];

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastCorrectIfFilmsCountGreater() {
        FilmManager filmManager = new FilmManager(2);

        String[] testedFilmNames = PrepareTestFilmNames();

        filmManager.add(testedFilmNames[0]);
        filmManager.add(testedFilmNames[1]);
        filmManager.add(testedFilmNames[2]);

        String[] expectedArray = new String[2];
        expectedArray[0] = testedFilmNames[2];
        expectedArray[1] = testedFilmNames[1];

        String[] expected = expectedArray;
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastCorrectIfFilmsCountEquals() {
        FilmManager filmManager = new FilmManager(3);

        String[] testedFilmNames = PrepareTestFilmNames();

        filmManager.add(testedFilmNames[0]);
        filmManager.add(testedFilmNames[1]);
        filmManager.add(testedFilmNames[2]);

        String[] expectedArray = new String[3];
        expectedArray[0] = testedFilmNames[2];
        expectedArray[1] = testedFilmNames[1];
        expectedArray[2] = testedFilmNames[0];

        String[] expected = expectedArray;
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindLastCorrectIfFilmsCountLess() {
        FilmManager filmManager = new FilmManager(4);

        String[] testedFilmNames = PrepareTestFilmNames();

        filmManager.add(testedFilmNames[0]);
        filmManager.add(testedFilmNames[1]);
        filmManager.add(testedFilmNames[2]);

        String[] expectedArray = new String[3];
        expectedArray[0] = testedFilmNames[2];
        expectedArray[1] = testedFilmNames[1];
        expectedArray[2] = testedFilmNames[0];

        String[] expected = expectedArray;
        String[] actual = filmManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    private String[] PrepareTestFilmNames() {
        String[] films = new String[3];

        String firstFilmName = "film 1";
        String secondFilmName = "film 2";
        String thirdFilmName = "film 3";

        films[0] = firstFilmName;
        films[1] = secondFilmName;
        films[2] = thirdFilmName;

        return films;
    }
}
