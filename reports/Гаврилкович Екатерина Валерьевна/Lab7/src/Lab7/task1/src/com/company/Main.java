import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.AffineTransform;
public class Main {
    public static void main(String[] args){
        JFrame fr=new JFrame("Вращение треугольника вокруг своего центра тяжести");
        fr.setPreferredSize(new Dimension(300,300));
        final JPanel pan= new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        Timer tm= new Timer(20, new ActionListener(){//скорость вращения
            int i=0,
                    r=0,
                    g=0,
                    b=0;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                r+=1;
                g+=2;
                b+=3;
                if (r>=255)r = 0;
                if (g>=255)g = 0;
                if (b>=255)b = 0;
                Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);
                gr.setPaint ( new Color(r, g, b));
                GeneralPath path=new GeneralPath();
                path.append(new Polygon(new int []{60,-80},new int[]{-60,-50},2),true);//координаты линии иотрисовка
                int x=(60-80)/2,y=(-60-50)/2;
                gr.translate(150, 150);// положение в окне линии
                AffineTransform tranforms = AffineTransform.getRotateInstance((i++)*0.1, x, y);//угол поворота
                gr.transform(tranforms);
                gr.draw(path);

            }
        });
        tm.start();
    }
}