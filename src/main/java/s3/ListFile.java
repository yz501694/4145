package s3;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.List;

public class ListFile {
    static String BucketName = "4145database";

    public static void main(String[] args){
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
        ObjectListing list = s3.listObjects(BucketName);
        List<S3ObjectSummary> objects = list.getObjectSummaries();
        for(S3ObjectSummary summary : objects){
            System.out.println(summary.getKey());
        }
    }
}
