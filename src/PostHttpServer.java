import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostHttpServer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain; charset=UTF-8");
		String data = readData(request);
		response.setStatus(200);
		// JSONObject jsonObject=JSONObject.parseObject(jsonString);
		System.out.println("POST: " + data);
		response.getWriter().print(data);
	}

	public static String readData(HttpServletRequest request) {
		StringBuffer data = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				data.append(line);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return data.toString();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String params = request.getQueryString();
		response.setContentType("text/plain; charset=UTF-8");
		response.setStatus(200);
		System.out.println("QueryString: " + params);
		response.getWriter().print(params);
	}

}