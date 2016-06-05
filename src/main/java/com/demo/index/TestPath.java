package com.demo.index;

import edu.muc.service.YiWenServices;

import java.io.File;

/**
 * Created by gwd on 2016/6/5.
 */
public class TestPath {
    public static void main(String args[]){
        String path=TestPath.class.getResource("/").getPath();
        File file=new File(path);
        if(file.exists())
            System.out.println("this is a file");
        YiWenServices.yiwenScan(new File("D:\\Project\\Java\\Yiwen4j\\out\\artifacts\\Yiwen4j\\images\\1.png"),"assd","sdkfjsdjf");


    }
}
