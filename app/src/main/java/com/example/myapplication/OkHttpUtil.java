//package com.example.myapplication;
//
//import java.util.Map;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.FutureTask;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//public class OkHttpUtil {
//
//    static OkHttpClient okHttpClient = new OkHttpClient();
//    static ExecutorService threadPool = Executors.newFixedThreadPool(30);
//
//    public static String getRequest(final String url) throws ExecutionException, InterruptedException {
//        FutureTask futureTask =new FutureTask(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                Request request = new Request.Builder()
//                        .url(url)
//                        .build();
//                Response response = okHttpClient.newCall(request).execute();
//                if (response.isSuccessful()&&response.body()!=null){
//                    return response.body().string();
//                }else {
//                    return null;
//                }
//            }
//        }) ;
//        threadPool.execute(futureTask);
//        return futureTask.get().toString();
//    }
//    public static String postRequest(String url, Map<String,String>map){
//        return null;
//    }
//}
