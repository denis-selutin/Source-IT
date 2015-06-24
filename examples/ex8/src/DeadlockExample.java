/**
 * Created by denis.selutin on 6/23/2015.
 */
public class DeadlockExample {
    public static void main(String[] args) {
        //инициаоизируем переменные с синхронизацией по обьекту
        A a1 = new A();
        A a2 = new A();

        //Создаем и запускаем потоки
        Thread t1 = new Run(a1, a2);
        Thread t2 = new Run(a2, a1);

        t1.start();
        t2.start();
    }

    private static class Run extends Thread {
        private A a1;
        private A a2;

        public Run(A a1, A a2) {
            this.a1 = a1;
            this.a2 = a2;
        }

        @Override
        public void run() {
            //вызываем наши синхронизированный метод
            try {
                a1.doAction(a2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class A {
        public synchronized void doAction(A a) throws InterruptedException {
            //synchronized (this) {
            //заставляем поток ждать, необходимо для того чтобы запустился врторой поток и заблокировал ресурс
            Thread.sleep(1000);
            //вызываем наш синхронный метод у второго обьекта, пытаясь захватить его монитор
            a.doAction(this);
            //}
        }
    }
}
