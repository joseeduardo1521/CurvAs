/*
Figura 3.17
Falta bien la implementación
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Curvas7 extends JFrame {
    private BufferedImage buffer;
    private Graphics Pacman;
    public Curvas7() {
        setTitle("Figura 3.17");
        setSize(500, 500);
        setLayout(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Pacman = buffer.createGraphics();
    }
    public static void main(String[] args) {
        Curvas6 moritas = new Curvas6();
        moritas.setVisible(true);
    }
    public void Pixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
    @Override
    public void paint(Graphics g) {
        CurvaLineaBresehnham(0,Math.PI*2,200, 100,100,5);
    }
    public void CurvaLineaBresehnham( double RM, double RM1, int steps, int y0, int x0,int n){
        double daftsteps = Math.abs(RM1-RM)/(steps-1);
        double y[] = new double[steps];
        double x[] = new double[steps];
        double Flock = RM;
        for (int i = 0; i < steps; i++){
            x[i] = (17*Math.cos(Flock))+7*((Math.cos(Flock*2.428571429)));
            y[i] = (17*Math.sin(Flock))-7*((Math.sin(Flock*2.428571429)));;
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
