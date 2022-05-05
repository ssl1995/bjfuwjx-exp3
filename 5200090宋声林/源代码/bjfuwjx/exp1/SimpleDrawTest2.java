
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class SimpleDrawTest2 {
    private final String OVAL_SHAPE = "oval";
    private final String RECT_SHAPE = "rect";
    private final String ARC_SHAPE = "arc";

    private JFrame frame = new JFrame("简单绘图");
    private JButton arcButton = new JButton("绘制圆弧");
    private JButton recButton = new JButton("绘制矩形");
    private JButton ovalButton = new JButton("绘制椭圆");
    MyCanvas2 myCanvas = new MyCanvas2();
    public String shape = "";
    Panel panel = new Panel();


    public void init() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                System.exit(0);
            }
        });
        arcButton.addActionListener(e -> {
            shape = ARC_SHAPE;
            myCanvas.repaint();
        });
        recButton.addActionListener(e -> {
            shape = RECT_SHAPE;
            myCanvas.repaint();
        });
        ovalButton.addActionListener(e -> {
            shape = OVAL_SHAPE;
            myCanvas.repaint();
        });

        myCanvas.setPreferredSize(new Dimension(600, 800));
        panel.add(arcButton);
        panel.add(recButton);
        panel.add(ovalButton);
        frame.add(myCanvas);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new SimpleDrawTest2().init();
    }

    class MyCanvas2 extends Canvas {
        @Override
        public void paint(Graphics g) {
            var rand = new Random();
            if (shape.equals(OVAL_SHAPE)) {
                g.setColor(new Color(100, 80, 200));
                g.fillOval(
                        rand.nextInt(1500), rand.nextInt(800), 200, 100
                );
            }
            if (shape.equals(RECT_SHAPE)) {
                g.setColor(new Color(0, 100, 180));
                g.fillRect(rand.nextInt(1500), rand.nextInt(800), 150, 120
                );
            }
            if (shape.equals(ARC_SHAPE)) {
                g.setColor(new Color(200, 0, 100));
                g.fillArc(rand.nextInt(1500), rand.nextInt(800), 180, 180, 0, 360
                );
            }
        }
    }


}

