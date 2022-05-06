package study;

import javax.swing.*;

/**
 * @Author: SongShengLin
 * @Date: 2022/05/06 12:42 PM
 * @Describe:
 */
public class MyBook {

    private String name;
    private Icon icon;
    private String desc;

    public MyBook(String name, Icon icon, String desc) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public String getDesc() {
        return this.desc;
    }

    public String toString() {
        return this.name;
    }

}
