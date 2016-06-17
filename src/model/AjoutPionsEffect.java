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
        for (int i = 0; i < game.getBoard().getWidth(); i++) { // Pour toutes les collones
            if (game.getBoard().getTileIJ(0, i).getStatus() == -1) { // Si la collone n'est pas pleine de jetons
                int y = 0;
                while (game.getBoard().getTileIJ(y, i).getStatus() != -1 && y > game.getBoard().getHeight()) {
                    y++; // On se positionne dans la collone, le plus bas possible
                }
                if (y > 0) {
                    y--;
                    game.getBoard().getTileIJ(y, i).setStatus(game.getCurrentPlayer().getId()); // on place un jeton
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
