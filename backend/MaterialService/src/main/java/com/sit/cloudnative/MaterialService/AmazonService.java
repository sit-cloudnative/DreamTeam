package com.sit.cloudnative.MaterialService;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import java.io.File;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmazonService {
    
    private AmazonS3 s3client;
    
    @Value("${amazon.bucketName}")
    private String bucketName;
    
    @Value("${amazon.accessKey}")
    private String accessKey;
    
    @Value("${amazon.secretKey}")
    private String secretKey;
    
    @Value("${amazon.region}")
    private String region;

    public AmazonService() {
    }
    
    @PostConstruct
    private void initializeAmazon() {
       AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
       this.s3client = AmazonS3ClientBuilder
               .standard()
               .withCredentials(new AWSStaticCredentialsProvider(credentials))
               .withRegion(region)
               .build();
    }
      
    public void uploadFile() {
        try {
            TransferManager tm = TransferManagerBuilder.standard()
                                .withS3Client(s3client)
                                .build();
            Upload upload = tm.upload(bucketName, "test7.txt", new File("C:\\Users\\sangu\\Documents\\test.txt"));           
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client 
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }
}
