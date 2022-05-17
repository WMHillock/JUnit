import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double pexArea = РexahedronCalcs.pexahedronArea(0,0,12);
        System.out.println(pexArea);

        double pexVolume = РexahedronCalcs.pexahedronVolume(2,6,9);
        System.out.println(pexVolume);

        double pexDiagonal = РexahedronCalcs.pexahedronDiagonal(3,5,9);
        System.out.println(pexDiagonal);

        boolean isThis = РexahedronCalcs.isThis3D(2,3,0);
        System.out.println(isThis);

        РexahedronCalcs.saveInFile(3,18,20);
    }
}
