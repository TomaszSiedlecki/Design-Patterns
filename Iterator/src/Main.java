import java.util.ArrayList;
import java.util.List;

class Iterator1{

    public List<Object> IList;
    private int index=0;

    public Iterator1( List<Object> list )
    {
        this.IList = list;
    }

    public int first() {
        return index=0;
    }

    public int next() {
        return index++;
    }

    public int currentitem(){
        return (int) IList.get(index);
    }

    public boolean isdone(){
        return index >= IList.size();
    }

    public void show()
    {
        for(first(); !isdone(); next()){
            System.out.println(currentitem());
        }
        System.out.println("\n\n");
    }


}
class Iterator2{

    public List<Object> IList;
    private int index=0;

    public Iterator2( List<Object> list )
    {
        this.IList = list;
    }

    public int first() {
        return index=0;
    }

    public int next() {
        return index++;
    }

    public int currentitem(){
        return (int) IList.get(index);
    }

    public boolean isdone(){
        return index >= IList.size();
    }

    public void show()
    {
        for(first(); !isdone(); next()){
            if(currentitem()==0)
                next();
            System.out.println(currentitem());
        }
        System.out.println("\n\n");
    }


}

public class Main {
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(5);
        list.add(0);
        list.add(6);

        Iterator1 i1= new Iterator1(list);
        Iterator2 i2= new Iterator2(list);

        i1.show();
        i2.show();

    }
}
