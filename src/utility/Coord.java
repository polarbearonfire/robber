/*    */ package utility;
/*    */ 
/*    */ public class Coord {
/*    */   int _x;
/*    */   int _y;
/*    */   
/*    */   public Coord(int x, int y) {
/*  8 */     this._x = x;
/*  9 */     this._y = y;
/*    */   }
/*    */   
/*    */   public int getY() {
/* 13 */     return this._y;
/*    */   }
/*    */   
/*    */   public int getX() {
/* 17 */     return this._x;
/*    */   }
/*    */   
/*    */   public boolean equals(Coord toCompare)
/*    */   {
/* 22 */     if ((toCompare.getX() == getX()) && (toCompare.getY() == getY())) {
/* 23 */       return true;
/*    */     }
/* 25 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/danecarlson/Desktop/futurejava/!/items/Coord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */