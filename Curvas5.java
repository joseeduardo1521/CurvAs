import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Curvas5 extends JFrame {
    private BufferedImage buffer;
    private Graphics Pacman;
    public Curvas5() {
        setTitle("Diapositiva 8");
        setSize(500, 500);
        setLayout(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Pacman = buffer.createGraphics();
    }
    public static void main(String[] args) {
        Curvas5 moritas = new Curvas5();
        moritas.setVisible(true);
    }
    public void Pixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
    @Override
    public void paint(Graphics g) {
        CurvaLineaBresehnham(0,10,600, 310,200,15);
    }
    public void CurvaLineaBresehnham( double RM, double RM1, int steps, int y0, int x0,int n){
        double daftsteps = Math.abs(RM1-RM)/(steps-1);
        double y[] = new double[steps];
        double x[] = new double[steps];
        double Flock = RM;
        for (int i = 0; i < steps; i++){
            x[i] = (10*Math.sin(Flock))/(1+Math.pow(Math.cos(Flock),2));
            y[i] = (10*Math.sin(Flock)*Math.cos(Flock))/(1+Math.pow(Math.cos(Flock),2));
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
