package tw;

import java.util.Random;

import org.mockito.stubbing.Answer;

import net.bytebuddy.asm.Advice.This;
import tw.commands.GuessInputCommand;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

    private static final int RUN_TIMES = 6;

    public static void main(String[] args) throws Exception {
    	 int[] answer=new int[4];
    	 int inpuAnswer[] = new int[4];
    	 int sameCount =0;
    	 int localCount =0;
    	 String input="";
    	for(int i =0;i<4;i++ ) {
    	 //int origin = new Random().nextInt(9);
    		answer[i]=(int)(Math.random()*10); 
    		 //answer=String.valueOf(origin);
    		 for(int j = 0;j<i;j++){
                 if(answer[j]==answer[i]){
                     i--;
                 }
              }
    	}
    	for(int i:answer) {
    		System.out.print(i+" ");
    	}
    	
        for (int i = 0; i < RUN_TIMES; i++) {
           input = new GuessInputCommand().input();
          // System.out.println(input);
           String[] inputString = input.split(" ");         
           for(int j = 0 ;j < inputString.length;j++) {
        	   inpuAnswer[j] = Integer.parseInt(inputString[j]);
              }
           //对应位置数字相等
           for(int k = 0 ;k < inpuAnswer.length;k++) {
        	   if (inpuAnswer[k]==answer[k]) {
        		   sameCount++;
        	   }
              }
           //System.out.println(sameCount);
           //数字相等，位置不同
           for(int k = 0 ;k < 4;k++) {
        	   for(int j = 0 ;j < 4;j++) {
        	   if ( answer[k]==inpuAnswer[j]) {
        		   localCount++;
        	   }
        	  }
             }
           localCount=localCount-sameCount;
           System.out.println(sameCount+"A"+localCount+"B");
           localCount = 0;
           sameCount = 0;
        }  
    }
 }
