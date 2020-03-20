package br.com.lojagames.InfraStructure.ExternalServices;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

/**
 *
 * @author Victor
 */
public class UploadImageAWS {

    private final long time = System.currentTimeMillis();
    private final String bucketName = "arquivos-compragames/public";
    private final String keyName = "jogo" + time + ".png";
    private final String url_public = "https://arquivos-compragames.s3.us-east-1.amazonaws.com/public/";

    public String upload(InputStream fileInputStream, FormDataContentDisposition fileMetaData) {
        if (fileInputStream != null) {
            try {
                try {
                    try {
                        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAWGDMHNMMQ3N2VI6X", "KDeuAnFB+W/c3qtYL2uLrvvIdtmBUIGj9AzpqAZ0");
                        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                                .withRegion("us-east-1").build();

                        s3client.putObject(new PutObjectRequest(bucketName, keyName, bytesToImage(fileInputStream, fileMetaData)));
                        return keyName;
                    } catch (AmazonServiceException ase) {
                    } catch (AmazonClientException ace) {
                    }
                } catch (AmazonS3Exception e) {
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public String upload(File file) {
        if (file != null) {
            try {
                try {
                    try {
                        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAWGDMHNMMQ3N2VI6X", "KDeuAnFB+W/c3qtYL2uLrvvIdtmBUIGj9AzpqAZ0");
                        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                                .withRegion("us-east-1").build();

                        s3client.putObject(new PutObjectRequest(bucketName, keyName, file));
                        return keyName;
                    } catch (AmazonServiceException ase) {
                    } catch (AmazonClientException ace) {
                        System.out.println(ace);
                    }
                } catch (AmazonS3Exception e) {
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    public File bytesToImage(InputStream fileInputStream, FormDataContentDisposition fileMetaData) {

        String   temp = System.getProperty("java.io.tmpdir");

        File file = new File(temp + fileMetaData.getFileName());
        try {
            if (!file.exists()) {
                int read = 0;
                byte[] bytes = new byte[1024];

                OutputStream out = new FileOutputStream(file);
                while ((read = fileInputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                out.flush();
                out.close();
            }
            return file;
        } catch (IOException e) {
        }
        return null;
    }

}
