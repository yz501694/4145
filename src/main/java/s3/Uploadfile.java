package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;

public class Uploadfile {
    public static void main(String[] args){
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
        String BucketName = "4145database";
        String key = "key";
        String filepath = "src/main/Data/test1.txt";

        try{
            s3.putObject(BucketName, key, new File(filepath));
        }catch (AmazonServiceException e){
            System.err.println(e.getErrorMessage());
        }
    }
}
