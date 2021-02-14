//package net.airuntime.springboot.web;
//
//import io.minio.MinioClient;
//
//
//public class TestMinIO {
//
//    public static void main(String[] args) {
//        try {
//            MinioClient minioClient = new MinioClient("http://34.123.31.162:9000/",
//                    "minioadmin",
//                    "minioadmin");
//            boolean found = minioClient.bucketExists("sample");
//            if (found) {
//                minioClient.removeBucket("sample");
//                System.out.println("sample bucket is removed successfully");
//            } else {
//                System.out.println("sample bucket does not exist");
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error occurred: " + e);
//        }
//    }
//
//}
