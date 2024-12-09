// GET BIT
// Operation -> AND
// public class bits {
//     public static void main(String[] args){
//         int n = 5;
//         int pos = 2;
//         int bitmask = 1 << pos;

//         if((bitmask & n)==0){
//             System.out.println("bit was zero");
//         }
//         else{
//             System.out.println("bit was one");
//         }
//     }
// }


// Question ->  Number Complement

import java.util.Scanner;

public class bits{
    public static int findComplement(int num){
        String binaryString = Integer.toBinaryString(num);

        StringBuilder sb = new StringBuilder();

        for(char c : binaryString.toCharArray()){
            if(c=='0'){
                sb.append('1');
            }
            else{
                sb.append('0');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        int c = findComplement(num);

        System.out.println("The complement of "+ num+ " is "+ c);
        sc.close();
    }
}

