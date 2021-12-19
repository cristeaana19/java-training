package clean.code.chess.requirements;

import java.awt.*;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(IsLegalBoardPosition(xCoordinate, yCoordinate) && IsValidPieceColor(xCoordinate, Color))
        { pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
        pawn.setPieceColor(pieceColor);
        this.pieces= new Pawn[xCoordinate][yCoordinate];

        }
        else pieces[MAX_BOARD_HEIGHT][MAX_BOARD_WIDTH] = pawn;
    }


    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if(xCoordinate<0 && yCoordinate<0) {
            return false;
        } else
            if(xCoordinate>7 && yCoordinate>7)
                return false;
            else if(xCoordinate>7 && yCoordinate<7)
                return false;
            else if(xCoordinate<7 && yCoordinate>7)
                return false;
            else if (xCoordinate>0 && yCoordinate<0)
                return false;
            else if(xCoordinate<0 && yCoordinate>0)
                return false;
            else return true;
    }


    public void AvoidDuplicates(Pawn pawn,int xNewCoordination, int yNewCoordination) {
            if(IsLegalBoardPosition(pawn.getXCoordinate(), pawn.getYCoordinate())){
                 xNewCoordination = pawn.getXCoordinate();
                 yNewCoordination = pawn.getYCoordinate();

                pawn.setXCoordinate(xNewCoordination);
                pawn.setYCoordinate(yNewCoordination);

                this.pieces[xNewCoordination][yNewCoordination] = pawn;

            }
            else this.pieces[xNewCoordination][yNewCoordination] = null;
        }
    }


    protected boolean IsValidPieceColor(int xCoordinate, Color color) {
        if (color == Color.WHITE) {
            return xCoordinate == 0 || xCoordinate == 1;
        }
        return xCoordinate == MAX_BOARD_HEIGHT - 1 || xCoordinate == MAX_BOARD_HEIGHT;
    }

}

