class File
{
    public static FileState state;

    public File() {
        state= FileOpened.Instance();
    }

    public void setState(FileState state)
    {
        this.state=state;

    }
    public void Read()
    {
        state.Read();
    }
    public void Write()
    {
        state.Write();
    }
    public void Open(File file)
    {
        state.Open(this);
    }
    public void Close()
    {
        state.Close(this);
    }

}

abstract class FileState
{
    abstract public void Read();
    abstract public void Write();
    abstract public void Open(File file);
    abstract public void Close(File file);

    void setState(File file, FileState files)
    {
        file.setState(files);
    }
}
class FileOpened extends FileState
{
    public static FileState instance ;
    public FileOpened() {

    }
    public static   FileState Instance()
    {

        if (instance == null)
            instance = new FileOpened();
        return instance;
    }
    @Override
    public void Read()
    {
        System.out.println("Czytam");
    }
    @Override
    public void Write()
    {
        System.out.println("Pisze");
    }

    @Override
    public void Open(File file) {
        System.out.println("Nie mozna otworzyc");
    }

    @Override
    public void Close(File file) {
        System.out.println("Zamykam plik");
        setState(file, instance);
    }
}
class FileClosed extends FileState
{
    public static FileState instance ;
    public FileClosed() {

    }
    public static  FileState Instance()
    {

        if (instance == null)
            instance = new FileClosed();
        return instance;
    }

    @Override
    public void Read() {
        System.out.println("Nie czytam");
    }

    @Override
    public void Write() {
        System.out.println("Nie pisze");

    }

    @Override
    public void Open(File file) {
        System.out.println("Otwieram");
        setState(file, instance);
    }

    @Override
    public void Close(File file) {
        System.out.println("Jest juz zamkniety");
    }
}
public class main {
    public static void main(String[] args) {
        File plik = new File();
        plik.Read();
        plik.Write();

        plik.Close();
        plik.Read();
        plik.Write();

    }
}
