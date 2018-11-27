package com.jd.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jd.test.Timerhelp;


/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/fileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileServlet() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		System.out.println(op);
		if("upLoad".equals(op)){
			upLoad(request,response);
		}
		
	}

	protected void upLoad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upLoad = new ServletFileUpload(factory);
		
		if(ServletFileUpload.isMultipartContent(request)){
			try {
				List<FileItem> list = upLoad.parseRequest(request);
				HttpSession session = request.getSession();
				String fileName = null;
				String fileDesc = null;
				String autoName = null;
				String userName = "admin";
				for(FileItem item : list){
					if(item.isFormField()){
						String name = item.getFieldName();
						String value = item.getString("utf-8");
						if("fileName".equals(name)){
							fileName = value;
						}else if("fileDesc".equals(name)){
							fileDesc = value;
						}
					}else{
						InputStream in = item.getInputStream();
						
						String name = item.getName();
						System.out.println("上传来的文件名 : "+name);
						
						String ext = name.substring(name.lastIndexOf('.'));
						System.out.println("文件扩展名 : "+ext);
						autoName = Timerhelp.getTime()+ext;
						System.out.println("存储在服务器上的名字 : "+autoName);
						
						String realPath = getServletContext().getRealPath("/upload");
						File file = new File(realPath,autoName);
						file.createNewFile();
						
						FileOutputStream out = new FileOutputStream(file);
						byte[] buf = new byte[1024];
						int len = buf.length;
						while((len=in.read(buf)) > 0){
							out.write(buf, 0, len);
						}
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
