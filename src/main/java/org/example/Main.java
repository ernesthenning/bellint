package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<Map<String, String>>> workers = new ArrayList<List<Map<String, String>>>();
        List<Map<String, String>> worker1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            worker1.add(new HashMap<>());
        }
        worker1.get(0).put("Имя", "Кирилл");
        worker1.get(1).put("Возраст", "26");
        worker1.get(2).put("Должность", "");
        worker1.get(3).put("Зарплата", "150000 руб");

        List<Map<String, String>> worker2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            worker2.add(new HashMap<>());
        }
        worker2.get(0).put("Имя", "Виталий");
        worker2.get(1).put("Возраст", "28");
        worker2.get(2).put("Должность", "");
        worker2.get(3).put("Зарплата", "2000$");

        List<Map<String, String>> worker3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            worker3.add(new HashMap<>());
        }
        worker3.get(0).put("Имя", "Александр");
        worker3.get(1).put("Возраст", "31");
        worker3.get(2).put("Должность", "");
        worker3.get(3).put("Зарплата", "50000 руб");

        List<Map<String, String>> worker4 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            worker4.add(new HashMap<>());
        }
        worker4.get(0).put("Имя", "Дементий");
        worker4.get(1).put("Возраст", "35");
        worker4.get(2).put("Должность", "");
        worker4.get(3).put("Зарплата", "1500$");

        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);

        List<String> namesYoungerThan30 = new ArrayList<>();
        workers.forEach(worker -> {
            int age = Integer.parseInt(worker.get(1).get("Возраст"));
            if (age < 30) {
                namesYoungerThan30.add(worker.get(0).get("Имя"));
            }
        });

        List<String> namesSalaryInRoubles = workers.stream()
                .filter(e -> e.get(3).get("Зарплата").contains("руб"))
                .map(e -> e.get(0).get("Имя"))
                .toList();

        Double mediumAge = workers.stream()
                .mapToInt(e -> Integer.parseInt(e.get(1).get("Возраст")))
                .average()
                .orElse(0);

        System.out.println("Имена сотрудников, получающих зарплату в рублях:");
        namesSalaryInRoubles.forEach(System.out::println);
        System.out.println("Имена сотрудников моложе 30 лет:");
        namesYoungerThan30.forEach(System.out::println);
        System.out.println("Средний возраст в компании");
        System.out.println(mediumAge);
        int[][] testMatrice = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minElement(testMatrice));
        System.out.println(Arrays.deepToString(getMatrice(10)));
    }

    private static int minElement(int[][] matrice) {
        int min = matrice[matrice.length - 1][0];
        if (matrice.length % 2 == 0) {
            for (int i = 0; i < matrice.length; i++) {
                if (min > matrice[matrice.length - 1 - i][i]) min = matrice[matrice.length - 1 - i][i];
            }
        } else {
            for (int i = 0; i < matrice.length; i++) {
                if (i != matrice.length / 2 + 1) continue;
                if (min > matrice[matrice.length - 1 - i][i]) min = matrice[matrice.length - 1 - i][i];
            }
        }
        return min;
    }

    private static int[][] getMatrice(int side) {
        int initialSide = side;
        int[][] matrice = new int[side][side];
        int counter = 0;
        while (side >= 2) {
            int outerNumber = (side - 4) / 2 + 1;
            for (int i = counter; i < initialSide - counter; i++) {
                for (int j = counter; j < initialSide - counter; j++) {
                    if (i == counter || j == counter
                            || i == initialSide - 1 - counter
                            || j == initialSide - 1 - counter) {
                        matrice[i][j] = outerNumber;
                    }
                }
            }
            side -= 2;
            counter++;
        }
        return matrice;
    }
}
