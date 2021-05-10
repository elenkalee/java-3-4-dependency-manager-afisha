package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.AfishaItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {

    private AfishaManager manager = new AfishaManager(10);
    private AfishaItem item1 = new AfishaItem(1, "movie1", "www.afisha1.ru", "genre1");
    private AfishaItem item2 = new AfishaItem(2, "movie2", "www.afisha2.ru", "genre2");
    private AfishaItem item3 = new AfishaItem(3, "movie3", "www.afisha3.ru", "genre3");
    private AfishaItem item4 = new AfishaItem(4, "movie4", "www.afisha4.ru", "genre4");
    private AfishaItem item5 = new AfishaItem(5, "movie5", "www.afisha5.ru", "genre5");
    private AfishaItem item6 = new AfishaItem(6, "movie6", "www.afisha6.ru", "genre6");
    private AfishaItem item7 = new AfishaItem(7, "movie7", "www.afisha7.ru", "genre7");
    private AfishaItem item8 = new AfishaItem(8, "movie8", "www.afisha8.ru", "genre8");
    private AfishaItem item9 = new AfishaItem(9, "movie9", "www.afisha9.ru", "genre9");
    private AfishaItem item10 = new AfishaItem(10, "movie10", "www.afisha10.ru", "genre10");

    private void setMovie() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
        manager.add(item7);
        manager.add(item8);
        manager.add(item9);
        manager.add(item10);
    }

    @Test
    void shouldAddNoMovie() {
        AfishaItem[] expected = new AfishaItem[0];
        AfishaItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetNewestOutCount() {
        manager = new AfishaManager(3);
        setMovie();

        AfishaItem[] expected = new AfishaItem[]{item10, item9, item8};
        AfishaItem[] actual = manager.getNewest();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllListNewestFirst() {
        manager = new AfishaManager(10);
        setMovie();

        AfishaItem[] expected = new AfishaItem[]{item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        AfishaItem[] actual = manager.getNewest();
        assertArrayEquals(expected, actual);
    }
}

