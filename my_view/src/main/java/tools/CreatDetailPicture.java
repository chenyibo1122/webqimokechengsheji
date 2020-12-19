package main.java.tools;

import main.java.vo.Bankdetail;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class CreatDetailPicture {


    public static BufferedImage creatDetailImage(Bankdetail bankdetail) throws IOException {
        int imageWidth = 500;// 图片的宽度
        int imageHeight = 360;// 图片的高度

        BufferedImage image = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();

        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(Color.black);

        int high = 30;
        int wigth = 30;
        graphics.setFont(new Font("宋体", Font.BOLD, 30));
        graphics.drawString("BankDetail", 100, high);
        graphics.setFont(new Font("宋体", Font.BOLD, 15));
        high += 40;
        graphics.drawLine(20, 40, 480, 40);
        graphics.drawString("操作金额："+bankdetail.getMoney(), wigth, high);
        high += 30;
        graphics.drawString("账户余额："+bankdetail.getSum(),wigth,high);
        high += 30;
        graphics.drawString("操作类型："+bankdetail.getInorout(),wigth,high);
        high += 30;
        graphics.drawString("资金来源或去向："+bankdetail.getByorto(),wigth,high);
        high += 30;
        graphics.drawString("时间："+bankdetail.getTime(),wigth,high);

        graphics.drawImage(ZxingCodeImage.code2Image(bankdetail), 260, 60, null);

        graphics.drawImage(ZxingCodeImage.code1Image(),50,260,null);
        graphics.dispose();
        return image;
    }




    }


