package matricesDispersas;

import javax.swing.JOptionPane;

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
   
    public void Crear(int n, int m, int d, int mat[][])//Solucionar errores con datos <>
    {
        int k=1;
        tri[0][0]=n;tri[0][1]=m;tri[0][2]=d;
       
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
        for (int k = 0; k <= getTri(0, 2); k++)
        {
            System.out.println("|"+getTri(k, 0)+"|"+getTri(k, 1)+"|"+getTri(k, 2)+"|");
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
            System.out.println("La suma de filas "+ valor+ " es: "+sumaF);       
        }
    }//Fin sumar filas.
    public void sumaColumnas()//Pequeñas correcciones
    {
        int sumC, k=1, valor =0;
        while (valor<=tri[0][1]) 
        {
            sumC=0;
            while (k<=tri[0][1])
            {                
                if(tri[k][1]==valor)
                {
                    sumC+=tri[k][2];
                }
                k++;
            }
            System.out.println("La suma de Columnas "+ valor+ " es: "+sumC); 
            valor+=1;
            k=1;
        }
    }//Fin suma columnas
    public tripleta insertarDato()//Arreglar
    {
        int f, c, d, k=1,swIgual=0;
        
        f = Integer.parseInt(JOptionPane.showInputDialog("¿En que fila lo desea insertar?"));
        if(f<getTri(0, 0)&& !(f<0))
        {
            c = Integer.parseInt(JOptionPane.showInputDialog("¿En que columna lo desea insertar?"));
            d = Integer.parseInt(JOptionPane.showInputDialog("Que dato desea ingresar: "));
            if(c<getTri(0, 1)&& !(c<0))
            {
               while(k<=getTri(0, 2))//caso suma
               {
                    if (f==getTri(k, 0) && c== getTri(k, 1))
                    {
                        setTri(k, 2, getTri(k, 2)+d);
                        swIgual=1;
                    }
                    k++;
               } 
               if(swIgual == 0)
               {
                   tripleta t1 = new tripleta(getTri(0, 2)+2);//CREAR NUEVA TRIPLETA
                   t1.setTri(0, 2, getTri(0,2)+1);//DATOS <> 0 NUEVA TRIPLETA  
                   t1.setTri(f, 0, f);//En la posicion de la fila le ponemos el dato de la fila
                   t1.setTri(f, 1, c);//En la posicion de la columna le ponemos el dato de la columna.
                   t1.setTri(f, 2, d);//En la posicion respectiva le ponemos el dato.  
                   t1 =t1.llenarTri(this);//LLENAR TRIPLETA CON DATOS ORIGINALES
                   
                   return t1;
               }
            }
            else
            {
                if(c>getTri(0, 1))
                {
                     JOptionPane.showMessageDialog(null, "La fila insertada es mayor que la cantidad de filas en la tripleta.");
                }
                else if(c<0)
                {
                    JOptionPane.showMessageDialog(null, "No existen filas menores que 0.");
                }
            }//Fin condicion tamaño de C           
        }
        else
        {
            if(f>getTri(0, 0))
            {
                JOptionPane.showMessageDialog(null, "La fila insertada es mayor que la cantidad de filas en la tripleta.");
            }
            else if(f<0)
            {
                JOptionPane.showMessageDialog(null, "No existen filas menores que 0.");
            }
        }//Fin condicion tamaño de f.  
        return this;
    }//Fin insertar
    public tripleta llenarTri(tripleta t)//Arreglar
    {
        int i=1, j=1;
        setTri(0, 0, t.getTri(0, 0));
        setTri(0, 1, t.getTri(0, 1));
        while (i<=this.getTri(0, 2))
        {       
            if(getTri(i, 2)==0)
            {
               setTri(i, 0, t.getTri(j, 0));
               setTri(i, 1, t.getTri(j, 1));
               setTri(i, 2, t.getTri(j, 2));
               i++;
               j++;
            }
            else
            {
              i++;  
            }
             
        }
        return this;
    }
}//Fin class