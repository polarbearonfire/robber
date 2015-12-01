/*    */ package Input;
/*    */ 
/*    */ import enums.Commands;
import startup.GameController;

import java.awt.event.KeyEvent;
/*    */ 
/*    */ public class KeyboardListener implements java.awt.event.KeyListener
/*    */ {
/*    */   GameController _gameController;
/*    */   
/*    */   public KeyboardListener(GameController gc) {
/* 10 */     this._gameController = gc;
/*    */   }
/*    */   
/*    */   public void keyPressed(KeyEvent e)
/*    */   {
/* 15 */     switch (e.getKeyCode()) {
/*    */     case 40: 
/* 17 */       this._gameController.buttonPressed(Commands.GoDown);
/* 18 */       break;
/*    */     case 38: 
/* 20 */       this._gameController.buttonPressed(Commands.GoUp);
/* 21 */       break;
/*    */     case 39: 
/* 23 */       this._gameController.buttonPressed(Commands.GoRight);
/* 24 */       break;
/*    */     case 37: 
/* 26 */       this._gameController.buttonPressed(Commands.GoLeft);
/* 27 */       break;
/*    */     case 32: 
/* 29 */       this._gameController.buttonPressed(Commands.PullTrigger);
/* 30 */       break;
/*    */     case 65: 
/* 32 */       this._gameController.buttonPressed(Commands.RotateCounterClockwise);
/* 33 */       break;
/*    */     case 68: 
/* 35 */       this._gameController.buttonPressed(Commands.RotateClockwise);
/* 36 */       break;
/*    */     case 84: 
/* 38 */       this._gameController.buttonPressed(Commands.SwitchWeapon);
/*    */     }
/*    */     
/*    */   }
/*    */   
/*    */   public void keyReleased(KeyEvent e)
/*    */   {
/* 45 */     switch (e.getKeyCode()) {
/*    */     case 40: 
/* 47 */       this._gameController.buttonPressed(Commands.StopDown);
/* 48 */       break;
/*    */     case 38: 
/* 50 */       this._gameController.buttonPressed(Commands.StopUp);
/* 51 */       break;
/*    */     case 39: 
/* 53 */       this._gameController.buttonPressed(Commands.StopRight);
/* 54 */       break;
/*    */     case 37: 
/* 56 */       this._gameController.buttonPressed(Commands.StopLeft);
/* 57 */       break;
/*    */     
/*    */ 
/*    */     case 65: 
/* 61 */       this._gameController.buttonPressed(Commands.StopRotateCounterClockwise);
/* 62 */       break;
/*    */     case 68: 
/* 64 */       this._gameController.buttonPressed(Commands.StopRotateClockwise);
/*    */
        case KeyEvent.VK_SPACE:
            this._gameController.buttonPressed(Commands.StopUsingItem);
    }
/*    */   }
/*    */   
/*    */   public void keyTyped(KeyEvent e) {}
/*    */ }


/* Location:              /Users/danecarlson/Desktop/futurejava/!/behindTheScenes/KeyboardListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */