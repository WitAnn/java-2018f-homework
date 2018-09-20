package com.company;

import java.util.Random;

public class CalabashBrothersSort {

    public static void main(String[] args) {

        CalabashBrothersSort calabashBrothersSort = new CalabashBrothersSort();
        calabashBrothersSort.bubbleSortCalabashBrothers();
        calabashBrothersSort.binaryInsertSortCalabashBrothers();
    }

    private void bubbleSortCalabashBrothers() {
        System.out.println("It's Bubble sort");
        CalabashBrothers calabashBrothers = new CalabashBrothers();
        System.out.print("Before sorted: ");
        calabashBrothers.printAllCalabashBoys();
        for (int i = CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (calabashBrothers.compareCalabashBoy(j, j + 1) > 0) {
                    calabashBrothers.swapCalabashBoy(j, j + 1);
                }
            }
        }
        System.out.print("After sorted: ");
        calabashBrothers.printAllCalabashBoys();
        System.out.println();
    }

    private void binaryInsertSortCalabashBrothers() {
        System.out.println("It's Binary Insert sort");
        CalabashBrothers calabashBrothers = new CalabashBrothers();
        System.out.print("Before sorted: ");
        calabashBrothers.printAllCalabashBoys();
        for (int i = 1; i < CalabashBrothers.MAX_CALABASH_BROTHERS_COUNT; i++) {
            int highPosition = i;
            int lowPosition = 0;
            int midPosition = (highPosition + lowPosition) / 2;
            while (highPosition >= lowPosition) {
                midPosition = (highPosition + lowPosition) / 2;
                if (calabashBrothers.compareCalabashBoy(midPosition, i) > 0) {
                    highPosition = midPosition - 1;
                } else {
                    lowPosition = midPosition + 1;
                }
            }

            for (int j = i - 1; j >= lowPosition; j--) {
                calabashBrothers.swapCalabashBoy(j, j + 1);
            }
        }
        System.out.print("After sorted: ");
        calabashBrothers.printAllCalabashBoys();
        System.out.println();
    }

}

class CalabashBrothers {

    public static final int MAX_CALABASH_BROTHERS_COUNT = 7;
    private CalabashBoy[] calabashBoyArray = new CalabashBoy[MAX_CALABASH_BROTHERS_COUNT];

    public CalabashBrothers() {
        int[] randomArray = createRandomArray();
        for (int i = 0; i < MAX_CALABASH_BROTHERS_COUNT; i++) {
            calabashBoyArray[i] = CalabashBoy.values()[randomArray[i] - 1];
        }
    }

    private int[] createRandomArray() {
        int[] randomArray = new int[MAX_CALABASH_BROTHERS_COUNT];
        Random rand = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            int randomNumber = rand.nextInt(MAX_CALABASH_BROTHERS_COUNT) + 1;
            boolean newNumberFlag;
            do {
                newNumberFlag = false;
                for (int j = 0; j < i; j++) {
                    if (randomNumber == randomArray[j]) {
                        randomNumber = rand.nextInt(MAX_CALABASH_BROTHERS_COUNT) + 1;
                        newNumberFlag = true;
                    }
                }
            } while (newNumberFlag);

            randomArray[i] = randomNumber;
        }

        return randomArray;
    }

    public void swapCalabashBoy(int i, int j) {

        if (i < 0 || i > MAX_CALABASH_BROTHERS_COUNT - 1 || j < 0 || j > MAX_CALABASH_BROTHERS_COUNT - 1) {
            System.out.println("ERROR IN swapCalabashBoy()");
        }
        System.out.print("" + calabashBoyArray[i].getName() + i + " -> " + j + " && ");
        System.out.println("" + calabashBoyArray[j].getName() + j + " -> " + i);

        CalabashBoy temp = calabashBoyArray[i];
        calabashBoyArray[i] = calabashBoyArray[j];
        calabashBoyArray[j] = temp;
    }

    public int compareCalabashBoy(int i, int j) {

        return calabashBoyArray[i].getRank() - calabashBoyArray[j].getRank();
    }

    public void printAllCalabashBoys() {
        for (int i = 0; i < calabashBoyArray.length; i++) {
            System.out.print(calabashBoyArray[i].getColor() + "(" + calabashBoyArray[i].getRank() + ")");
            if (i != calabashBoyArray.length - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}

enum CalabashBoy {

    RED("老大", 1, "红色"), ORANGE("老二", 2, "橙色"), YELLOW("老三", 3, "黄色"), GREEN("老四", 4, "绿色"),
    CYAN("老五", 5, "青色"), BLUE("老六", 6, "蓝色"), PURPLE("老七", 7, "紫色");

    private int rank;
    private String name;
    private String color;

    CalabashBoy(String name, int rank, String color) {
        this.name = name;
        this.rank = rank;
        this.color = color;
    }


    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getRank() {
        return this.rank;
    }
}

