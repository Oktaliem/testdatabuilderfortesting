package com.oktaliem.builder;

import com.google.common.hash.Hashing;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

public class EncryptionBuilder {


    public String base64Encoder(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public String base64Decoder(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }

    public String convertToSha256(String input) {
        return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();
    }

    public String convertToSha512(String input) throws NoSuchAlgorithmException {
        MessageDigest msg = MessageDigest.getInstance("SHA-512");
        byte[] digest = msg.digest(input.getBytes());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            builder.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        return builder.toString();
    }

    public String convertToSha512WithGuava(String input) throws NoSuchAlgorithmException {
        return Hashing.sha512().hashString(input, StandardCharsets.UTF_8).toString();
    }

    public String convertToSha1WithGuava(String input) throws NoSuchAlgorithmException {
        return Hashing.sha1().hashString(input, StandardCharsets.UTF_8).toString();
    }

    public String convertToHmacSha256WithGuava(String input, byte[] key) throws NoSuchAlgorithmException {
        return Hashing.hmacSha256(key).newHasher().putString(input, StandardCharsets.UTF_8).hash().toString();
    }

    public String convertToHmacSha256WithGuavaWithApache(String input, byte[] key) {
        HmacUtils hm256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, key);
        return hm256.hmacHex(input);
    }

    public String generateRandomOTP(int digit) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        final StringBuilder otp = new StringBuilder(digit);
        for (int i = 0; i < digit; i++) {
            otp.append("123456789".charAt(random.nextInt("123456789".length())));
        }
        return otp.toString();
    }

    public String convertToMd5WithGuava(String input) {
        return Hashing.md5().hashString(input, StandardCharsets.UTF_8).toString();
    }

    public String encodeUrl(String url, String query) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode(query, StandardCharsets.UTF_8.name());
        return url + encode;
    }

    public String decode(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url, StandardCharsets.UTF_8.name());
    }

    public void generateQrCode(String barcodeText, String path) throws IOException, WriterException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
        MatrixToImageWriter.writeToFile(bitMatrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }

    public String readQrCode(String path) throws IOException, NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
                ImageIO.read(new FileInputStream(path)))));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }
}
