package matricesDispersas;

public class Nodo {
   
    //atributos
    private int f, c, dato;
    private Nodo lc, lf, liga;
   
    //constructor
    public void nodo ()
    {
        dato=0;
        f=0;c=0;
        lc=null; lf=null;
    }
   
    //metodos
    public int getDato()
    {
        return dato;
    }
   
    public void setDato(int d)
    {
        dato=d;
    }
   
    public Nodo getLf()
    {
        return lf;
    }
    public void setLf(Nodo l)
    {
        lf=l;
    }
   
    public Nodo getLc()
    {
        return lc;
    }
   
    public void setLc(Nodo l)
    {
        lc=l;  
    }
    public Nodo getLiga()
    {
        return liga;
    }
   
    public void setLiga(Nodo l)
    {
        liga=l;
    }
}