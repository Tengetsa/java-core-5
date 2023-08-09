package DZ5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TicTacToe {
    private int[] fieldStatus;

    public TicTacToe(int[] fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public int encodedFields() {
        int encodedFields = 0;
        for (int j : fieldStatus) {
                encodedFields = encodedFields << 2;
            encodedFields = encodedFields | j;
        }
        return encodedFields;
    }


    public void fieldDecoder(int encodedFields) {
        for (int i = fieldStatus.length - 1; i >= 0; i--) {
            int cellState = encodedFields & 3;
            encodedFields = encodedFields >> 2;
            fieldStatus[i] = cellState;
        }
    }


    public void writeToFile(String fileName) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(encodedFields());
        }
    }


    public void readFromFile(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int fieldEntry = dis.readInt();
            fieldDecoder(fieldEntry);
        }
    }

    public void printBoard() {
        for (int i = 0; i < fieldStatus.length; i++) {
            char cellSymbol;
            cellSymbol = switch (fieldStatus[i]) {
                case 0 -> '.';
                case 1 -> 'x';
                case 2 -> 'o';
                default -> ' ';
            };

            System.out.print(cellSymbol + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }
}
