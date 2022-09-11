public class Piece


/* This is the Piece class, which is the type of object that each piece on the board is. The Piece class only holds two properties, the type of piece, and the team the piece
is on. */


{

    private String team;
    private String type;


    
    public Piece(String pieceType, String pieceTeam)
    {
        team = pieceTeam;
        type = pieceType;
    }

    public String getType()
    {
        return this.type;
    }

    public String getTeam()
    {
        return this.team;
    }



    public String toString()
    {
        String fullTeam = "x";
        String fullType = "y";
        
        if (this.type.equals("P"))
        {
            fullType = "Pawn";
        }
        if (this.type.equals("R"))
        {
            fullType = "Rook";
        }
        if (this.type.equals("k"))
        {
            fullType = "Knight";
        }
        if (this.type.equals("B"))
        {
            fullType = "Bishop";
        }
        if (this.type.equals("Q"))
        {
            fullType = "Queen";
        }
        if (this.type.equals("K"))
        {
            fullType = "King";
        }
        if (this.type.equals("N"))
        {
            fullType = "Empty Space";
        }
        if (this.team.equals("W"))
        {
            fullTeam = "White";
        }
        if (this.team.equals("B"))
        {
            fullTeam = "Black";
        }
        if (this.team.equals("N"))
        {
            fullTeam = "None";
        }
        return fullType +" on team "+fullTeam+".";
    }










}