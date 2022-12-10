package net.fjuanias.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date end = cal.getTime();
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<>();
		while (!gcal.getTime().after(end)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}
	
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		String nombreOriginal = Utileria.randomAlphaNumeric(10).concat("-").concat(multiPart.getOriginalFilename().replace(" ", "-").trim());
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		try {
			File imageFile = new File(rutaFinal + nombreOriginal);
			multiPart.transferTo(imageFile);
			return nombreOriginal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	
	/**
	 * Método para generar una cadena aleatoria
	 * @param count
	 * @return
	 */
	public static String randomAlphaNumeric(int count) {
		String caracteres = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * caracteres.length());
			builder.append(caracteres.charAt(character));
		}
		return builder.toString();
	}

}
