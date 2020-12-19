package main.java.tools;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreatVcodeImage {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 30;
    private static final int LENGTH = 4;
    private static final int LINE = 20;
    private static final String STRING = "23456789zxcvbnmasdfghjklqwertyupZXCVBNMASDFGHJKLQWERTYUP";
    Random random = new Random();

    public CreatVcodeImage() {
    }

    public String creatCode() {
        String code = "";

        for(int i = 0; i < 4; ++i) {
            char c = "23456789zxcvbnmasdfghjklqwertyupZXCVBNMASDFGHJKLQWERTYUP".charAt(this.random.nextInt("23456789zxcvbnmasdfghjklqwertyupZXCVBNMASDFGHJKLQWERTYUP".length()));
            code = code + c;
        }

        return code;
    }

    public Color getColor() {
        Color color = new Color(this.random.nextInt(255), this.random.nextInt(255), this.random.nextInt(255));
        return color;
    }

    public Font getFont() {
        Font font = new Font("zzx", 1, 23);
        return font;
    }

    public void drawline(Graphics graphics) {
        for(int i = 0; i < 20; ++i) {
            int x = this.random.nextInt(100);
            int y = this.random.nextInt(30);
            int x1 = this.random.nextInt(20);
            int y1 = this.random.nextInt(22);
            graphics.drawLine(x, y, x + x1, y + y1);
        }

    }

    public void drawcode(Graphics graphics, String codeString) {
        graphics.setFont(this.getFont());

        for(int i = 0; i < 4; ++i) {
            char c = codeString.charAt(i);
            graphics.setColor(this.getColor());
            graphics.drawString(c + "", 20 * i, 20);
        }

    }

    public BufferedImage creatimage(String codeString) {
        BufferedImage image = new BufferedImage(100, 30, 5);
        Graphics graphics = image.getGraphics();
        graphics.setColor(this.getColor());
        graphics.fillRect(0, 0, 100, 30);
        this.drawcode(graphics, codeString);
        this.drawline(graphics);
        graphics.dispose();
        return image;
    }
}
