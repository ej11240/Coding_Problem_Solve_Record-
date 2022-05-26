package com.company.RealTest;

public class sk1 {

    public static void main(String[] args) {

        int[][] dia = {{17,19}};
        System.out.println(solution(51,37, dia));

    }

    public static int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        for(int i=0; i<diagonals.length; i++){
            int first = fact( diagonals[i][0]-1 + diagonals[i][1] ) / ( fact(diagonals[i][0]-1) * fact(diagonals[i][1]) );


            System.out.println(fact(width - diagonals[i][0]));
            int second = ( fact( (width - diagonals[i][0]) + (height - (diagonals[i][1]-1)) ) / fact(width - diagonals[i][0])  ) / fact( height - (diagonals[i][1]-1) );

            answer+=first*second;

//            System.out.println(( fact(width - diagonals[i][0]) * fact( height - (diagonals[i][1]-1) ) ));

            first = fact( diagonals[i][0] + diagonals[i][1]-1 ) / ( fact(diagonals[i][0])*fact(diagonals[i][1]-1) );

            second = (  fact( (width - (diagonals[i][0]-1)) + (height - diagonals[i][1]) ) /  fact(width - (diagonals[i][0]-1)) ) / fact(height - diagonals[i][1]);

//            second = fact( (width - (diagonals[i][0]-1)) + (height - diagonals[i][1]) ) / ( fact(width - (diagonals[i][0]-1)) * fact(height - diagonals[i][1]) );

//            System.out.println((  fact(width - (diagonals[i][0]-1)) * fact(height - diagonals[i][1]) ));

            answer+=first*second;
        }

        return answer;
    }

    public static int fact(int n) {

        if (n <= 1)
            return 1;

        else
            return fact(n-1) * n;

    }
}
