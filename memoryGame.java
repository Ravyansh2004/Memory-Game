import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class memoryGame {

    public static void printBoard(String[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print("| "+arr[i]+" ");
        }
        System.out.println("|");


    }
    public static int getIndex(Scanner scanner, String[] board, boolean[] flipped, String prompt){
        System.out.println(prompt);
        int index;
           while(true) {
               index = scanner.nextInt();

            if (index < 0 || index >= board.length) {
                System.out.println("Invalid value of index.Re-enter Index!");
                continue;

            } else if (flipped[index]){
                System.out.println("The token at this index is already flipped.Re-enter Index!");
                continue;

            }
            else{
                break;
            }

        }

        return index;
    }


    public static void main(String[] args){
     System.out.println("Welcome to memory Game");
     Scanner sc=new Scanner(System.in);
     ArrayList<String> tokens= new ArrayList<>();
     //4 pairs
     tokens.add("*");tokens.add("*");
     tokens.add("@");tokens.add("@");
     tokens.add("$");tokens.add("$");
     tokens.add("!");tokens.add("!");
     Collections.shuffle(tokens);
     String[] board=new String[tokens.size()];

     Arrays.fill(board," ");
     boolean[] flipped=new boolean[tokens.size()];
     printBoard(board);
     int pairFound=0;
     while(pairFound<4) {


         System.out.println("Enter the value of 2 indices:");
         int firstIndex =getIndex(sc,board,flipped,"enter the value of first index:");
         board[firstIndex] = tokens.get(firstIndex);
         flipped[firstIndex]=true;
         printBoard(board);
         int secondIndex = getIndex(sc,board,flipped,"enter the value of second index:");
         board[secondIndex] = tokens.get(secondIndex);
         flipped[secondIndex]=true;
         printBoard(board);
         if(board[firstIndex]==board[secondIndex]){
             System.out.println("pair found");
             pairFound++;

         }
         else{
             board[firstIndex]=" ";
             board[secondIndex]=" ";
             flipped[firstIndex]=false;
             flipped[secondIndex]=false;
             System.out.println("Pair not found ! Try again:");
             printBoard(board);
         }
     }

     System.out.println("Congratulations! You won.");

    }
}
