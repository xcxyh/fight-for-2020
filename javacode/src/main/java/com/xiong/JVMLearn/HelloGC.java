package com.xiong.JVMLearn;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/28 14:22
 * @description：
 * @modified By：
 * @version: $
 */
public class HelloGC {

    public static void main(String[] args) {

        //readMemory();
    }



    /**
     *  @author: xiongcong
     *  @Date: 2020/3/28 14:27
     *  @Description: 查看java 虚拟机内存
     *
     *  -Xms: 等价于 -XX:InitialHeapSize  默认堆内存大小
     *  -Xmx: 等价于 -XX:MaxHeapSize  最大堆内存
     *  -Xss128k: 等价于 -XX:ThreadStackSize 单个线程栈大小 配置为128k 默认值大小依赖操作系统  一般为 512 K -- 1024 K
     *  -Xmn: 等价于                      设置 年轻代的大小 即 Eden + s0 + s1 部分
     *  -XX:MetaspaceSize=512M   元空间大小  一般设置  512 MB
     *
     *  还有一些 boolean 类型的 参数   + 代表启用  - 代表不启用
     *
     *  例如 垃圾回收器的选择 四种算法  7 种实现
     *
     *  -XX:+UseSerialGC   新生代 串行垃圾回收器  采用复制算法； 单线程收集； serial 和 serial old 同时开启
     *  -XX:+UseParallelGC 新生代 并行垃圾回收器 (java 8 默认) Parallel Scavenge & Parallel Old 同时开启
     *  -XX:+UseParNewGC   新生代  ParNew垃圾收集器是Serial收集器的多线程版本。 强制指定使用ParNew
     *  =======================
     *  -XX:+UseConcMarkSweepGC  针对老年代；基于"标记-清除"算法(不进行压缩操作，产生内存碎片)；
     *                              指定使用CMS后，会默认使用ParNew作为新生代收集器； ParNew & CMS 同时开启（Serial Old作为替补）
     *  Serial Old   老年代 ( 弃用 )
     *  -XX:+UseParallelOldGC  老年代  并行垃圾回收器
     *  =======================
     *  -XX:+UseG1GC    指定使用G1收集器； 独立商用
     *
     *
     *
     */
    private static void readMemory() {
        long totalMem = Runtime.getRuntime().totalMemory();//Java虚拟机中的内存总量 默认为 电脑内存的 1/64
        long maxMem = Runtime.getRuntime().maxMemory();//Java虚拟机中试图使用的最大内存 默认为 电脑内存的 1/4

        System.out.println("Total_memory:-Xms : " + totalMem +" 字节" + (totalMem/(double)1024/1024 ) + " MB");
        System.out.println("Max_memory:-Xmx : " + maxMem +" 字节" + (maxMem/(double)1024/1024 ) + " MB");
    }
}
