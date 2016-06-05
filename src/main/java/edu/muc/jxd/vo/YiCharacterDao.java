package edu.muc.jxd.vo;

import java.util.HashMap;

import edu.muc.jxd.hbase.HBaseVO;
import edu.muc.jxd.hbase.HBaseVODao;

public class YiCharacterDao {

	public boolean addYiCharacter(YiCharcter yi) {
		HBaseVODao dao = new HBaseVODao();
		return dao.saveVO(YiCharacterDao.yi2HBaseVo(yi));
	}

	/**
	 * 将一个yiCharacter转化为HBaseVo对象
	 * 
	 * @param yiCharcter
	 * @return
	 */
	public static HBaseVO yi2HBaseVo(YiCharcter yiCharcter) {
		HBaseVO vo = new HBaseVO();
		String tableName = "YiCharacter";
		String rowKey = yiCharcter.getRowkey();
		vo.setRowKey(rowKey);
		vo.setTableName(tableName);
		// 所有的属性 familyName columnName value
		HashMap<String, HashMap<String, String>> valueMap = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> qualifierMap = new HashMap<String, String>();
		// 设置属性
		qualifierMap.put("meaning", yiCharcter.getMeaning());
		qualifierMap.put("imageUrl", yiCharcter.getImgUrl());
		valueMap.put("info", qualifierMap);
		vo.setValueMap(valueMap);
		return vo;
	}

	public static void main(String[] args) {
		YiCharcter yi = new YiCharcter("40.1213455", "116.35459627", "0", "/upload/12345342.jpg");
		YiCharacterDao dao = new YiCharacterDao();
		boolean x = dao.addYiCharacter(yi);
		System.out.println(x);
	}
}
