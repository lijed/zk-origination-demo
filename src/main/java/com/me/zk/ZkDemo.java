/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Description:
 *
 * @Author: Jed LI
 * Created: 2021/9/1
 **/
public class ZkDemo {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        //这个监听是全局监听
        final Watcher watcher = watchedEvent -> {
            System.out.println("事件类型" + watchedEvent.getType() + ", path" + watchedEvent.getPath());
        };

        ZooKeeper zooKeeper = new ZooKeeper("172.16.1.215:2181", 20000, watcher);

        zooKeeper.exists("/test1", true);

        System.in.read();
    }
}
