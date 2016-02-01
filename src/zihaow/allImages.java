package zihaow;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudinary.*;
import com.cloudinary.utils.*;

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
		PrintWriter url = response.getWriter();
		try {
			Map result = api.resourcesByTag("all", ObjectUtils.emptyMap());
			String imageURL = (String) result.get("secure_url");
			url.print(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
