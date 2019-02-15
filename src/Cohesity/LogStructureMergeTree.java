package Cohesity;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个数据结构，实现三个API。日志格式：timestamp + msg
 * 过去一分钟，
 * 过去一个小时
 * 过去一天的event数目
 */
public class LogStructureMergeTree {

    static class Log{
        int timestamp;
        String msg;
        public  Log(int timestamp, String msg) {
            this.timestamp = timestamp;
            this.msg = msg;
        }
    }

    static List<Log> storage1;
    static List<Log> storage2;
    static List<Log> storage3;
    public LogStructureMergeTree() {
        storage1 = new ArrayList<>();
        storage2 = new ArrayList<>();
        storage3 = new ArrayList<>();
    }

    public static void addLogIntoStorage(Log log) {
        if (log.timestamp <= System.currentTimeMillis() - 60 * 1000) {
            storage1.add(log);
        } else if (log.timestamp <= System.currentTimeMillis() - 1000 * 60 * 60) {
            storage2.add(log);
        } else if (log.timestamp <= System.currentTimeMillis() - 1000 * 60 * 60 * 60) {
            storage3.add(log);
        }
    }

    public static void updateLogStorage() {
        long currTimeStamp = System.currentTimeMillis();
        for (Log log : storage1) {
            if (currTimeStamp - log.timestamp > 60 * 1000) {
                storage1.remove(log);
            }
        }

        for (Log log : storage2) {
            if (currTimeStamp - log.timestamp > 60 * 60 * 1000) {
                storage2.remove(log);
            }
        }

        for (Log log : storage3) {
            if (currTimeStamp - log.timestamp > 60 * 60 * 60 * 1000) {
                storage3.remove(log);
            }
        }
    }


    public static int getEventNumWithinOneMin() {
        return storage1.size();
    }

    public static int getEventNumWithinOneHour() {
        return storage2.size();
    }

    public static int getEventNumWithinOneDay() {
        return storage3.size();
    }
}

