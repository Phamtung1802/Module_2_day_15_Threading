public class ChanLe implements Runnable{
    public String name;
    public int delay;

    public static void main(String[] args) {
        ChanLe chanle = new ChanLe("le", 300);
        OddThread threadLe = new OddThread(chanle);
        EvenThread threadChan = new EvenThread(chanle);
        threadLe.start();
        try{
            threadLe.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("loi");
        }
        threadChan.start();
    }


    public ChanLe(String name,int delay) {
        this.name = name;
        this.delay=delay;
    }

    @Override
    public void run(){
        this.print();
    }

    public void print()  {
        for(int i=1;i<=10;i++){
            System.out.println("thread "+this.name+" " +i+" "+Thread.currentThread());
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
    public synchronized void run() {
        this.obj.run();
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
    public synchronized void run() {
        this.obj.print();
    }
}
