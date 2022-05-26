package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 고스택 {

    static class Stack{
        LinkedList<Integer> stack ;

        public Stack(LinkedList<Integer> s) {
            this.stack = s;
        }

        public void NUM(int x){
            this.stack.push(x);
        }
        public void POP(){
            this.stack.pop();
        }

        public void INV(){
            int t =this.stack.pop();
            t= -(t);
            this.stack.push(t);
        }

        public void DUP(){
            int t = this.stack.getLast();
            this.stack.push(t);
        }

        public void SWP(){
            int t1 = this.stack.pop();
            int t2 = this.stack.pop();

            this.stack.push(t1);
            this.stack.push(t2);
        }

        public void ADD(){
            int t1 = this.stack.poll();
            int t2 = this.stack.poll();


            int add = t1+t2;
            this.stack.push(add);
        }

        public void SUB(){
            int t1 = this.stack.pop();
            int t2 = this.stack.pop();

            int sub = t1-t2;
            this.stack.push(sub);
        }

        public void MUL(){
            int t1 = this.stack.pop();
            int t2 = this.stack.pop();

            int mul = t1*t2;
            this.stack.push(mul);
        }

        public void DIV(){
            int t1 = this.stack.pop();
            int t2 = this.stack.pop();

            int div = 0;
            if(t1<0&&t2<0){
                t1 = -(t1);
                t2 = -(t2);

                div = t2/t1;
            }
            else if (t1<0){
                t1 = -(t1);

                div = -(t2/t1);
            }
            else if (t2<0){
                t2 = -(t2);

                div = -(t2/t1);
            }else {
                div = t2/t1;
            }
            this.stack.push(div);
        }

        public void MOD(){
            int t1 = this.stack.pop();
            int t2 = this.stack.pop();

            int mod = t2 % t1;
            if (t2<0){
                mod = t2/t1;
                if(mod>0) mod = -(mod);
            }
            this.stack.push(mod);
        }


    }

    public static void main(String[] args) throws IOException {
        LinkedList<Integer> forMakeStack = new LinkedList<>();
        Stack stack =new Stack(forMakeStack);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> execute = new LinkedList<>();
        String input = reader.readLine();

        while (true) {
            execute.clear();

            if(input.equals("QUIT")) break;

            while (true){

                if(input.equals("END")) break;

                String s[] = input.split(" ");

                if(s.length==1) execute.add(s[0]);
                else {
                    execute.add(s[0]);
                    execute.add(s[1]);
                }

                input= reader.readLine();
            }

            int count = Integer.parseInt(reader.readLine());
            LinkedList<Integer> machine = new LinkedList<>();
            for(int i =0; i<count; i++){
                machine.add(Integer.parseInt(reader.readLine()));
                if(i==count-1) {
                    input = reader.readLine();
                }
            }
//            execute.forEach(e->{System.out.println("Execute: "+e);});
            final int[] stop = {0};

            machine.forEach(c ->{
//                System.out.println("========== c: "+c+" ===========");
                stack.stack.clear();
                int i=0;
                stack.NUM(c);

                while (i<execute.size()&& stop[0] ==0) {

//                    System.out.println("current execute: "+execute.get(i)+ ", i: "+i+", last: "+stack.stack.getLast());

//                    System.out.println(stack.stack);

                    if (stack.stack.size() == 0) {
                        System.out.println("ERROR");
                        stop[0] =1;
                        break;
                    } else if (execute.get(i).equals("END")) break;

                    else if (stack.stack.getLast() > 1000000000) {
                        System.out.println("ERROR");
                        stop[0] =1;
                        break;
                    } else {
                        switch (execute.get(i)) {
                            case "NUM":
                                i++;
                                stack.NUM(Integer.parseInt(execute.get(i)));
                                break;
                            case "POP":
                                stack.POP();
                                break;
                            case "INV":
                                stack.INV();
                                break;
                            case "DUP":
                                stack.DUP();
                                break;
                            default:
                                if (stack.stack.size() == 1) {
                                    System.out.println("ERROR");
                                    stop[0] =1;
                                    break;
                                }

                                switch (execute.get(i)) {
                                    case "SWP":
                                        stack.SWP();
                                        break;
                                    case "ADD":
                                        stack.ADD();
                                        break;
                                    case "SUB":
                                        stack.SUB();
                                        break;
                                    case "MUL":
                                        stack.MUL();
                                        break;
                                    case "DIV":
                                        if (stack.stack.getFirst() == 0) {
                                            System.out.println("ERROR");
                                            stop[0] =1;
                                            break;
                                        }
                                        stack.DIV();
                                        break;
                                    case "MOD":
                                        if (stack.stack.getFirst() == 0) {
                                            System.out.println("ERROR");
                                            stop[0] =1;
                                            break;
                                        }
                                        stack.MOD();
                                        break;
                                    default:
                                        break;
                                }

                                break;

                        }
                    }

                    i++;
                }

                if(stop[0]==1) ;
                else if(stack.stack.size()!=1) System.out.println("ERROR");
                else if(stack.stack.getLast()>1000000000) System.out.println("ERROR");
                else System.out.println(stack.stack.get(0));

            });
            System.out.println("");


            input = reader.readLine();
        }
    }
}
