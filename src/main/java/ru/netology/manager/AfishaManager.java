package ru.netology.manager;
import ru.netology.domain.AfishaItem;

public class AfishaManager {

    private AfishaItem[] items = new AfishaItem[0];
    private int countAll = 10;


    public void add(AfishaItem item) {
        int length = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AfishaItem[] getAll() {
        return items;
    }

    public AfishaManager(int count) {
        if (count >= 0) {
            this.countAll = count;
        }
    }

    public AfishaItem[] getNewest() {
        int count = items.length > countAll ? countAll : items.length;
        AfishaItem[] result = new AfishaItem[count];
        for (int i = 0; i < count; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
