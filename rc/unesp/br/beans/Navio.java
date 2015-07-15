/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.beans;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Navio {
    private ArrayList<Point> navios;
    
    public void constroiNavios(int numeroNavios,int tamanhoTabuleiro, int tamanhoNavio){
        int k,x,y;
        boolean vertical;
        Point ponto1;
        Point ponto2;
        Point ponto3;
        Random gerador = new Random();
        
        this.navios = new ArrayList();

        for (k = 0; k < numeroNavios; k++){
            x = gerador.nextInt(tamanhoTabuleiro-tamanhoNavio);
            y = gerador.nextInt(tamanhoTabuleiro-tamanhoNavio);
            vertical = gerador.nextBoolean();
            if (vertical){
                    ponto1 = new Point(x,y);
                    ponto2 = new Point(x,y+1);
                    ponto3 = new Point(x,y+2);
                    if ( !this.navios.contains(ponto1) && !this.navios.contains(ponto2) && !this.navios.contains(ponto3)){
                        this.navios.add(ponto1);this.navios.add(ponto2);this.navios.add(ponto3);
                    } else k--;
               
            }else{
                
                
                    ponto1 = new Point(x,y);
                    ponto2 = new Point(x+1,y);
                    ponto3 = new Point(x+2,y);
                    if ( !this.navios.contains(ponto1) && !this.navios.contains(ponto2) && !this.navios.contains(ponto3)){
                        this.navios.add(ponto1);this.navios.add(ponto2);this.navios.add(ponto3);
                    } else k--;
                
            }
        }
        
    }

    public ArrayList<Point> getNavios() {
        return navios;
    }
    
    public void imprimeNavios(){
        for(Point p : this.navios) {  
            System.out.println(p.toString());  
        }  
    }
}
