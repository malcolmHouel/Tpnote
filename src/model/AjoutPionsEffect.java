package model;

/**
 *
 * @author p1504841
 */
public class AjoutPionsEffect extends Effect {

    /**
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        for (int i = 0; i < game.getBoard().getWidth(); i++) {
            if (game.getBoard().getTileIJ(0, i).getStatus() == -1) {
                int y = 0;
                while (game.getBoard().getTileIJ(y, i).getStatus() != -1 && y > game.getBoard().getHeight()) {
                    y++;
                }
                if (y > 0) {
                    y--;
                    game.getBoard().getTileIJ(y, i).setStatus(game.getCurrentPlayer().getId());
                }
                Player tmp = game.Win();
                if (tmp != null) {
                    game.setWinner(tmp);
                }
                game.isOver();
                if (game.getCurrentPlayer().getId() == 1) {
                    game.setCurrentPlayer(2);
                } else {
                    game.setCurrentPlayer(1);
                }

                game.setChanged();
                game.notifyObservers();

            }

        }
    }

}
