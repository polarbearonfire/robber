package startup;/*    */

import startup.GameController;

/*    */
/*    */ 
/*    */ public class Launcher
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*  8 */     GameController master = new GameController();
/*  9 */     master.setUp();
/*    */     
/*    */ 
/* 12 */     Thread t = new Thread(master);
/* 13 */     t.start();
/*    */   }
/*    */ }


/* Location:              /Users/danecarlson/Desktop/futurejava/!/behindTheScenes/startup.Launcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */