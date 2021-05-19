package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerCollisionsTest {
    private final Pellet pellet = mock(Pellet.class);
    private final Player player = mock(Player.class);
    private final PlayerCollisions playerCollisions = mock(PlayerCollisions.class);
    private final Ghost abstractGhost = mock(Ghost.class);
    private final Sprite sprite = mock(Sprite.class);

    @BeforeEach
    void setUp() {
        playerCollisions.playerVersusGhost(player,abstractGhost);
        playerCollisions.playerVersusPellet(player,pellet);
    }

    @AfterEach
    void tearDown() {
        System.out.print("测试完成");
    }

    @Test
    void testPlayerVersusGhost() {
        assertThat(player.isAlive()).isFalse();
    }

    @Test
    void testPlayerVersusPellet() {
        assertThat(player.getScore()).isEqualTo(0);
    }

}
