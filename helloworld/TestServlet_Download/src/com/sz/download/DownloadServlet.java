package com.sz.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello download servlet GET");
		String fileName = "bb.txt";
		
		String path = getServletContext().getRealPath("download/" + fileName);
		System.out.println(path);
		
		resp.setContentType("text/html;charset=UTF-8");
		//resp.setHeader("Content-Disposition", "attachment; filename="+ fileName);
		InputStream in = new FileInputStream(path);
		
		OutputStream out = resp.getOutputStream();
		byte[] bt = new byte[1024];
		int len = -1;
		
		while ((len = in.read(bt)) !=-1) {
			out.write(bt, 0, len);
		}
		
		out.close();
		in.close();
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("hello download servlet POST");
		doGet(req, resp);
		
		
	}
}
