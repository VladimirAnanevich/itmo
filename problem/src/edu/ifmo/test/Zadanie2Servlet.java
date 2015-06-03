package edu.ifmo.test;

import java.io.IOException;

import javax.servlet.http.*;

public class Zadanie2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setCharacterEncoding("UTF-8");

		try {
			int frst = Integer.valueOf(req.getParameter("first"));
			int scnd = Integer.valueOf(req.getParameter("second"));
			int flag = Integer.valueOf(req.getParameter("flag"));
			if (flag == 1) {
				getSymbols(frst, scnd, resp);
			}
			if (flag == 2) {
				getSymbolsHex(frst, scnd, resp);
			}
		} catch (NumberFormatException e) {
			resp.getWriter().println("Введите верные значения!");
		}

	}

	public void getSymbols(int frst, int scnd, HttpServletResponse resp)
			throws IOException {
		int k = 0;
		if ((frst > 0) && (frst < 65535) && (scnd > 0) && (scnd < 65535)
				&& (frst < scnd)) {
			resp.getWriter().println("<table id=\"result_table\"><tr>");
			for (int i = frst; i < scnd + 1; i++) {
				if (k == 15) {
					resp.getWriter().println("</tr><tr>");
					k = 0;
				}
				char ch = (char) i;
				String t = intToHex(i);
				resp.getWriter().println("<td>" + ch + "</td>");
				k++;
			}

			resp.getWriter().println("</table></tr>");
		} else {
			resp.getWriter().println("Введите корректные значения!");
		}
	}
		
	public void getSymbolsHex(int frst, int scnd, HttpServletResponse resp)
			throws IOException {
		int k = 0;
		if ((frst > 0) && (frst < 65535) && (scnd > 0) && (scnd < 65535)
				&& (frst < scnd)) {
			resp.getWriter().println("<table id=\"result_table\"><tr>");
			for (int i = frst; i < scnd + 1; i++) {
				if (k == 15) {
					resp.getWriter().println("</tr><tr>");
					k = 0;
				}
				char ch = (char) i;
				String t = intToHex(i);
				resp.getWriter().println("<td><b>" + ch +"</b><br>" + i + "<br>" + t + "</td>");
				k++;
			}

			resp.getWriter().println("</table></tr>");
		} else {
			resp.getWriter().println("Введите корректные значения!");
		}
	}

	public String intToHex(int q) {
		String tmp = "";
		while (q > 0) {
			int r = q % 16;
			if (r > 9) {
				r = r + (int) 'A' - 10;
			} else {
				r = r + (int) '0';
			}
			tmp = (char) r + tmp;
			q = q / 16;
		}
		while (tmp.length() < 4) {
			tmp = "0" + tmp;
		}
		tmp = "0x" + tmp;
		return tmp;
	}

}