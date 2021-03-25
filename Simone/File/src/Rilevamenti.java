import java.io.IOException;
import java.io.RandomAccessFile;

public class Rilevamenti {

    private int metri;
    private String nome;

    public Rilevamenti(int metri, String nome) {
        this.metri = metri;
        this.nome = nome;
    }
    public void write (RandomAccessFile raf) throws IOException {
        raf.writeChars(nome.substring(0, 6));
        raf.writeInt(metri);
    }

    public static void read (RandomAccessFile raf) throws IOException {
        String nome = String.valueOf;
    }


}
