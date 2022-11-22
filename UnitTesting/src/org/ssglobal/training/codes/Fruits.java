package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Fruits {
    private List<String> stand = new ArrayList<>();

    public boolean addFruits(String... fruit) {
        try {
            for (String f : fruit) {
                stand.add(f);
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int countFruits() {
        return 0;
    }

    public boolean deleteFruit(String fruit) {
        boolean isRemoved = stand.remove(fruit);
        return isRemoved;
    }

    public List<String> getStand() {
        return stand;
    }

    public Stream<String> getFruitStream() {
        return Stream.of("apple", "banana", "orange");
    }
}
