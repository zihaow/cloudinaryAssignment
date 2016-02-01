package zihaow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

/**
 * Servlet implementation class uploadPhoto
 */
@WebServlet("/getPost")
@MultipartConfig
public class uploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Cloudinary set up.
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
		  "cloud_name", "zihaow",
		  "api_key", "817596677842685",
		  "api_secret", "kMSiCs8uUbdiqQOyErcCTwzP_vQ"));
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter url = response.getWriter();
		String URL_IS = request.getParameter("url_address");
		System.out.println(URL_IS);
		
		Map uploadParams = ObjectUtils.asMap(
		  "tags", "all"
		);
		
		//http://web.cs.dal.ca/~zihaow/wu/images/bg.jpg
		Map uploadResult = cloudinary.uploader().upload(URL_IS, uploadParams);
		
		// get public ID for uploaded photo from returned JSON Object.
		String publicId = (String) uploadResult.get("public_id");
		String imageURL = (String) uploadResult.get("secure_url");
		
		if(uploadResult != null) {
			url.print("Image uploaded successfully");
			url.print("\n");
			url.print(publicId);
			url.print("\n");
			url.print(imageURL);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("whatTheHell", imageURL);
			dispatcher.forward(request,response); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter url = response.getWriter();
		
		Part filePart = request.getPart("file"); 
		InputStream fileContent = filePart.getInputStream();
	    
	    // Upload photo locally
		// Use the file name for its public ID name.
		Map params = ObjectUtils.asMap(
				  "tags", "all",
				  "use_filename", true
				);
		
		// convert inputstream to file format.
		// reference from: http://www.mkyong.com/java/how-to-convert-inputstream-to-file-in-java/
		OutputStream outputStream = null;
		String newFile = "newPhoto.png";
		
		try {
			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(new File(newFile));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = fileContent.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileContent != null) {
				try {
					fileContent.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
				
		// Upload photo to cloudinary, uploadResult is the returned JSON Object.
		Map uploadResult = cloudinary.uploader().upload(newFile, params);
		
		// get public ID for uploaded photo from returned JSON Object.
		String publicId = (String) uploadResult.get("public_id");
		String imageURL = (String) uploadResult.get("secure_url");
				
		if(uploadResult != null) {
			url.print("Image uploaded successfully");
			url.print("\n");
			url.print(publicId);
			url.print("\n");
			url.print(imageURL);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("whatTheHell", imageURL);
			dispatcher.forward(request,response); 
		}
	}
}
