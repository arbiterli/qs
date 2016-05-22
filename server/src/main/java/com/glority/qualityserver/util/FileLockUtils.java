package com.glority.qualityserver.util;

import java.io.File;
import java.nio.channels.OverlappingFileLockException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * a logical lock of file.
 * @author zm.
 *
 */
public abstract class FileLockUtils {
    private static Map<File, Thread> holder = new HashMap<File, Thread>();

    private static ReentrantLock lock = new ReentrantLock();

    public static void tryLock(File file) {
        lock.lock();
        if (holder.containsKey(file)) {
            Thread t = holder.get(file);
            if (t != Thread.currentThread()) {
                lock.unlock();
                throw new OverlappingFileLockException();
            }
        } else {
            holder.put(file, Thread.currentThread());
        }
        lock.unlock();
    }

    public static void releaseLock(File file) {
        lock.lock();
        holder.remove(file);
        lock.unlock();
    }
}
