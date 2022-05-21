package matricesDispersas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sala306
 */
public class tripleta
{
    //Atributos
    private int tri[][];
   
    //Metodos.

    public tripleta(int N) //Constructor
    {
        tri = new int[N][3];
    }

    public int[][] getTri() {
        return tri;
    }

    public void setTri(int[][] tri) {
        this.tri = tri;
    }
    public int getTri(int f, int c) {
        return tri[f][c];
    }

    public void setTri(int f, int c, int d) {
        tri[f][c] = d;
    }
   
    public void Crear(int n, int m, int d, int mat[][])
    {
        int k=1;
        tri[0][0]=n;tri[0][1]=m;tri[0][2]=d-1;
       
        //mat.length i, mat[i].length
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++) {
                if (mat[i][j]!=0) {
                    tri[k][0] =i;
                    tri[k][1] =j;    
                    tri[k][2] =mat[i][j];
                    k++;
                }//fin if.
            }
        }   
    }//fin crear
    public void mostrar()
    {
        for (int k = 0; k <= tri[0][2]; k++)
        {
            System.out.println("|"+tri[k][0]+"|"+tri[k][1]+"|"+tri[k][2]+"|");
        }
    }//Fin mostrar
    public void sumaFilas()
    {
        int sumaF, k=1, valor=0;
        while (k<=(tri[0][2]))
        {   
            sumaF=0;
            valor =tri[k][0];
            while (k<=(tri[0][2])&&tri[k][0]==valor)
            {                
                sumaF += tri[k][2];
                k++;
            }
            System.out.println("La suma de filas "+ valor+ "es: "+sumaF);       
        }
    }//Fin sumar filas.
}//Fin class