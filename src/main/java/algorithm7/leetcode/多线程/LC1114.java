package algorithm7.leetcode.多线程;

public class LC1114 {


    class Foo {

        volatile boolean a = false;
        volatile boolean b = false;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            a = true;
        }

        public void second(Runnable printSecond) throws InterruptedException {

            while(!a) {

            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            b = true;
        }

        public void third(Runnable printThird) throws InterruptedException {

            while(!b) {

            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }


}
