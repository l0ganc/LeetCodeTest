package Viagogo;

import java.util.*;

public class ViagogoOA {
    static class Event {
        int id;
        int x;
        int y;
        int distance;
        int price;
        int index;
        public Event(int id, int x, int y, int distance, int price, int index) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.price = price;
            this.index = index;
        }
    }

    static class Buyer {
        int x;
        int y;
        public Buyer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);

        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());

        List<Event> eventsList = new ArrayList<>();
        List<Buyer> buyersList = new ArrayList<>();
        Map<Integer, Boolean> canBuy = new HashMap<>();

        int count = 0;
        while (numberOfEvents > 0) {
            String eventLine = scan.nextLine();
            // TODO: you will need to parse and store the events
            String[] arr = eventLine.split("\\s+");
            int id = Integer.parseInt(arr[0]);
            int x = Integer.parseInt(arr[1]);
            int y = Integer.parseInt(arr[2]);

            for (int i = 3; i < arr.length; i++) {
                eventsList.add(new Event(id, x, y, 0, Integer.parseInt(arr[i]), count));
                canBuy.put(count, true);
                count++;
            }
            numberOfEvents--;
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        while (numberOfBuyers > 0) {
            String buyerLine = scan.nextLine();
            // TODO: you will need to parse and store the buyers
            String[] buyerArr = buyerLine.split("\\s+");
            int x = Integer.parseInt(buyerArr[0]);
            int y = Integer.parseInt(buyerArr[1]);
            buyersList.add(new Buyer(x, y));
            numberOfBuyers--;
        }

        // The solution to the first sample above would be to output the following to console:
        // (Obviously, your solution will need to figure out the output and not just hard code ot)
        PriorityQueue<Event> pq = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                if (e1.distance != e2.distance) {
                    return e1.distance - e2.distance;
                } else {
                    if (e1.price != e2.price) {
                        return e1.price - e2.price;
                    } else {
                        return e1.id - e2.id;
                    }
                }
            }
        });


        for (int i = 0; i < buyersList.size(); i++) {
            Buyer buyer = buyersList.get(i);
            for (int j = 0; j < eventsList.size(); j++) {
                Event curEvent =  eventsList.get(j);
                if (canBuy.get(curEvent.index)) {
                    curEvent.distance =  calculateManhattanDistance(buyer.x, buyer.y, curEvent.x, curEvent.y);
                    pq.add(curEvent);
                }
            }

            Event result = pq.poll();
            if (result !=  null) {
                canBuy.put(result.index, false);
                System.out.println(result.id + " " + result.price);
            } else {
                System.out.println("-1 0");
            }
            pq.clear();
        }
    }

    // The following method get the manhattan distance between two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
