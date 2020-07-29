public class NumberGenerator implements Runnable {
    String name;

    public NumberGenerator(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        this.print();
    }

    synchronized public void print() {
        try {
            for(int i=0;i<10;i++){
                System.out.println("t "+this.name+" " +i+" "+this.hashCode());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NumberGenerator n1=new NumberGenerator("t1");
        NumberGenerator n2=new NumberGenerator("t2");

        Thread t1=new Thread(n1);
        Thread t2=new Thread(n2);

        t1.start();
        t1.setPriority(1);
        t2.start();
        t2.setPriority(2);
    }
}
