package co.edu.sena.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import co.edu.sena.models.entity.Aprendiz;
import co.edu.sena.models.service.AprendizService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/aprendiz")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class QRController {

	@Autowired
    private AprendizService aprendizService;

    @GetMapping("/generarQR/{id}")
    public void generarQR(@PathVariable BigInteger id, HttpServletResponse response) {
        try {
            // Obtener los datos del cliente desde el servicio
            Aprendiz aprendiz = aprendizService.obtenerAprendizPorId(id);
            
            // Verificar si el cliente existe
            if (aprendiz != null) {
                // Generar el texto para el código QR (puedes personalizar esto según tus necesidades)
                String datosAprendiz =	"Aprendiz\n\n" +
                						"Codigo: " + aprendiz.getCodigo() + 
                						"\nNombres: " + aprendiz.getPersona().getNombres() + 
                						"\nApellidos: " + aprendiz.getPersona().getApellidos() +
                						"\n"+ aprendiz.getPersona().getTipoDocumento().getNombre() + ":" + aprendiz.getPersona().getCedula() + 
                						"\nCelular: " + aprendiz.getPersona().getCelular() +
                						"\nEmail: " + aprendiz.getPersona().getCorreo() +
                						"\nNombre de contacto: " + aprendiz.getPersona().getContacto() +
                						"\nTelefono de contacto: " + aprendiz.getPersona().getCelularAlt() +
                						"\nFicha: " + aprendiz.getFicha().getNumero() +
                						"\nFicha: " + aprendiz.getFicha().getFormacion().getNombre() +
                						"\nRestriciones medicas: " + aprendiz.getRestricMedicas(); 
                
                // Generar el código QR a partir de los datos del cliente
                BufferedImage bufferedImage = QRGenerator.generateQRCodeImage(datosAprendiz);
                
                // Escribir la imagen en la respuesta
                response.setContentType("image/png");
                ImageIO.write(bufferedImage, "png", response.getOutputStream());
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND); // Cliente no encontrado
            }
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Error interno del servidor
            e.printStackTrace();
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Solicitud incorrecta
            e.printStackTrace();
        }
    }
    
    public class QRGenerator {

        private static final int QR_CODE_WIDTH = 300;
        private static final int QR_CODE_HEIGHT = 300;

        public static BufferedImage generateQRCodeImage(String text) throws Exception {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, QR_CODE_WIDTH, QR_CODE_HEIGHT);
            return toBufferedImage(bitMatrix);
        }
    }
    
    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }
}
