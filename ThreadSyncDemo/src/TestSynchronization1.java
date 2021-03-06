public class TestSynchronization1 {
    public static void main(String args[]) {
        Table obj = new Table();// tao mot object
        MyThread1 t1 = new MyThread1(obj);

        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread {
    Table t;
    int delay;

    MyThread1(Table t) {
        this.t = t;
        this.delay=t.delay;

    }

    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}

class Table {
    int delay;
    synchronized void printTable(int n) {// method synchronized
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i+" "+Thread.currentThread());
            try {
                Thread.sleep(this.delay);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}