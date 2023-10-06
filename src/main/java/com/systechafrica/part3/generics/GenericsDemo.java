package com.systechafrica.part3.generics;

public class GenericsDemo {
    public static void main(String[] args) {

    }

    public static void withoutGenerics() {
        Storage storage = new Storage();

        MaizeFloor floor = new MaizeFloor(null, null, null);
        MaizeFloor floor2 = new MaizeFloor(null, null, null);

        MaizeFloor[] maizeFloors = { floor, floor2 };

        storage.store(maizeFloors);

        Bag bag1 = new Bag();
        Bag bag2 = new Bag();

        Bag[] bags = { bag1, bag2 };

        storage.store(bags);
    }

    public static void withGenerics() {
        StorageGenerics<MaizeFloor> storage = new StorageGenerics<>();

        MaizeFloor floor = new MaizeFloor(null, null, null);
        MaizeFloor floor2 = new MaizeFloor(null, null, null);

        MaizeFloor[] maizeFloors = { floor, floor2 };

        storage.store(maizeFloors);

        Bag bag1 = new Bag();
        Bag bag2 = new Bag();

        StorageGenerics<Bag> BagsStorage = new StorageGenerics<>();
        Bag[] bags = { bag1, bag2 };

        BagsStorage.store(bags);

        Bag bagStored = BagsStorage.store(bag2);
    }


}
