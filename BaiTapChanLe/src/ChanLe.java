public class ChanLe implements Runnable{
    public String name;
    public int delay;

    public static void main(String[] args) throws InterruptedException {
       ChanLe chan=new ChanLe("chan",150);
       ChanLe le=new ChanLe("le",300);
       OddThread threadLe=new OddThread(le);
       EvenThread threadChan=new EvenThread(chan);
       threadLe.start();
//       try{
//           threadLe.join();
//       }
//       catch (InterruptedException e){
//           e.printStackTrace();
//           System.out.println("loi");
//       }
       threadChan.start();


    }

    public ChanLe(String name,int delay) {
        this.name = name;
        this.delay=delay;
    }

    @Override
    synchronized public void run(){
        this.print();
    }
    synchronized public void print() {
        try {
            for(int i=1;i<=10;i++){
                System.out.println("thread "+this.name+" " +i+" "+Thread.currentThread());
                Thread.sleep(this.delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
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
    synchronized public void run() {
        this.obj.print();
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
        this.obj.print();
    }
}
