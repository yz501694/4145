package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import software.amazon.awssdk.services.s3.model.PutObjectAclRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;

public class Upload {
    public static void main(String[] args) throws IOException {
        Regions region = Regions.DEFAULT_REGION;
        String BucketName = "4145";
        String ObjectKey = "test1.txt";
        String Path = "src/main/Data/test1.txt";

        try {
            AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.US_EAST_1).build();

            PutObjectRequest request = new PutObjectRequest(BucketName, ObjectKey, new File(Path));
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("plain/text");
            meta.addUserMetadata("title", "someTitle");
            request.setMetadata(meta);
            s3.putObject(request);
        }catch (AmazonServiceException e){
            e.printStackTrace();
        }catch (SdkClientException e){
            e.printStackTrace();
        }
    }
}
