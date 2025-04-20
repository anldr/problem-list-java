package z_multi_thread;

import ch.qos.logback.classic.filter.ThresholdFilter;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        while(true) {
            Thread.sleep(500);
            System.out.println("1..." + " ");
        }

//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.thenAcceptAsync(result -> {
//            result = result + "test";
//            System.out.println("1..." + " ");
//        });
//
//        future.thenAcceptAsync(result -> {
//            result = result + "test";
//            System.out.println("2..." + " ");
//        });
//
//        future.thenAcceptAsync(result -> {
//            result = result + "test";
//            System.out.println("3..." + " " + result);
//        });
//
//        future.complete("asdfadsfsa");
    }
}
