package edu.muc;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import edu.muc.service.YiWenServices;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.List;

/**
 * Created by gwd on 2016/6/5.
 */
public class IndexController extends Controller {
    private static Logger logger=Logger.getLogger(IndexController.class.getName());
    private static final long serialVersionUID = 1L;
    private static volatile ServletFileUpload upload;
    private final long MAXSize = 4194304*2L;//4*2MB
    private static String filedir="C:\\";
    public IndexController(){
        FileItemFactory factory = new DiskFileItemFactory();// Create a factory for disk-based file items
        this.upload = new ServletFileUpload(factory);// Create a new file upload handler
        this.upload.setSizeMax(this.MAXSize);// Set overall request size constraint 4194304
        filedir="E:/System/Pictures/Ashampoo Snap 7";
        logger.info("Init the defualt upload images path: "+filedir);
        logger.info("IndexContrller has finished building.");
    }

    public void index()	{
        render("index.html");
    }
    @ActionKey("/hello")
    public void test(){
        renderText("this is test.");
    }

    @ActionKey("/upload")
    public void upLoad(){
        ServletContext servletContext=getRequest().getServletContext();
        filedir=getRequest().getServletContext().getRealPath("images");
        String result=null;
        try {
            List<FileItem> items = this.upload.parseRequest(getRequest());
            if(items!=null	&& !items.isEmpty()){

                for (FileItem fileItem : items) {
                    String filename=fileItem.getName();
                    String filepath=filedir+ File.separator+filename;
                    File file=new File(filepath);
                    if(!file.exists())
                        file.getParentFile().mkdirs();
                    InputStream inputSteam= null;
                    BufferedInputStream fis=null;
                    FileOutputStream fos=null;
                    try {
                        inputSteam = fileItem.getInputStream();
                        fis=new BufferedInputStream(inputSteam);
                        fos=new FileOutputStream(file);
                        int f;
                        while((f=fis.read())!=-1)
                        {
                            fos.write(f);
                        }
                        fos.flush();
                        fos.close();
                        fis.close();
                        inputSteam.close();
                        String l=getRequest().getParameter("altitude");
                        String a=getRequest().getParameter("latitude");
                        result= YiWenServices.yiwenScan(file,a,l);
                        result="我觉得就";
                        renderText(result);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();

        }
        renderText("请稍后再试");
    }

    @ActionKey("go")
    public void go(){
       UploadFile uploadFile= getFile();
    }

}
