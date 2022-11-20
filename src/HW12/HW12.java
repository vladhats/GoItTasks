package HW12;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;


public class HW12{
    public static void main(String[] args) {
       //first
        RunnableTimer timer = new RunnableTimer();
        Thread t1 = new Thread(timer::secondTimer);
        Thread t2 = new Thread(timer::fiveSecondsTimer);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(t2, 5, 5, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(t1, 0, 1, TimeUnit.SECONDS);
        //second
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Runnable printFizz = () -> System.out.println("fizz");
        Runnable printBuzz = () -> System.out.println("buzz");
        Runnable printFizzBuzz = () -> System.out.println("fizzbuzz");
        IntConsumer printNumber = number -> System.out.println(number);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    }


class RunnableTimer {
    public long time = 0;
    private final long start = System.currentTimeMillis();

    public void secondTimer() {
        time = Math.round((System.currentTimeMillis() - start) / 1000F);
        if (time % 5 != 0) {
            System.out.println(time + " cекунд минуло");
        }
    }

    public void fiveSecondsTimer() {
        System.out.println("5 секунд минуло....");
    }}
class FizzBuzz {
    private int n;
    private Semaphore lock;
    private AtomicInteger counter;

    public FizzBuzz(int n) {
        this.n = n;
        this.lock = new Semaphore(1);
        this.counter = new AtomicInteger(1);
    }


    public void fizz(Runnable printFizz) throws InterruptedException {
        int step = n/3 - n/15;
        int i = 0;
        while (i < step) {
            lock.acquire();
            if (counter.get() % 3 == 0 && counter.get() % 15 != 0) {
                printFizz.run();
                counter.incrementAndGet();
                i++;
            }
            lock.release();
        }
    }


    public void buzz(Runnable printBuzz) throws InterruptedException {
        int step = n/5 - n/15;
        int i = 0;
        while (i < step) {
            lock.acquire();
            if (counter.get() % 5 == 0 && counter.get() % 15 != 0) {
                printBuzz.run();
                counter.incrementAndGet();
                i++;
            }
            lock.release();
        }
    }


    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int step = n/15;
        int i = 0;
        while (i < step) {
            lock.acquire();
            if (counter.get() % 15 == 0) {
                printFizzBuzz.run();
                counter.incrementAndGet();
                i++;
            }
            lock.release();
        }
    }


    public void number(IntConsumer printNumber) throws InterruptedException {
        int step = n - n/3 - n/5 + n/15;
        int i = 0;
        while (i < step) {
            lock.acquire();
            if (counter.get() % 3 != 0 && counter.get() % 5 != 0) {
                printNumber.accept(counter.get());
                counter.incrementAndGet();
                i++;
            }
            lock.release();
        }
    }
}
