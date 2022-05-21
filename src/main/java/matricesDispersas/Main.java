/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package matricesDispersas;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author sala306
 */
public class Main {

    public static void main(String[] args)
    {
        //Instancias de objetos
        tripleta t1;
        tripleta t2;
        tripleta t3;
        
        int opc= 0;//Variable de opcion
        Random aleatorio=new Random();//Random god
        int mat[][]=new int[3][3], sw=0,Dif0=0;
        int n = mat.length, m = mat[0].length; //NxM se definen              
        for (int i = 0; i < mat.length; i++)//Llenar de 0.
        {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j]= 0;
            }
        }//fin de llenar de 0.
        System.out.println("Matriz con 0: \n");
        for (int i = 0; i < mat.length; i++)//Mostrar 0
        {
            for (int j = 0; j <mat[0].length; j++) {
                System.out.print("|"+mat[i][j]+"|");
            }
            System.out.println("");
        }//Fin Mostrar 0
        System.out.println("Matriz Dispersa: ");
        for (int i = 0; i < n*m; i++)//Generador de numeros aleatorios
        {
            if (sw==0)
            {
                mat[aleatorio.nextInt(4-1)][aleatorio.nextInt(4-1)]=aleatorio.nextInt(99);
                sw=1;
                Dif0+=1;
            }
            else
            {
                if (i<(n*m)/2)
                {
                    sw=0;
                }
            }
        }//Fin de generador de numeros aleatorios     
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j <mat[0].length; j++) {
                System.out.print("|"+mat[i][j]+"|");
            }
            System.out.println("");
        }// Mostrar
        
        do {
            opc= menu();
            switch (opc) {
                case 1://tripleta
                    opc=menuT();
                    t1= new tripleta(Dif0+1);
                    t1.Crear(n,m,Dif0+1,mat);//Funciona                 
                    switch (opc) {
                        case 1://Suma de filas.
                            System.out.println("Suma de filas:");
                            t1.sumaFilas();//Funciona
                            break;
                        case 2://Suma de columnas.
                            System.out.println("Suma de columnas: n");
                            
                            break;
                        case 3://Insertar Dato
                            
                            break;
                        case 4://Eliminar Dato
                            
                            break;
                        case 5:
                            
                            break;
                        case 6:
                            
                            break;
                        case 7:
                            
                            break;
                        case 8:
                            
                            break;
                        case 9://Mostrar
                            if(t1.getTri(0,2)!= 0)
                            {
                                System.out.println("Tripleta: ");
                                t1.mostrar();//Funciona
                            }
                            else
                            {
                                JOptionPane.showConfirmDialog(null, "La tripleta esta vacia");
                            }
                            break;
                        case 10:
                            
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"La opcion ingresada es incorrecta, por favor ingrese otra opcion");
                            break;
                    }
                    
                    opc=0;
                    break;
                    
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"La opcion ingresada es incorrecta, por favor ingrese otra opcion");
                    break;
            }
        
        } while (opc!=5);
        
        
        
        
    }
    
    public static int menu()
    {
        return Integer.parseInt(JOptionPane.showInputDialog("---MENU MATRICES DISPERSAS---\n"
        +"1. Ingresar Tripleta\n"
        +"2. Ingresar Forma 1\n"
        +"3. Ingresar Forma 2 \n"
        +"4.Reiniciar matriz base\n"
        +"5. Salir\n"
        +"Ingrese una opcion: "));
    }
    public static int menuT()
    {
        return Integer.parseInt(JOptionPane.showInputDialog("---MENU TRIPLETA---\n"
        +"1. Suma de filas\n"
        +"2. Suma de Columnas\n"
        +"3. Insertar Dato \n"
        +"4. Eliminar dato\n"
        +"5. Mostrar mayor dato impar (Fila)\n"
        +"6. Mostrar la columna con mayor promedio\n"
        +"7. Suma de diagonal Principal\n"
        +"8. Suma Diagonal secundaria\n"
        +"9. Mostrar tripleta\n"
        +"10.Volver\n"
        +"Ingrese una opcion: "));
    }
}//Fin main