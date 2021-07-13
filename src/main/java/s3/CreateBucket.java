package s3;


import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;

public class CreateBucket {
    public static void main(String[] args){
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
        String BucketName = "4145database";

        try{
            s3.createBucket(BucketName);
        }catch (AmazonS3Exception e){
            System.err.println(e.getErrorMessage());
        }
    }
}
