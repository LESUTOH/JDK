package com.hollyland.byteDeco;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author Lesuto
 * @Date：2022/10/21 10:18
 * @description xxx
 */
public class VideoUtils implements MultipartFile {

    private final byte[] imgContent;
    private final String header;

    public VideoUtils(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header;
    }

    public static void main(String[] args) {
        File file = new File("E:/IdeaProject/JDK/Collection/target/classes/test.mp4");
        System.out.println(file.getPath());
//        String s = fetchFrame(file);
    }


    public static String fetchFrame(File video) {
        FFmpegFrameGrabber ff = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ff = new FFmpegFrameGrabber(video);
            ff.start();
            int length = ff.getLengthInFrames();
            System.out.println(length);
            System.out.println(ff.getFormatContext().duration() / 1000000);
            int i = 0;
            Frame f = null;
            while (i < length) {
                // 过滤前五帧，避免出现全黑
                f = ff.grabFrame();
                if (i > 5 && f.image != null) {
                    break;
                }
                i++;
            }
            BufferedImage bi = new Java2DFrameConverter().getBufferedImage(f);
            String rotate = ff.getVideoMetadata("rotate");
            if (rotate != null) {
                bi = rotate(bi, Integer.parseInt(rotate));
            }
            ImageIO.write(bi, "jpg", os);


        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ff != null) {
                    ff.stop();
                }
            } catch (FrameGrabber.Exception e) {
                e.printStackTrace();
            }
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return "data:image/jpg;base64," + encoder.encode(os.toByteArray());
    }

    private static BufferedImage rotate(BufferedImage src, int angle) {
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);
        int type = src.getColorModel().getTransparency();
        Rectangle rect_des = calcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), angle);
        return null;
    }

    private static Rectangle calcRotatedSize(Rectangle src, int angle) {
        if (angle >= 90) {
            if (angle / 90 % 2 == 1) {
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angle = angle % 90;
        }
        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angle) / 2) * r;
        double angleAlpha = (Math.PI - Math.toRadians(angle)) / 2;
        double angleDaltaWidth = Math.atan((double) src.height / src.width);
        double angleDaltaHeight = Math.atan((double) src.width / src.height);
        int lenDaltaWidth = (int) (len * Math.cos(Math.PI - angleAlpha - angleDaltaWidth));
        int lenDaltaHeight = (int) (len * Math.cos(Math.PI - angleAlpha - angleDaltaHeight));
        int des_width = src.width + lenDaltaWidth * 2;
        int des_height = src.height + lenDaltaHeight * 2;
        return new Rectangle(new Dimension(des_width, des_height));
    }

    public static MultipartFile base64ToMultipart(String base64) {
        try {
            String[] baseStrs = base64.split(",");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = new byte[0];
            bytes = decoder.decodeBuffer(baseStrs[1]);

            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            return new VideoUtils(bytes, baseStrs[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getName() {
        return System.currentTimeMillis() + Math.random() + "." + header.split("/")[1];
    }

    @Override
    public String getOriginalFilename() {
        return System.currentTimeMillis() + Math.random() * 10000 + "." + header.split("/")[1];
    }

    @Override
    public String getContentType() {
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }
}