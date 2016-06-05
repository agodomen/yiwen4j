package edu.muc.service;

import com.demo.index.TestPython;
import edu.muc.jxd.vo.YiCharacterDao;
import edu.muc.jxd.vo.YiCharcter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by gwd on 2016/6/5.
 */
public class YiWenServices {

    public static String yiwenScan(File file, String altitude, String latitude){
        File yiwen=new File("D:\\Project\\PycharmProjects\\YiCharacterPredict\\data\\src.png");
        try {
            FileUtils.copyFile(file,yiwen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id= TestPython.execPython("D:\\Project\\PycharmProjects\\YiCharacterPredict\\src\\Predict.py",null);
        YiCharcter charcter = new YiCharcter(altitude, latitude,id,yiwen.getPath());
        YiCharacterDao dao = new YiCharacterDao();
        dao.addYiCharacter(charcter);
        return  charcter.getMeaning();
    }

}
