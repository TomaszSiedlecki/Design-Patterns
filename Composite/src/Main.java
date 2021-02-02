import java.util.ArrayList;
import java.util.List;

interface Graphic
{
    void Draw();
    void Add(Graphic a);
    void Remove(Graphic a);
    void GetChild(int i);

}
class Line implements  Graphic
{

    @Override
    public void Draw() {
        System.out.println("Rysuje linie");
    }

    @Override
    public void Add(Graphic a) {

    }

    @Override
    public void Remove(Graphic a) {

    }

    @Override
    public void GetChild(int i) {

    }
}
class Rectangle implements  Graphic
{

    @Override
    public void Draw() {
        System.out.println("Rysuje prostokat");
    }

    @Override
    public void Add(Graphic a) {

    }

    @Override
    public void Remove(Graphic a) {

    }

    @Override
    public void GetChild(int i) {

    }
}
class Text implements  Graphic
{

    @Override
    public void Draw() {
        System.out.println("Rysuje tekst");
    }

    @Override
    public void Add(Graphic a) {

    }

    @Override
    public void Remove(Graphic a) {

    }

    @Override
    public void GetChild(int i) {

    }
}
class Picture implements Graphic {

    List <Graphic> child = new ArrayList<Graphic>();
    @Override
    public void Draw() {
        for (Graphic p : child)
        {
            p.Draw();
        }
    }

    @Override
    public void Add(Graphic a) {
        child.add(a);
    }

    @Override
    public void Remove(Graphic a) {
        child.remove(a);
    }

    @Override
    public void GetChild(int i) {
        child.get(i);
    }
}
public class Main {
    public static void main(String[] args) {

        Line linia = new Line();
       Rectangle prost = new Rectangle();
       Text tekst = new Text();
       Picture picture2 = new Picture();
       Picture picture1 = new Picture();

       picture1.Add(linia);
       picture1.Add(prost);
       picture1.Add(tekst);


       picture2.Add(linia);
       picture2.Add(prost);
       picture2.Add(tekst);

       picture1.Add(picture2);


        picture1.Draw();


    }
}
