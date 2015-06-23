import java.util.Random;

/**
 * Created by denis.selutin on 6/23/2015.
 */
public class LiveLock {
    private static class Spoon {
        private Diner owner;
        public Spoon(Diner d) {
            owner = d;
        }
        public Diner getOwner() {
            return owner;
        }
        public synchronized void setOwner(Diner d) {
            owner = d;
        }
        public synchronized void use() {
            System.out.printf("%s has eaten!", owner.name);
        }
    }

    private static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String n) {
            name = n;
            isHungry = true;
        }
        public String getName() {
            return name;
        }
        public boolean isHungry() {
            return isHungry;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                // Ложка не у нас - ожидаем когда нам ее дадут
                if (spoon.owner != this) {
                    try {
                        Thread.sleep(1);
                    } catch(InterruptedException e) {
                        continue;
                    }
                    continue;
                }

                // Сморим - голоден ли человек с которым мы обедаем - еслши да - то отдаем ему ложку
                if (spouse.isHungry()) {
                    System.out.printf("%s: You eat first my darling %s!%n", name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                // хм...наш собеседник не голоден - кушаем сами
                spoon.use();
                isHungry = false;
                System.out.printf("%s: I am stuffed, my darling %s!%n", name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");

        final Spoon s = new Spoon(husband);

        new Thread(new Runnable() {
            public void run() {
                husband.eatWith(s, wife);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                wife.eatWith(s, husband);
            }
        }).start();
    }
}