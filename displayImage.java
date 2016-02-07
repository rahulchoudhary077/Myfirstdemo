import java.io.*;
import java.net.URLDecoder;
import javax.servlet.*;
import javax.servlet.http.*;

public class displayImage extends HttpServlet {

	private static final int DEFAULT_BUFFER_SIZE = 10240;
	private String imagePath;

	public void init() throws ServletException {

		this.imagePath = "d:/myfolder"; // target path

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Get requested image by path info.

		String requestedImage = request.getPathInfo();

		// Check if file name is actually supplied to the request URI.
		if (requestedImage == null) {

			// Do your thing if the image is not supplied to the request URI.

			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// Decode the file name (might contain spaces and on) and prepare file
		// object.

		File image = new File(imagePath, URLDecoder.decode(requestedImage,
				"UTF-8"));

		// Check if file actually exists in filesystem.

		// Get content type by filename.
		String contentType = getServletContext().getMimeType(image.getName());

		// Init servlet response.
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(image.length()));
		response.setHeader("Content-Disposition",
				"inline;filename=\"" + image.getName() + "\"");

		// Prepare streams.
		BufferedInputStream input = null;
		BufferedOutputStream output = null;

		try {
			// Open streams.
			input = new BufferedInputStream(new FileInputStream(image),
					DEFAULT_BUFFER_SIZE);
			output = new BufferedOutputStream(response.getOutputStream(),
					DEFAULT_BUFFER_SIZE);

			// Write file contents to response.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} finally {
			close(output);
			close(input);
		}
	}

	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}