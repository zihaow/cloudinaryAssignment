package zihaow;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudinary.Api;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

/**
 * Servlet implementation class deleteImage
 */
@WebServlet("/delete/*")
public class deleteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map config = ObjectUtils.asMap(
			  "cloud_name", "zihaow",
			  "api_key", "817596677842685",
			  "api_secret", "kMSiCs8uUbdiqQOyErcCTwzP_vQ");
	
	Cloudinary cloudinary = new Cloudinary(config);
	Api api = cloudinary.api();
       
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = request.getRequestURI();
			String public_id = null;
			int times = 0;
			for(int i=0; i< url.length(); i++){
				char check = '/';
				char current= url.charAt(i);
				if( current == check ){
					times++;
				}
			}
			
			// get public ID from URL.
			String currentString = String.valueOf('/');
			String[] parts = url.split(currentString);
			public_id = parts[times];
			
			// delete from cloudinary.
			api.deleteResources(Arrays.asList(public_id),
					ObjectUtils.emptyMap());
			response.setStatus(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
