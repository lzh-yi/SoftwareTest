package nl.tudelft.jpacman.npc.ghost;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.BasicSquare;
import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InkyTest {
    private static MapParser mapParser;
    private static Square square1;
    private static Square square2;
    private static Launcher launcher;
    private static Board board;
    private BoardFactory boardFactory;
    private PlayerFactory playerFactory;
    private GhostFactory ghostFactory;

    /**
     * 监听测试开始.
     *
     * 在所有的测试用例执行之前，先初始化每个测试用例都需要的参数.
     */
    @BeforeAll
    public static void init() {
        PacManSprites sprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
            sprites,
            new GhostFactory(sprites),
            new DefaultPointCalculator()
        );
        mapParser = new MapParser(levelFactory, new BoardFactory(sprites));
        square1 = new BasicSquare();
        square2 = new BasicSquare();
        launcher = new Launcher();
        launcher.launch();
        launcher.getGame().start();
        System.out.println("start test Inky!!!!");
    }

    /**
     * 监听测试结束.
     */
    @AfterAll
    static void afterAll() {
        System.out.println("finish test Inky!!!");
    }

    /**
     * 在每个测试用例执行之前都会执行该方法.
     */
    @BeforeEach
    public void beforeEach() {
        PacManSprites sprites = new PacManSprites();
        boardFactory = new BoardFactory(sprites);
        playerFactory = new PlayerFactory(sprites);
        ghostFactory = new GhostFactory(sprites);
    }

    /**
     * 采用参数化测试，测试inky在四个方向上的移动情况
     * @param s1
     * @param s2
     * @param x inky的移动方向
     */
    @ParameterizedTest
    @MethodSource("providerChase")
    void nextAiMoveChase(Square s1, Square s2, Direction x) {
        Ghost inky = ghostFactory.createInky();
        Player player = playerFactory.createPacMan();
        inky.occupy(s1);
        player.occupy(s2);
        assertThat(inky.nextAiMove()).isEqualTo(Optional.of(Direction.valueOf(x.name())));
    }

    static Stream<Arguments> providerChase() throws IOException {
        board = mapParser.parseMap("/board.txt").getBoard();

        return Stream.of(
            // 向上移动
            Arguments.of(board.squareAt(5, 13), board.squareAt(5, 1), Direction.SOUTH),
            // 向左移动
            Arguments.of(board.squareAt(5, 13), board.squareAt(5, 19), Direction.NORTH),
            // 向左移动
            Arguments.of(board.squareAt(5, 13), board.squareAt(15, 18), Direction.NORTH),
            // 向下移动
            Arguments.of(board.squareAt(5, 13), board.squareAt(1, 15), Direction.NORTH)
        );
    }

    @Test
    void nextAiMoveNull() throws IOException {
        board = mapParser.parseMap("/board.txt").getBoard();
        Ghost inky = ghostFactory.createInky();
        square1 = board.squareAt(5, 13);
        inky.occupy(square1);
        assertThat(inky.nextAiMove()).isEqualTo(Optional.empty());
    }
}
