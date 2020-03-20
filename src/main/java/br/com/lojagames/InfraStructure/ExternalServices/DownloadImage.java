package br.com.lojagames.InfraStructure.ExternalServices;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author Victor
 */
public class DownloadImage {

    private final String bucketName = "arquivos-compragames/public";
    private final long time = System.currentTimeMillis();
    private final String keyName = "jogo" + time + ".png";

    public String downloads(String key) {

        if (key != null && !key.isEmpty()) {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJZ7EATT63OEN2JIQ", "CmEdtMAH6jUfu047Yo5q241Anwx5MtvNs3d3SywY");
            AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withRegion("us-east-1").build();

            try {
                S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, key));
                try {
                    return convertInputStreamToString(s3object.getObjectContent());
                } catch (IOException ex) {
                }

            } catch (AmazonServiceException ase) {
            } catch (AmazonClientException ace) {
            }
        }

        return null;
    }

    public File downloadInFile(String key) {

        if (key != null && !key.isEmpty()) {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJZ7EATT63OEN2JIQ", "CmEdtMAH6jUfu047Yo5q241Anwx5MtvNs3d3SywY");
            AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .withRegion("us-east-1").build();

            try {
                S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, key));
                try {
                    return convertInputStreamToFile(s3object.getObjectContent());
                } catch (IOException ex) {
                }

            } catch (AmazonServiceException ase) {
            } catch (AmazonClientException ace) {
            }
        }

        return null;
    }

    private File convertInputStreamToFile(InputStream inputStream) throws IOException {
        String temp = System.getProperty("java.io.tmpdir");

        File file = new File(temp + keyName);

        try (FileOutputStream outputStream = new FileOutputStream(file)) {

            int read;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            return file;
        }
    }

    private String convertInputStreamToString(InputStream input) throws IOException {
        InputStream is = new BufferedInputStream(input);
        BufferedImage image = ImageIO.read(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return com.amazonaws.util.Base64.encodeAsString(baos.toByteArray());
    }

}
