package com.test.audio;

import com.test.res.TankResource;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class Audio {
    
    static  final  String BASE_URL="/Users/suncheng/Downloads/tank01/res/snd/";
    static  final  String START=BASE_URL+"start.wav";
    static  final  String HIT=BASE_URL+"hit.wav";
    static  final  String FIRE=BASE_URL+"fire.wav";
    static  final  String JOIN=BASE_URL+"add.wav";
    
    
    
    
    public  void play(AuditType auditType)  {
        
        
        
        try {
            

        String file ="";

        switch (auditType){
            
            case HIT: file=HIT;break;
            case START: file=START;break;
            case FIRE: file=FIRE;break;
            case ADD: file=JOIN;break;
            default:file=START;break;
            
        }
        
        
        
        AudioFormat audioFormat = null;
        SourceDataLine sourceDataLine = null;
        DataLine.Info dataLine_info = null;
        AudioInputStream audioInputStream = null;
        TankResource tankResource = new TankResource();

        audioInputStream = AudioSystem.getAudioInputStream(new File(file));
        audioFormat = audioInputStream.getFormat();
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

        }catch (Exception e ){
            
            
            e.printStackTrace();
        }


    }
}
