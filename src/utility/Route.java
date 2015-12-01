/*    */ package utility;

import utility.Coord;

/*    */
/*    */ public class Route {
/*    */   protected Coord _coord1;
/*    */   protected Coord _coord2;
/*    */   protected Coord _coord3;
/*    */   protected Coord _coord4;
/*    */   
/*  9 */   public Route(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { this._coord1 = new Coord(x1, y1);
/* 10 */     this._coord2 = new Coord(x2, y2);
/* 11 */     this._coord3 = new Coord(x3, y3);
/* 12 */     this._coord4 = new Coord(x4, y4);
/*    */   }
/*    */   
/*    */   public Coord getCoord1() {
/* 16 */     return this._coord1;
/*    */   }
/*    */   
/* 19 */   public Coord getCoord2() { return this._coord2; }
/*    */   
/*    */   public Coord getCoord3() {
/* 22 */     return this._coord3;
/*    */   }
/*    */   
/* 25 */   public Coord getCoord4() { return this._coord4; }
/*    */ }


/* Location:              /Users/danecarlson/Desktop/futurejava/!/items/Route.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */