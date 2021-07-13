package awsLambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.util.Map;


import java.io.*;
import java.util.*;

public class BucketQuery {
    public void Query(String name,File file) throws IOException{
        File[] list = file.listFiles();
        if(list != null){
            for(File f : list){
                if(f.isDirectory()){
                    Query(name, f);
                }else {
                    if (name.equals(f.getName())){
                        File source = new File(f.getPath());
                        File des = new File("src/main/Output/output.txt"); //destination of output
                        try(FileInputStream fIn = new FileInputStream(source);
                            FileOutputStream fot = new FileOutputStream(des)){
                            byte[] buffer = new byte[1024];
                            int length;

                            while ((length = fIn.read(buffer)) > 0) {

                                fot.write(buffer, 0, length);
                            }
                        }
                        System.out.println("Successfully processed");
                        break;
                    }else {
                        System.out.println("No such file");
                        System.out.println("Please upload a new file");
                        break;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BucketQuery query = new BucketQuery();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of file");
        String name = scanner.next();
        query.Query(name, new File("src/main/Data"));
    }
}
