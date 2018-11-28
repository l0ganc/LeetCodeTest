import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Caijian {

    public static void main(String[] args) throws IOException {
        BufferedImage bi1 = ImageIO.read(new File("/Users/logan/Desktop/icon.jpg"));
        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
        BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1
                .getHeight());
        Graphics2D g2 = bi2.createGraphics();
        g2.setBackground(Color.WHITE);
        g2.fill(new Rectangle(bi2.getWidth(), bi2.getHeight()));
        g2.setClip(shape);
        // 使用 setRenderingHint 设置抗锯齿
        g2.drawImage(bi1, 0, 0, null);
        g2.dispose();

        try {
            ImageIO.write(bi2, "jpg", new File("/Users/logan/Desktop/2.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
