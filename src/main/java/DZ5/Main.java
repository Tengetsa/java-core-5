package DZ5;

import java.io.IOException;

import static DZ5.FileBackup.createBackup;
import static DZ5.TicTacToe.*;

public class Main {
    public static void main(String[] args) throws IOException {

        task1();
        task2();
    }

    private static void task1() {
        /*
          1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь
          созданную папку ./backup
         */

        try {
            createBackup("src/main/source", "src/main/backup");
            System.out.println("Резервная копия создана успешно.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании резервной копии: " + e.getMessage());
        }
    }

    private static void task2() throws IOException {
        /*
          2. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и представляют собой,
          например, состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
          2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int
          всё поле 3х3. Реализовать функционал с записью в файл и обратно игрового поля. Выводить в консоль игровое
          поле после импорта, заменяя числа символами X, O, •(пусто)
         */

        int[] initialState = {1, 0, 3, 3, 1, 2, 2, 1, 0};
        TicTacToe ticTacToe = new TicTacToe(initialState);

        try {
            ticTacToe.writeToFile("src/main/source/ticTacToe.bin");
            ticTacToe.readFromFile("src/main/source/ticTacToe.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ticTacToe.printBoard();

    }
}