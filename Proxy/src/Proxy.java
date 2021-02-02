interface Subject
{
    void count();
}
class ProxySubject implements Subject
{
    private static RealSubject e;
    double a,b,c;


    public ProxySubject(double a,double b,double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public void count() {

        if (e==null)
        {
            e = new RealSubject(a,b,c);
        }
        e.count();

}
class RealSubject implements Subject
{
    double a,b,c;
    double score;

    public RealSubject(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    @Override
    public void count() {
        score = ((b*b) - (4*a*c));
    }

}
public  class Proxy {
    public void main(String[] args) {
        Subject mainS = new RealSubject(1.0,2.0,-1.0);
        mainS.count();
        mainS.count();

    }
}
}
