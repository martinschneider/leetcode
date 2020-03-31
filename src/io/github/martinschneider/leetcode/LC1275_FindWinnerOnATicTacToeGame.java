package io.github.martinschneider.leetcode;

// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
public class LC1275_FindWinnerOnATicTacToeGame {
  public String tictactoe(int[][] moves) {
    int[] board = {0, 0};

    // Each pair in the input can be considered as a base 3 number:
    // {0, 0} -> 0
    // {0, 1} -> 1
    // ...
    // {i, j} -> i * 3 + j
    // ...
    // {2, 2} -> 8
    //
    // We use this number as the exponent for a power of 2 and sum over all moves for each player =>
    //
    // board[0] = numerical representation of the sum of all moves by player A
    // board[1] = same for player B
    for (int i = 0; i < moves.length; i++) {
      // board = board + 2^(input in base 3)
      board[i % 2] += 1 << (moves[i][0] * 3 + moves[i][1]);
    }

    // There are 8 winning positions (3 horizontal, 3 vertical and 2 diagonal). We store bit
    // representations of them:
    int[] wins =
        {0b111000000, 0b111000, 0b111, 0b100100100, 0b10010010, 0b1001001, 0b100010001, 0b1010100};

    // We add (logical AND) a player's board to each winning position.
    // If the value doesn't change => this player has reached that winning position.
    for (int i = 0; i < wins.length; i++) {
      if ((wins[i] & board[0]) == wins[i]) {
        return "A";
      } else if ((wins[i] & board[1]) == wins[i]) {
        return "B";
      }
    }

    // If neither A nor B won it's a draw if all fields are occupied and pending otherwise.
    return (moves.length == 9) ? "Draw" : "Pending";
  }
}
