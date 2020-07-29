public class ChanLe implements Runnable{
    public String name;
    public int delay;

    public static void main(String[] args) {
        ChanLe chanle = new ChanLe("le", 300);
        OddThread threadLe = new OddThread(chanle);
        OddThread threadChan = new OddThread(chanle);

        threadLe.setPriority(1);
        threadChan.setPriority(3);

        threadChan.start();
        threadLe.start();

    }


    public ChanLe(String name,int delay) {
        this.name = name;
        this.delay=delay;
    }

    @Override
    public void run(){
        this.print();
    }

    public synchronized void print()  {
        for(int i=1;i<=10;i++){
            System.out.println(i+" "+Thread.currentThread());
            try {
                Thread.sleep(300);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}

 class OddThread extends Thread{
    private String name;
    ChanLe obj;
    int delay;

    public OddThread(ChanLe obj) {
        this.obj=obj;
        this.name = obj.name;
        this.delay=obj.delay;
    }
    @Override
    public void run(){
        obj.run();
    }
}

 class EvenThread extends Thread{
    private String name;
    ChanLe obj;
    int delay;

    public EvenThread(ChanLe obj) {
        this.name = obj.name;
        this.obj=obj;
        this.delay=obj.delay;
    }

    @Override
    public void run() {
        this.obj.run();
    }
}
