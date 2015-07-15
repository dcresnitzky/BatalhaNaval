/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rc.unesp.br.controllers;

import java.awt.Point;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import rc.unesp.br.beans.Navio;

/**
 *
 * @author Daniel
 */
public class Jogo {
    
    private final int tamanhoNavio = 3;
    private final int tamanhoTabuleiro = 7;
    private final int numeroNavios = 3;
    private int tabuleiro[][];
    private Navio navio;
    private ArrayList<Point> navios;
    private int chances;
    private boolean fim;
    
    public void inicializaJogo(){ 
        int i,j;
        this.navio = new Navio();
        this.tabuleiro = new int[tamanhoTabuleiro][tamanhoTabuleiro];
        this.chances = 0;
        this.fim = false;
        
        this.navio.constroiNavios(numeroNavios,tamanhoTabuleiro,tamanhoNavio);
        this.navios = this.navio.getNavios();

        for (i = 0; i < 7; i++){
            for (j = 0; j < 7; j++){
                tabuleiro[i][j] = -1;
            }
        }        
    }
        
    public boolean atirar(int x, int y){
        Point p = new Point(x,y);
        this.chances++;
        if (this.navios.contains(p)){
            this.navios.remove(p);
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/rc/unesp/br/resources/hit.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            fimDeJogo();
            return true;
        } else{
              try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/rc/unesp/br/resources/miss.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            return false;
        }
    }

        /**
         * @return the chances
         */
    public int getChances() {
        return chances;
    }
    
    public Navio getNavio() {
        return navio;
    }

    private void fimDeJogo() {
        if (this.navios.isEmpty()){
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/rc/unesp/br/resources/end.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            this.fim = true;
        }
    }

    /**
     * @return the fim
     */
    public boolean isFim() {
        return fim;
    }
}
