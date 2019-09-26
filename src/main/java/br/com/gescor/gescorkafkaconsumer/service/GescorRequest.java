package br.com.gescor.gescorkafkaconsumer.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class GescorRequest {

	public String sendJsonArray(String url, String json) {
		
		try {

			HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();

			try {
				request.setDoOutput(true);
				request.setDoInput(true);

				request.setRequestProperty("Content-Type", "application/json");

				request.setRequestMethod("POST");

				request.connect();

				OutputStream outputStream = request.getOutputStream();
				try {
					outputStream.write(json.getBytes("UTF-8"));
				} finally {
					if (outputStream != null) {
						outputStream.close();
					}
				}

				return readResponse(request);
			} finally {
				request.disconnect();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return "";
	}
	
	private static String readResponse(HttpURLConnection request) throws IOException {

		ByteArrayOutputStream os = null;
		InputStream is = null;
		try {
			is = request.getInputStream();
			os = new ByteArrayOutputStream();
			int b;
			while ((b = is.read()) != -1) {
				os.write(b);
			}
			return new String(os.toByteArray());
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}
	}
}
