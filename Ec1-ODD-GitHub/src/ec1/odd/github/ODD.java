/*
Nombre: José Alejandro Quiroa Martínez
Carnet: 5090-18-2169
Fecha: 1/8/2019
 */
package ec1.odd.github;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class ODD extends Applet {
    String tmp;
    int n,c=0,y,i,j;
    /*
    tmp=Ingreso de datos por el usuario
    n=Ingreso de datos por el usuario transformado a integer
    c=Centinela inicializado en 0 (Corrige un bug del programa (¡NO ELIMINAR!))
    y=Posicion en el eje y
    */
    public void init(Graphics g) {//funcion principal de la clase
        do{
            tmp=JOptionPane.showInputDialog("Ingrese la cantidad de datos que\n"
                                          + "tendra el arreglo, el numero debe\n"
                                          + "de ser mayor a 0 (n>0), o seleccione\n"
                                          + "0 para salir del programa.\n\n");
            n=Integer.parseInt(tmp);
            if (n<0){
                JOptionPane.showMessageDialog(null, n+" no es una cantidad de datos valida\n"
                                                    + "Porfavor seleccione un numero mayor\n"
                                                    + "a 0 (n>0).\n\n");
            }     
            if (n>0){
                paint(g);
            }
            }while (n!=0);
        JOptionPane.showMessageDialog(null,"Gracias por visitarnos, porfavos\n"
                                         + "vuelva pronto.\n\n");
        System.exit(0);
    }
    
    public void paint (Graphics g){//Funcion para mostrar los arreglos "Ordenado" y "Original"
        //Inicia la correccion de un bug ocacionado por "Graphics g"
        if (c==0){
            c=1;
            init(g);
        }
        //Finaliza la correccion del bug
        int[] ar=new int[n]; //Variable para arreglo original
        int[] nar=new int[n]; //Variable para arreglo ordenado
        for (i=0;i<n;i++){ //Llenado del arreglo
            ar[i]=1+(int)(Math.random()*n);//Seleccion de numero random para el arreglo
            nar[i]=ar[i]; //igualacion de arreglos
        }
        int b,t;
        /*
        b: variable centinela
        t: variable temporal
        */
        do{ //Siclo repetitivo que continua asta que todos los datos esten ordenados
            b=0; //inicializacion de variable centinela en 0 (falso)
            for (i=0;i<(n-1);i++){ //Recorrido del arreglo en busca de datos no ordenados
                if (nar[i]>nar[i+1]){ //Ordenamiento de datos (si es que se encuentran desordenados)
                    t=nar[i]; //Se almasena temporalmente el dato mayor
                    nar[i]=nar[i+1]; //Se corre la posicion del dato menor
                    nar[i+1]=t; //Se realmasena el dato mayor en la posicion anterior del dato menor
                    b=1;//Asignacion de variable centinela en 1 (verdadero)
                }//Fin del siclo if
            }//Fin del siclo for
        }while(b==1); //Verifica que el siclo for alla terminado su recorrido sin tener que entrar al condicional if
        g.drawString("...Arreglo...",100,20);
        g.drawString("Original:",70,40);
        y=60;
        for (i=0;i<n;i++){ //Presentacion del arreglo original
            g.drawString(""+ar[i],90,y);
            y+=15;
        }
        g.drawString("Ordenado:",150,40);
        y=60;
        for (i=0;i<n;i++){ //Presentacion del arreglo ordenado
            g.drawString(""+nar[i],170,y);
            y+=15;
        }
        //Inicia cronometro a 10 seg. aprox "1seg = 2500u en i y 99999 en j"
        for (i=0;i<=25000;i++){
            for(j=0;j<=99999;j++);
        }
        //Finaliza cronometro
    }
}
