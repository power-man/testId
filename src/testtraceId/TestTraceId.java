package testtraceId;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestTraceId implements Runnable{

    public static void main(String[] args) { 
        ExecutorService pool = Executors.newFixedThreadPool(2000); 
        for (int i = 0; i <2000; i++) { 
                pool.execute(new TestTraceId());
                
                
        } 
        pool.shutdown(); 
} 

public static String genReqID() { 
//        return UUID.randomUUID().toString().replace("-", "").toUpperCase(); 
        return UUID.randomUUID().toString().toUpperCase(); 
} 


public void run() { 
//        for (int i = 0; i < 1000; i++) { 
//                System.out.println(genReqID()); 
//               
//                
//        } 
        for (int i = 0; i < 1000; i++) { 
            System.out.println(toString()); 
           
            
    };
}

private Random random=new Random();

   
   public Random getRandom() {
       return random;
   }
   public void setRandom(Random random) {
       this.random = random;
   }

   public
   long createId() {
       return  this.random.nextLong();
   }
   public String traceIdString() {
       char[] result = new char[16];
       writeHexLong(result, 0, this.createId());
       return new String(result);
   }

   public static String idToHex(long id) {
       char[] data = new char[16];
       writeHexLong(data, 0, id);
       return new String(data);
   }

   static void writeHexLong(char[] data, int pos, long v) {
       writeHexByte(data, pos + 0, (byte) (int) (v >>> 56 & 0xFF));
       writeHexByte(data, pos + 2, (byte) (int) (v >>> 48 & 0xFF));
       writeHexByte(data, pos + 4, (byte) (int) (v >>> 40 & 0xFF));
       writeHexByte(data, pos + 6, (byte) (int) (v >>> 32 & 0xFF));
       writeHexByte(data, pos + 8, (byte) (int) (v >>> 24 & 0xFF));
       writeHexByte(data, pos + 10, (byte) (int) (v >>> 16 & 0xFF));
       writeHexByte(data, pos + 12, (byte) (int) (v >>> 8 & 0xFF));
       writeHexByte(data, pos + 14, (byte) (int) (v & 0xFF));
   }

   static void writeHexByte(char[] data, int pos, byte b) {
       data[(pos + 0)] = HEX_DIGITS[(b >> 4 & 0xF)];
       data[(pos + 1)] = HEX_DIGITS[(b & 0xF)];
   }

   static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
           'e', 'f' };
  
   public String toString() {
       // TODO Auto-generated method stub
       return "[Trace: " + traceIdString() + "]";
   }
   
}
