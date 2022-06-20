/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Curvas3 extends JFrame {
    private BufferedImage buffer;
    private Graphics Pacman;
    public Curvas3() {
        setTitle("Curva 3.4");
        setSize(500, 500);
        setLayout(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Pacman = buffer.createGraphics();
    }
    public static void main(String[] args) {
        Curvas3 uvitas = new Curvas3();
        uvitas.setVisible(true);
    }
    public void Pixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
    @Override
    public void paint(Graphics g) {
        CurvaLineaBresehnham(0,Math.PI*2,600, 400,250,20);
    }
    public void CurvaLineaBresehnham( double RM, double RM1, int steps, int y0, int x0,int n){
        double daftsteps = Math.abs(RM1-RM)/(steps-1);
        double y[] = new double[steps];
        double x[] = new double[steps];
        double Flock = RM;
        for (int i = 0; i < steps; i++){
            y[i] = Flock;
            x[i] = y[i]*(Math.cos(Flock*4));
            Flock += daftsteps;
        }
        for (int i = 0; i<steps-1; i++){
            LineaBresehnham(x0+(int)Math.round(x[i]*n),y0 - (int)Math.round(y[i]*n),x0+(int)Math.round(x[i+1]*n),y0- (int)Math.round(y[i+1]*n), Color.BLACK);
        }
    }
  public void LineaBresehnham(int x0, int y0, int x1, int y1, Color c){
    float steps;
    float dx= x1-x0;
    float dy=y1-y0;
    if(Math.abs(dx)>Math.abs(dy)){
        steps = Math.abs(dx);
    }else{
        steps = Math.abs(dy);
    }
    float xinc = dx/steps;
    float yinc = dy/steps;
    float x = x0;
    float y = y0;
    Pixel(Math.round(x),Math.round(y),c);
    for(int i=1; i<=steps; i++){
        x +=xinc;
        y +=yinc;
        Pixel(Math.round(x),Math.round(y),c);
    }
  }
}
