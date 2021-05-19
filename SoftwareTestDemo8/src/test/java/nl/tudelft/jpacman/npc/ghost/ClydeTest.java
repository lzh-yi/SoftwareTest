package nl.tudelft.jpacman.npc.ghost;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClydeTest {

    private static MapParser mapParser;

    @BeforeAll
    public static void init() {
        PacManSprites pacManSprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
            pacManSprites,
            new GhostFactory(pacManSprites),
            new DefaultPointCalculator()
        );
        BoardFactory boardFactory = new BoardFactory(pacManSprites);
        GhostFactory ghostFactory = new GhostFactory(pacManSprites);
        mapParser = new GhostMapParser(levelFactory, boardFactory,ghostFactory);
    }

    /**
     * 该方法测试当Clyde和Player距离小于8个方块的时候，Clyde的行为
     */
    @Test
    @Order(1)
    @DisplayName("Clyde和Player距离小于8个方块")
    void departLessThanEight() {
        List<String> map = Lists.newArrayList(
            "##############",
            "#.#....C.....P",
            "##############"
        );
        Level level = mapParser.parseMap(map);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        // 创建 Player
        Player player = new PlayerFactory(new PacManSprites()).createPacMan();
        // 初始化Player的移动方向
        player.setDirection(Direction.valueOf("WEST"));
        // 注册新创建的Player对象
        level.registerPlayer(player);
        // 测试 nextAiMove 方法
        Optional<Direction> direction = clyde.nextAiMove();
        assertThat(direction.get()).isEqualTo(Direction.valueOf("WEST"));
    }

    /**
     * 该方法测试当Clyde和Player距离大于8个方块的时候，Clyde的行为
     */
    @Test
    @Order(2)
    @DisplayName("Clyde和Player距离大于8个方块")
    void departMoreThanEight() {
        List<String> map = Lists.newArrayList(
            "##############",
            "#.C..........P",
            "##############"
        );
        Level level = mapParser.parseMap(map);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        // 创建 Player
        Player player = new PlayerFactory(new PacManSprites()).createPacMan();
        // 初始化Player的移动方向
        player.setDirection(Direction.valueOf("WEST"));
        // 注册新创建的Player对象
        level.registerPlayer(player);
        // 测试 nextAiMove 方法
        Optional<Direction> direction = clyde.nextAiMove();
        assertThat(direction.get()).isEqualTo(Direction.valueOf("EAST"));

    }

    /**
     * 该方法测试当地图上没有Player的时候，Clyde的行为
     */
    @Test
    @Order(3)
    @DisplayName("地图上没有Player")
    void departWhitoutPlayer() {
        List<String> map = Lists.newArrayList(
            "##############",
            "#.#....C......",
            "##############"
        );
        Level level = mapParser.parseMap(map);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(clyde).isNotNull();
        assertThat(clyde.getDirection()).isEqualTo(Direction.valueOf("EAST"));
        assertThat(level.isAnyPlayerAlive()).isFalse();
        // 测试 nextAiMove 方法
        Optional<Direction> direction = clyde.nextAiMove();
        assertThat(direction.isPresent()).isFalse();
    }

    /**
     * 该方法测试当Clyde和Player之间没有路径的时候，Clyde的行为
     */
    @Test
    @Order(4)
    @DisplayName("Clyde和Player之间没有距离")
    void departWithoutPath() {
        List<String> map = Lists.newArrayList(
            "#########P####",
            "#.#....C......",
            "##############"
        );
        Level level = mapParser.parseMap(map);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        assertThat(level.isAnyPlayerAlive()).isFalse();
        Optional<Direction> direction = clyde.nextAiMove();
        assertThat(direction.isPresent()).isFalse();
    }

}
