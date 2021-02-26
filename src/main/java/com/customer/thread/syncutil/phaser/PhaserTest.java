package com.customer.thread.syncutil.phaser;

public class PhaserTest {
    /**
     * Phaser 新特性
     */
    public static void info(){
        /**
         * 1、动态调整线程个数：CyclicBarrier 所需要同步的线程个数是在构造方法中指定的，之后不能更改
         *     Phaser可以在运行期间动态的调整要同步的线程个数，提供方法如下：
         *     register() // 注册一个
         *     bulkRegister(int parties) // 注册多个
         *     arriveAndDeregister() // 解除注册
         * 2、层次Phaser
         *    多个Phaser可以组成树状结构，可以通过在构造方法中传入父Phaser来实现
         *    public Phaser(Phaser parent, int parties) { // ... }
         *    源码逻辑描述：可以发现，在Phaser的内部结构中，每个Phaser记录了自己的父节点，但并没有记录自己的子节点
         *     列表。所以，每个 Phaser 知道自己的父节点是谁，但父节点并不知道自己有多少个子节点，对父节点
         *      的操作，是通过子节点来实现的。
         *     代码示例：
         *      Phaser root = new Phaser(2);
         *      Phaser c1 = new Phaser(root, 3);
         *      Phaser c2 = new Phaser(root, 2);
         *      Phaser c3 = new Phaser(c1, 0);
         *      示例代码解析：本来root有两个参与者，然后为其加入了两个子Phaser（c1，c2），每个子Phaser会算作1个参与
         * 者，root的参与者就变成2+2=4个。c1本来有3个参与者，为其加入了一个子Phaser c3，参与者数量变
         * 成3+1=4个。c3的参与者初始为0，后续可以通过调用register()方法加入。
         * 对于树状Phaser上的每个节点来说，可以当作一个独立的Phaser来看待，其运作机制和一个单独的
         * Phaser是一样的。
         * 父Phaser并不用感知子Phaser的存在，当子Phaser中注册的参与者数量大于0时，会把自己向父节
         * 点注册；当子Phaser中注册的参与者数量等于0时，会自动向父节点解除注册。父Phaser把子Phaser当
         * 作一个正常参与的线程就即可
         * 3、Phaser没有基于AQS来实现，
         * 但具备AQS的核心特性：state变量、CAS操作、阻塞队列。先从state变量说起。
         */
    }

}
