package zihaow;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.cloudinary.json.JSONObject;
import com.cloudinary.*;
import com.cloudinary.utils.*;
import com.google.gson.Gson;

/**
 * Servlet implementation class allImages
 */
@WebServlet("/all")
public class allImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map config = ObjectUtils.asMap(
			  "cloud_name", "zihaow",
			  "api_key", "817596677842685",
			  "api_secret", "kMSiCs8uUbdiqQOyErcCTwzP_vQ");
	
	Cloudinary cloudinary = new Cloudinary(config);
	Api api = cloudinary.api();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		try {
			Map result = api.resourcesByTag("all", ObjectUtils.emptyMap());
			Gson gson = new Gson();
		    String jsonString = gson.toJson(result);
		    json = new JSONObject(jsonString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
	}
}
