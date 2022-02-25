import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    Semaphore fo;
    Semaphore ba;
    public FooBar(int n) {
        this.n = n;
        fo = new Semaphore(1);
        ba = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            ba.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            ba.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fo.release();
        }
    }
}
