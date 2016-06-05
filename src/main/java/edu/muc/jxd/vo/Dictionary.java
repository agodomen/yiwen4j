package edu.muc.jxd.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 2016/6/1.
 * 彝文词典的类，保存了部分的词典内容
 */
public class Dictionary {
    public static Map<String ,String> dic = new HashMap<String, String>();

    public Dictionary(){
        Dictionary.dic.put("0", "月亮");
        Dictionary.dic.put("1", "月亮");
        Dictionary.dic.put("2", "月亮");
        Dictionary.dic.put("3", "月亮");
        Dictionary.dic.put("4", "月亮");
        Dictionary.dic.put("5", "月亮");
        Dictionary.dic.put("6", "月亮");
    }

    /**
     * 获取词典对象
     * @return
     */
    public static Map<String, String> getDic(){
        return Dictionary.dic;
    }
}
