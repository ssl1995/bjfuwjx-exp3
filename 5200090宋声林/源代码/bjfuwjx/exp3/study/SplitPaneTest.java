package study;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/06 10:56 AM
 * @Describe:
 */
public class SplitPaneTest {
    //    new Book("疯狂Java讲义",new ImageIcon("/icons/1.jpeg"),"Java学习资料")
    MyBook[] books = new MyBook[3];

    JFrame jf = new JFrame("测试JSplitPanel");
    JList<MyBook> bookList = new JList<>(books);
    JLabel bookCover = new JLabel();
    JTextArea bookDesc = new JTextArea();

    public void init() {
        MyBook myBook1 = new MyBook("疯狂Java讲义", new ImageIcon("./icons/1.jpeg"), "Java学习资料");
        MyBook myBook2 = new MyBook("疯狂PhP讲义", new ImageIcon("./icons/2.jpeg"), "PhP学习资料");
        books[0] = myBook1;
        books[1] = myBook2;


        bookList.setPreferredSize(new Dimension(150, 300));
        bookCover.setPreferredSize(new Dimension(300, 150));
        bookDesc.setPreferredSize(new Dimension(300, 150));

        bookList.addListSelectionListener(e -> {
            MyBook book = bookList.getSelectedValue();
            bookCover.setIcon(book.getIcon());
            bookCover.setText(book.getDesc());
        });

        JSplitPane leftJSP = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bookCover, bookDesc);

        leftJSP.setEnabled(false);
        leftJSP.setContinuousLayout(false);
        leftJSP.setOneTouchExpandable(false);
        leftJSP.resetToPreferredSizes();

        JPanel rightP = new JPanel();
        JButton jButton1 = new JButton("绘图");
        JButton jButton2 = new JButton("配置样例");

        JSplitPane rightTopJSP = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jButton1, jButton2);

        rightP.add(rightTopJSP);

        Canvas canvas = new Canvas();
        canvas.setSize(111,111);

        JSplitPane allSpiltPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, canvas, bookList);


        allSpiltPane.setEnabled(false);

        jf.add(allSpiltPane);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();

        jf.setVisible(true);


    }

    public static void main(String[] args) {
        new SplitPaneTest().init();
    }
}
