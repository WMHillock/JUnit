import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class РexahedronCalcs {


        public static double pexahedronArea(double lengthA, double heightB, double widthC) {
            return (lengthA * heightB + heightB * widthC + lengthA * widthC) * 2;

        }

        public static double pexahedronVolume(double lengthA, double heightB, double widthC) {
            return lengthA * heightB * widthC;

        }

        public static double pexahedronDiagonal(double lengthA, double heightB, double widthC) {
            return Math.sqrt(Math.pow(lengthA,2) + Math.pow(heightB,2) + Math.pow(widthC,2));

        }

        public static boolean isThis3D(double lengthA, double heightB, double widthC) {
            return pexahedronVolume(lengthA, heightB, widthC) > pexahedronDiagonal(lengthA, heightB, widthC);
        }

    public static void saveInFile(double lengthA, double heightB, double widthC) throws IOException {

        File temp = new File("C://temp.txt"); //Должно быть - "./temp.txt"
        temp.createNewFile();

        try (FileWriter text = new FileWriter("temp.txt")) {
            text.write(String.format("По введенным данным мы %s построить 3D фигуру. " +
                            "\nПлощадь равна - %.2f " +
                            "\nOбьем равен - %.2f \nДиагональ равна - %.2f",
                    (isThis3D(lengthA, heightB, widthC) ? "смогли " : "не смогли "),
                    pexahedronArea(lengthA, heightB, widthC),
                    pexahedronVolume(lengthA, heightB, widthC),
                    pexahedronDiagonal(lengthA, heightB, widthC)));
        } catch (IOException e) {
            System.out.println("Файл не создан");;
        }
    }

    }
