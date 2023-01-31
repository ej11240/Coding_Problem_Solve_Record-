
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class p13335 {

    private static class Truck{
        private int initTime, weight;

        public Truck(int initTime, int weight){
            this.initTime = initTime;
            this.weight = weight;
        }
    }

    public static Queue<Truck> bridgeState = new LinkedList<Truck>();
    public static int bridgeWeight;
    public static int time, w, L;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read = br.readLine().split(" ");
        int n = Integer.parseInt(read[0]);
        w = Integer.parseInt(read[1]);
        L = Integer.parseInt(read[2]);
        read = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            queueOperate(Integer.parseInt(read[i]));


        while(!bridgeState.isEmpty()){
            if(time - bridgeState.peek().initTime >= w) bridgeState.poll();
            else time++;
        }

        System.out.println(time);
    }

    public static void queueOperate(int weight){
        time++;
        while(bridgeState.size() >= w || bridgeWeight+weight > L){
            if(time - bridgeState.peek().initTime >= w){
                bridgeWeight -= bridgeState.peek().weight;
                bridgeState.poll();
            }
            else time++;
        }
        bridgeWeight += weight;
        bridgeState.add(new Truck(time, weight));
    }
}
