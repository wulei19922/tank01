package com.test.test;

import com.test.res.TankResource;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/


public class Test {


    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {


        AudioFormat audioFormat = null;
        SourceDataLine sourceDataLine = null;
        DataLine.Info dataLine_info = null;
//  private String file = "D:/workspace_mars/wav/src/main/resources/music/12.wav";
        String file = "/Users/suncheng/Downloads/tank01/res/snd/fire.wav";
        AudioInputStream audioInputStream = null;
        TankResource tankResource = new TankResource();

//        BufferedImage read = ImageIO.read(new File(tankResource.getTK_LEFT()));


        audioInputStream = AudioSystem.getAudioInputStream(new File(file));
        audioFormat = audioInputStream.getFormat();
        System.out.println("每秒播放帧数：" + audioFormat.getSampleRate());
        System.out.println("总帧数：" + audioInputStream.getFrameLength());
        System.out.println("音频时长（秒）：" + audioInputStream.getFrameLength() / audioFormat.getSampleRate());
        dataLine_info = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLine_info);


        byte[] b = new byte[1024];
        int len = 0;
        sourceDataLine.open(audioFormat, 1024);
        sourceDataLine.start();
        while ((len = audioInputStream.read(b)) > 0) {
            sourceDataLine.write(b, 0, len);
        }
        audioInputStream.close();
        sourceDataLine.drain();
        sourceDataLine.close();



    }
}
