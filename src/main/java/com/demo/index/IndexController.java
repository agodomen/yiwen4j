package com.demo.index;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.sun.glass.ui.SystemClipboard;

/**
 * IndexController
 */

public class IndexController extends Controller {
	public void index() {
		render("index.html");
	}
	@ActionKey("/hellow")
	public void test(){
		renderText("this is test.");
	}

	@ActionKey("/upload")
	public void upLoad(){
		UploadFile files=getFile();
		String name=files.getFileName();
		System.out.print("......"+name+"......");
	}

}





