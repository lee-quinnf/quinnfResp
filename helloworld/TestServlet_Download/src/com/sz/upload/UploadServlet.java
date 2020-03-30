package com.sz.upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class UploadServlet extends HttpServlet {

	// upload目录，保存上传的资源
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*********文件上传组件： 处理文件上传************/
		
		
		try {
			// 1. 文件上传工厂
			FileItemFactory factory = new DiskFileItemFactory();
			// 2. 创建文件上传核心工具类
			ServletFileUpload upload = new ServletFileUpload(factory);
		
			// 一、设置单个文件允许的最大的大小： 30M
			upload.setFileSizeMax(30*1024*1024);
			// 二、设置文件上传表单允许的总大小: 80M
			upload.setSizeMax(80*1024*1024);
			// 三、 设置上传表单文件名的编码
			// 相当于：request.setCharacterEncoding("UTF-8");
			upload.setHeaderEncoding("UTF-8");
			
			
			// 3. 判断： 当前表单是否为文件上传表单
			if (upload.isMultipartContent(request)){
				// 4. 把请求数据转换为一个个FileItem对象，再用集合封装
				List<FileItem> list = upload.parseRequest(request);
				// 遍历： 得到每一个上传的数据
				for (FileItem item: list){
					// 判断：普通文本数据
					if (item.isFormField()){
						// 普通文本数据
						String fieldName = item.getFieldName();	// 表单元素名称
						String content = item.getString();		// 表单元素名称， 对应的数据
						//item.getString("UTF-8");  指定编码
						System.out.println(fieldName + " " + content);
					}
					// 上传文件(文件流) ----> 上传到upload目录下
					else {
						// 普通文本数据
						String fieldName = item.getFieldName();	// 表单元素名称
						String name = item.getName();			// 文件名				
						String content = item.getString();		// 表单元素名称， 对应的数据
						String type = item.getContentType();	// 文件类型
						InputStream in = item.getInputStream(); // 上传文件流
						
						/*
						 *  四、文件名重名
						 *  对于不同用户readme.txt文件，不希望覆盖！
						 *  后台处理： 给用户添加一个唯一标记!
						 */
						// a. 随机生成一个唯一标记
						String id = UUID.randomUUID().toString();
						// b. 与文件名拼接
						name = id +"#"+ name;
						
						// 获取上传基路径
						String path = getServletContext().getRealPath("/upload");
						// 创建目标文件
						File file = new File(path,name);
						
						// 工具类，文件上传
						item.write(file);
						item.delete();   //删除系统产生的临时文件
						
						System.out.println();
					}
					
				}
				
			}
			else {
				System.out.println("当前表单不是文件上传表单，处理失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	// 手动实现过程
	private void upload(HttpServletRequest request) throws IOException,
			UnsupportedEncodingException {
		/*
		request.getParameter(""); // GET/POST
		request.getQueryString(); // 获取GET提交的数据 
		request.getInputStream(); // 获取post提交的数据   */
		
		/***********手动获取文件上传表单数据************/
		
		//1. 获取表单数据流
		InputStream in =  request.getInputStream();
		//2. 转换流
		InputStreamReader inStream = new InputStreamReader(in, "UTF-8");
		//3. 缓冲流
		BufferedReader reader = new BufferedReader(inStream);
		// 输出数据
		String str = null;
		while ((str = reader.readLine()) != null) {
			System.out.println(str);
		}
		
		// 关闭
		reader.close();
		inStream.close();
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
