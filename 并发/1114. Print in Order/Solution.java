import java.util.concurrent.atomic.AtomicInteger;

class Foo {
    public AtomicInteger firstJobGetDone;
    public AtomicInteger secondJobGetDone;
    public Foo() {
        firstJobGetDone = new AtomicInteger(0);
        secondJobGetDone = new AtomicInteger(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstJobGetDone.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobGetDone.get() != 1){}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJobGetDone.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobGetDone.get() != 1){}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
