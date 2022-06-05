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
public class tripleta {

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
        int k = 1;
        tri[0][0] = n;
        tri[0][1] = m;
        tri[0][2] = d;

        //mat.length i, mat[i].length
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    tri[k][0] = i;
                    tri[k][1] = j;
                    tri[k][2] = mat[i][j];
                    k++;
                }//fin if.
            }
        }
    }//fin crear

    public void mostrar() {
        for (int k = 0; k <= getTri(0, 2); k++) {
            System.out.println("|" + getTri(k, 0) + "|" + getTri(k, 1) + "|" + getTri(k, 2) + "|");
        }
    }//Fin mostrar

    public void sumaFilas() {//Bien
        int sumaF, k = 1, valor = 0;
        while (k <= (tri[0][2])) {
            sumaF = 0;
            valor = tri[k][0];
            while (k <= (tri[0][2]) && tri[k][0] == valor) {
                sumaF += tri[k][2];
                k++;
            }
            System.out.println("La suma de filas " + valor + " es: " + sumaF);
        }
    }//Fin sumar filas.

    public void sumaColumnas()//REVISAR CON UN DATO
    {
        int sumC, k = 1, valor = 0;
        while (valor <= tri[0][2]) {
            sumC = 0;
            while (k <= tri[0][2]) {
                if (tri[k][1] == valor) {
                    sumC += tri[k][2];
                }
                k++;
            }
            if(sumC !=0)
            {
                System.out.println("La suma de Columnas " + valor + " es: " + sumC);
            }          
            valor += 1;
            k = 1;
        }
    }//Fin suma columnas

    public tripleta insertarDato()//FUNCIONA DESORDENADO
    {
        int f, c, d, k = 1, swIgual = 0;

        f = Integer.parseInt(JOptionPane.showInputDialog("¿En que fila lo desea insertar?"));
        if (f < getTri(0, 0) && !(f < 0)) {
            c = Integer.parseInt(JOptionPane.showInputDialog("¿En que columna lo desea insertar?"));
            d = Integer.parseInt(JOptionPane.showInputDialog("Que dato desea ingresar: "));
            if (c < getTri(0, 1) && !(c < 0) && d!=0)//En caso de que la posicion exista dentro de los limites
            {                
                while (k <= getTri(0, 2))//caso suma
                {
                    if (f == getTri(k, 0) && c == getTri(k, 1)&&(getTri(k,2)+d)!=0) {                      
                        setTri(k, 2, getTri(k, 2) + d);
                        swIgual = 1;
                    }
                    else if((getTri(k,2)+d)==0)//caso donde de 0
                    {
                        //Eliminar getTri(k,2)
                        swIgual = 1;
                    }
                    k++;
                }
                if (swIgual == 0|| f==0) {//En caso de que no exista la posicion
                    tripleta t1 = new tripleta(getTri(0, 2) + 2);//CREAR NUEVA TRIPLETA
                    t1.setTri(0, 2, getTri(0, 2) + 1);//DATOS <> 0 NUEVA TRIPLETA
                    t1.setTri(0,0,this.getTri(0,0));
                    t1.setTri(0,1,this.getTri(0,1)); 
                    t1.llenarTri(this, f, c, d);                
                    return t1;
                }
            } else {
                if(d==0)
                {
                   JOptionPane.showMessageDialog(null, "No se puede insertar un 0."); 
                }
                if (c > getTri(0, 1)) {
                    JOptionPane.showMessageDialog(null, "La Columna insertada es mayor que la cantidad de filas en la tripleta.");
                } else if (c < 0) {
                    JOptionPane.showMessageDialog(null, "No existen Columnas menores que 0.");
                }
            }//Fin condicion tamaño de C           
        } else {
            if (f > getTri(0, 0)) {
                JOptionPane.showMessageDialog(null, "La fila insertada es mayor que la cantidad de filas en la tripleta.");
            } else if (f < 0) {
                JOptionPane.showMessageDialog(null, "No existen filas menores que 0.");
            }
        }//Fin condicion tamaño de f.  
        return this;
    }//Fin insertar

    public tripleta llenarTri(tripleta tOld, int f, int c, int d)//
    {
        int i=1,j=1, sw=0;
        while(j<= this.getTri(0, 2))//Bueno
        {           
            if(i<=tOld.getTri(0,2))
            {
                if((tOld.getTri(i, 0) < 
                        f)||(tOld.getTri(i, 0) == f && tOld.getTri(i, 1)<c)||(tOld.getTri(i, 0) < f)||sw==1)//Bueno
                {
                    this.setTri(j, 0, tOld.getTri(i, 0));//LLenado de filas
                    this.setTri(j,1, tOld.getTri(i,1));//Llenado columnas
                    this.setTri(j,2,tOld.getTri(i,2));//LLenado de datos             
                    i++;
                }
                else //Caso insertar
                {
                    this.setTri(j, 0, f);
                    this.setTri(j, 1, c);
                    this.setTri(j, 2, d);
                    sw=1;
                }
            }  
            else //Caso insertar
            {
                if(sw!=1)
                {
                    this.setTri(j, 0, f);
                    this.setTri(j, 1, c);
                    this.setTri(j, 2, d);
                    sw=1;  
                }                           
            }
            j++;
        }
        return this;
    }//Fin llenar tripleta
    
    public tripleta eliminarDato()//Regular
    {
       int f, c, d,j=1, k = 1, sw = 0;

        f = Integer.parseInt(JOptionPane.showInputDialog("¿En que fila se encuentra?"));
        if (f < getTri(0, 0) && !(f < 0)) {
            c = Integer.parseInt(JOptionPane.showInputDialog("¿En que columna se encuentra?"));
            d = Integer.parseInt(JOptionPane.showInputDialog("Que dato desea Eliminar: "));
            if (c < getTri(0, 1) && !(c < 0))//En caso de que la posicion exista dentro de los limites
            {                
                while(k<=getTri(0,2))
                {
                    if(getTri(k,0)==f && getTri(k,1)==c && getTri(k,2)==d)
                    {
                        setTri(k,0,-1);
                        setTri(k,1,-1);
                        setTri(k,2,-1);
                        sw=1;
                    }
                    k++;
                }
                k=1;
                if(sw==1)
                {
                    tripleta t1= new tripleta(this.getTri(0, 2));
                    t1.setTri(0, 0, getTri(0,0));//Fila
                    t1.setTri(0, 1, getTri(0,1));//Columna
                    t1.setTri(0, 2, getTri(0,2)-1);//Datos <> 0
                    while(k<=t1.getTri(0, 2))
                    {
                        if(getTri(j,0)!=-1 && getTri(j,1)!=-1)
                        {
                            t1.setTri(k, 0, getTri(j,0));//Fila
                            t1.setTri(k, 1, getTri(j,1));//Columna
                            t1.setTri(k, 2, getTri(j,2));//Datos <> 0
                        }
                        else
                        {
                            j++;
                        }
                        k++;
                    }
                    return t1;
                }              
                else if(sw==0)
                {
                    JOptionPane.showMessageDialog(null, "No se encontro el dato.");
                }
                
            } else {
                if (c > getTri(0, 1)) {
                    JOptionPane.showMessageDialog(null, "La Columna es mayor que la cantidad de filas en la tripleta.");
                } else if (c < 0) {
                    JOptionPane.showMessageDialog(null, "No existen filas menores que 0.");
                }
            }//Fin condicion tamaño de C           
        } else {
            if (f > getTri(0, 0)) {
                JOptionPane.showMessageDialog(null, "La fila  es mayor que la cantidad de filas en la tripleta.");
            } else if (f < 0) {
                JOptionPane.showMessageDialog(null, "No existen filas menores que 0.");
            }
        }//Fin condicion tamaño de f.  
        return this; 
    }
    
    public void Impar()//CASI BUENO
    {
        int i=1,fila , Mimpar;
        
        while (i<=getTri(0,2))
        {    
            Mimpar=0;
            fila=getTri(i,0);
            while(i<=getTri(0,2)&&getTri(i, 0)==fila)
            {
                if ((getTri(i, 2)%2!=0)&&(Mimpar<getTri(i,2)))
                {
                    Mimpar= getTri(i,2);
                }
                i++;               
            }//Fin while  
            if(Mimpar !=0){
                System.out.println("El mayor dato impar de la fila "+fila+" es: "+Mimpar);
            }
        }
            
    }//Fin impar
    public void mayorPromCol()//Revisar con un dato
    {
        int sumC, k = 1, valor = 0, cont=0, prom=0, MProm=0,Mcol=0;
        while (valor <= tri[0][2]) {
            sumC = 0;
            cont=0;
            prom=0;
            while (k <= tri[0][2]) {
                if (tri[k][1] == valor) {
                    sumC += tri[k][2];
                    cont++;                    
                }               
                k++;
            }
            if(sumC !=0)
            {
                prom = sumC/cont;  
                if(prom>MProm)
                {
                    MProm=prom;
                    Mcol=valor;
                }
                
            }          
            valor += 1;
            k = 1;
        }
        System.out.println("El promedio de la columna " + Mcol + " es: " + MProm);
    }
}//Fin class
