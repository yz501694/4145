package s3;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;

import java.io.IOException;

public class Delete {
    public static void main(String[] args) throws IOException{
        String BucketName = "4145";
        String KeyName = "test1.txt";

        try {
            AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.US_EAST_1).build();
            s3.deleteObject(new DeleteObjectRequest(BucketName, KeyName));
        }catch (AmazonServiceException e){
            e.printStackTrace();
        }catch (SdkClientException e){
            e.printStackTrace();
        }
    }
}
