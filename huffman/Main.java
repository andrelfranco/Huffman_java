package huffman;

import java.io.IOException;
import java.util.Scanner;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Path p = FileSystems.getDefault().getPath("", "C:\\Users\\andre\\Documents\\7 Periodo\\huffman\\data.txt");
        byte [] fileData = Files.readAllBytes(p);
        System.out.println("==========\n");
        System.out.println(Arrays.toString(fileData));
        System.out.println("\n==========\n");
        Scanner in = new Scanner(System.in);

        System.out.println("--------------------------------------------");
        System.out.println("Codificação de Huffman");
        System.out.println("--------------------------------------------");

        /*while (true) {
            System.out.println("Digite o texto a ser codificado");
            System.out.println("Use Huffman para um texto padrão ou deixe em branco para parar.");
            String text = in.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Bye bye!");
                return;
            }

            if (text.equalsIgnoreCase("Huffman")) {
                text =
                        "In computer science and information theory, a Huffman code is a particular type\n" +
                                "of optimal prefix code that is commonly used for lossless data compression. The\n" +
                                "process of finding and/or using such a code proceeds by means of Huffman coding,\n" +
                                "an algorithm developed by David A. Huffman while he was a Ph.D. student at MIT,\n" +
                                "and published in the 1952 paper \"A Method for the Construction of\n" +
                                "Minimum-Redundancy Codes\".";
            }

            System.out.println();
            Huffman huff = new Huffman();
            String data = huff.encode(text);

            int normalSize = text.length() * 8;
            int compressedSize = data.length();
            double rate = 100.0 - (compressedSize * 100.0 / normalSize);
            System.out.println("Tamanho Normal: " + normalSize);
            System.out.println("Tamanho Comprimido: " + compressedSize);
            System.out.printf("Comprimido é %.2f%% menor que o original. %n", rate);
            System.out.println();
            System.out.println("Texto Codificado:");
            System.out.println(data);
            System.out.println();
            System.out.println("Texto Decodificado:");
            System.out.println(huff.decode(data));
            System.out.println();
            System.out.println();
        }*/
    Huffman huff = new Huffman();
    String data = huff.encode(Arrays.toString(fileData));
    int normalSize = Arrays.toString(fileData).length() * 8;
    int compressedSize = data.length();
    double rate = 100.0 - (compressedSize * 100.0 / normalSize);
    System.out.println("Tamanho Normal: " + normalSize);
    System.out.println("Tamanho Comprimido: " + compressedSize);
    System.out.printf("Comprimido é %.2f%% menor que o original. %n", rate);
    System.out.println();
    System.out.println("Texto Codificado:");
    System.out.println(data);
    System.out.println();
    System.out.println("Texto Decodificado:");
    System.out.println(huff.decode(data));
    System.out.println();
    System.out.println();
    }
    
}
