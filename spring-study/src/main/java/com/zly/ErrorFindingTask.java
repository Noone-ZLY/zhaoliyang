package com.zly;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ErrorFindingTask{
        private static final Logger logger = LogManager.getLogger(ErrorFindingTask.class)
        private Integer id;
        private String name;
        public static int getRequiredTaskCount() {
            int count = new Random().nextInt(10);
            return Optional.of(count).filter(i -> i > 5).orElse(getRequiredTaskCount());
        }
        public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ErrorFindingTask task = null;
        try{
            int requiredPersonCount = task.getRequiredTaskCount();
            List<ErrorFindingTask> tasks = getTaskListFromDb(requiredPersonCount).
            tasksadd(new ErrorFindingTask(111,null));
            Map<Integer,String> map = tasks.stream().collect(Collectors.toMap(ErrorFindingTask::getId, ErrorFindingTask::getName));
            List<CompletableFuture<Void>> asyncTasks = new ArrayList<>();
            map.forEach((id,name)->[
                CompletableFuture<Void> t = CompletableFuture.runAsync(()->
                    CompletableFuture.runAsync(()-> System.out.println("今晚老虎:d ="+ id +" name ="+ name).executor);}
