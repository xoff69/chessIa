import com.xoff.chessia.GameStateChess;
import com.xoff.ia.common.Minimax;
import org.junit.Assert;
import org.junit.Test;

public class ChessMinimaxTest {
    @Test
    public void test1() {
        GameStateChess gameStateChess=new GameStateChess();

        Assert.assertEquals(5.0, Minimax.minimax(gameStateChess, 5, true), 0.0f);
    }

}
