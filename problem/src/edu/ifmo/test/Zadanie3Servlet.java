package edu.ifmo.test;
import java.io.IOException;

import javax.servlet.http.*;

//@SuppressWarnings("serial")
public class Zadanie3Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public static void zad1(String a, String b, HttpServletResponse resp) throws IOException {
		double chis1=Double.parseDouble(a), chis2=Double.parseDouble(b);
		double chisv1=Math.abs(chis1-10);
		double chisv2=Math.abs(chis2-10);
		if (chisv1<chisv2)
		resp.getWriter().println(chis1);
		else
		resp.getWriter().println(chis2);
		}
	
	public static void zad2(String a, String b, String ñ, HttpServletResponse resp) throws IOException {
		double chis3=Double.parseDouble(a), chis4=Double.parseDouble(b), chis5=Double.parseDouble(ñ);
		double d=(chis4*chis4-4*chis3*chis5);
		double x1=((Math.sqrt(d)-chis4)/(2*chis3));
		double x2=(-(Math.sqrt(d)-chis4)/(2*chis3));
		if((d>=0) && (chis3!=0))
			{
			resp.getWriter().println("x1="+x1+","+"x2="+x2);
			}
		else
			{
			resp.getWriter().println("Корней нет");	
			}
		}
	
	public static void zad3(HttpServletResponse resp) throws IOException{
		int[][] mas = new int[8][5];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<5;j++)
			{
				mas[i][j] = Math.round(10+(int)(Math.random()*89));
				resp.getWriter().print(mas[i][j]+" ");
			}
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println();
		
	}
	
	
	public static void zad4(HttpServletResponse resp) throws IOException{
			resp.getWriter().println(" ");		
	}
	
	
	public static void zad5(HttpServletResponse resp) throws IOException{
		int[][] mas = new int[5][8];
		int max=-99;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{
				mas[i][j] = Math.round(-99+(int)(Math.random()*188));
				if (mas[i][j]>max)
					max=mas[i][j];
				resp.getWriter().print(mas[i][j]+" ");
				
			}
			resp.getWriter().println("<br>");
		}
		resp.getWriter().println();
		resp.getWriter().println("<br>");
		resp.getWriter().println("max="+max);
		
	}
	
	public static void zad6(HttpServletResponse resp) throws IOException{
		resp.getWriter().println(" ");		
}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8");
		if (req.getParameter("flag").equals("1"))
			{
			zad1(req.getParameter("chislo1"), req.getParameter("chislo2"), resp);
			}
		else if (req.getParameter("flag").equals("2"))
			{
			zad2(req.getParameter("chislo3"), req.getParameter("chislo4"), req.getParameter("chislo5"), resp);
			}
		else if (req.getParameter("flag").equals("3"))
			{
			zad3(resp);
			}
		else if (req.getParameter("flag").equals("4"))
			{
			zad4(resp);
			}
		else if (req.getParameter("flag").equals("5"))
			{
			zad5(resp);
			}
		else if (req.getParameter("flag").equals("6"))
			{
			zad6(resp);
			}
	}
}