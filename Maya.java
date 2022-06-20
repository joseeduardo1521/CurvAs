import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author josee
 */
public class Maya extends JFrame {
    private BufferedImage buffer;
    private Graphics Pacman;
    int [] x ={300,305,310,315,320,325,330,335,340,345,350,355,360,365,370,375,380,385,390,395,400,405,410,415,420,425};
    int [] y ={300,305,310,315,320,325,330,335,340,345,350,355,360,365,370,375,380,385,390,395,400,405,410,415,420,425};
    public Maya() {
        setTitle("Figura 3.15");
        setSize(700, 700);
        setLayout(null);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Pacman = buffer.createGraphics();
    }
    public static void main(String[] args) {
        Maya moritas = new Maya();
        moritas.setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
       hola();
    }
    public void Pixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }
    public void LineaBresehnham(int  x0, int y0, int x1, int y1, Color c){
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
    public void hola(){
        for(int i = 0; i<25; i++){
            for(int j = 0; j<25; j++){
               LineaBresehnham(x[i],y[j],x[i+1],y[j],Color.blue);
               LineaBresehnham(x[i],y[j],x[i],y[j+1],Color.blue);
               
               LineaBresehnham(x[25],y[0],x[25],y[25],Color.red);
               LineaBresehnham(x[25],y[0],x[0],y[0],Color.red);
               LineaBresehnham(x[25],y[25],x[0],y[25],Color.red);
               LineaBresehnham(x[0],y[25],x[0],y[0],Color.red);
              
             }
         
            }
    }
}
