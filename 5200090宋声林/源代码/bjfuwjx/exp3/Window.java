import javax.swing.*;
import java.awt.*;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/06 11:33 AM
 * @Describe:
 */
class Window extends JFrame {
    JPanel left = new JPanel();
    JPanel right = new JPanel();
    //    JPanel rightTop = new JPanel();
    JSplitPane rightTop = new JSplitPane();
    //    JTextArea rightDown = new JTextArea();

    JTextArea rightDown = new JTextArea();


    JButton buttonTop1 = new JButton("绘图");
    JButton buttonTop2 = new JButton("配置样例");
    JSplitPane jSplitPane = new JSplitPane();

    public Window() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setContinuousLayout(true);
        //jSplitPane.setPreferredSize(new Dimension (100,200));
        jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

        left.setSize(700, 600);
        right.setSize(400, 600);

        jSplitPane.setLeftComponent(left);
        jSplitPane.setRightComponent(right);
        jSplitPane.setDividerSize(1);

        jSplitPane.setDividerLocation(700);

        jSplitPane.setEnabled(false);
        setContentPane(jSplitPane);
        //pack();

        buttonTop1.setSize(200, 100);
        buttonTop2.setSize(200, 100);

        rightTop.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        rightTop.setLeftComponent(buttonTop1);
        rightTop.setRightComponent(buttonTop2);
        rightTop.setEnabled(false);
        rightTop.setSize(400,100);
        rightTop.resetToPreferredSizes();
//        rightTop.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        right.add(rightTop);
        setXmlData(rightDown);
        rightDown.setBounds(0, 0, 400, 500);


        JScrollPane jScrollPane = new JScrollPane(rightDown);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.add(jScrollPane);


        left.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        right.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setXmlData(JTextArea field) {
        field.setText("    <bg>\n" +
                "        <col>255,255,255</col>\n" +
                "        <xRange>-0.1, 1.1</xRange>\n" +
                "        <yRange>-0.1, 1.1</yRange>\n" +
                "    </bg>\n" +
                "\n" +
                "    <shape>\n" +
                "        <col>180,180,180</col>\n" +
                "        <wid>1</wid>\n" +
                "        <type>oval</type>\n" +
                "        <!-- type includes oval & rect -->\n" +
                "        <pad>true</pad>\n" +
                "        <center>0.6, 0.8</center>\n" +
                "        <width>0.3</width>\n" +
                "        <height>0.2</height>\n" +
                "    </shape>\n" +
                "\n" +
                "    <shape>\n" +
                "        <col>180,180,180</col>\n" +
                "        <wid>5</wid>\n" +
                "        <type>rect</type>\n" +
                "        <!-- type includes oval & rect -->\n" +
                "        <pad>false</pad>\n" +
                "        <center>0.3, 0.4</center>\n" +
                "        <width>0.3</width>\n" +
                "        <height>0.2</height>\n" +
                "    </shape>\n" +
                "\n" +
                "    <scale>\n" +
                "        <col>black</col>\n" +
                "        <wid>1</wid>\n" +
                "        <direction>x</direction>\n" +
                "        <pos>0.0</pos>\n" +
                "        <from>0</from>\n" +
                "        <step>0.1</step>\n" +
                "        <amount>10</amount>\n" +
                "        <precision>1</precision>\n" +
                "    </scale>\n" +
                "\n" +
                "    <scale>\n" +
                "        <col>black</col>\n" +
                "        <wid>1</wid>\n" +
                "        <direction>y</direction>\n" +
                "        <pos>0</pos>\n" +
                "        <from>0</from>\n" +
                "        <step>0.1</step>\n" +
                "        <amount>10</amount>\n" +
                "        <precision>1</precision>\n" +
                "    </scale>");
    }

}
