package io.github.jx2lee.spring.core.basic.singleton;

public class StatefulServiceV2 {

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }
}
