package com.grupo06.Config;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Conjunto de métodos estáticos variados
 * 
 * @author Marcs
 */
public class Utils {

    private static final Random random = new SecureRandom();

    /**
     * Genera una contraseña según una serie de booleanos incluidos en
     * <code>options</code><br>
     * 1er -> incluir minúsculas<br>
     * 2do -> incluir mayúsculas<br>
     * 3er -> incluir símbolos<br>
     * 4to -> incluir números<br>
     * 
     * @param options serie de booleanos para seleccionar las opciones
     * presentadas anteriormente (true lo incluye y false lo excluye)
     * @param length la longitud de la contraseña final
     * @return una String de longitud <code>length</code> 
     */
    public static String passwordGen(boolean[] options, int length) {

        String all = "";
        String[] data = new String[4];

        data[0] ="abcdefghijklmnopqrstuvwxyz";
        data[1] ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        data[2] ="!@#$%^&*()_+-={}[]|\\:;<>,.?/";
        data[3] ="0123456789";

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 4; i++) {

            if (options[i]) {
                all += data[i];
                password.append(getRandomCharacter(data[i]));
            }

        }

        for (int i = password.toString().length(); i < length; i++) {
            password.append(getRandomCharacter(all));
        }

        // Mezcla los caracteres para que no estén en orden predecible

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(length);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }

        return password.toString();
    }

    /**
     * Método interno para generar un caracter aleatorio dentro de un conjunto
     * de caracteres especificado por <code>characterSet</code>.
     * Utilizado por <code>passwordGen</code>
     * 
     * @param characterSet Una String conteniendo los caracteres posibles
     * @return un caracter aleatorio que esté dentro de los posibles valores
     * según <code>characterSet</code>
     */
    private static Object getRandomCharacter(String characterSet) {
        int randomIndex = random.nextInt(characterSet.length());
        return characterSet.charAt(randomIndex);
    }


    /**
     * Encripta una <code>String password</code> utilizando el algoritmo de
     * hashing SHA-256
     * 
     * @param password La cadena de texto a encriptar
     * @return La <code>String password</code> encriptada
     */
    public static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null,
                    "Algoritmo de hashing inválido", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    /**
     * Verifica si una string <code>in</code> está vacía según 3 condiciones<br>
     * 
     * <code>in</code> es <code>null</code><br>
     * <code>in</code> está vacío (es igual a <code>""</code>)<br>
     * <code>in</code> es una string que consiste de caracteres invisibles o no
     * imprimibles <code>('\0', '\n', '\t', espacio sin separación, ' ', etc...)</code>
     * 
     * @param in String a verificar
     * @return true si alguna de las 3 condiciones se cumplen, false si ninguna
     * lo hace
     */
    public static boolean verifyField(String in) {
        return null == in || in.isEmpty() || in.isBlank();
    }

    
}


