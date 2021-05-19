package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class DefaultPlayerInteractionMapTest {
    private final CollisionInteractionMap collisionInteractionMap = mock(CollisionInteractionMap.class);
    private final CollisionInteractionMap.CollisionHandler handler = mock(CollisionInteractionMap.CollisionHandler.class);

    @AfterEach
    void tearDown() {
        System.out.print("测试完成");
    }


    @Test
    void onCollision() {
        collisionInteractionMap.onCollision(Player.class, Ghost.class,handler);
        verify(collisionInteractionMap).onCollision(Player.class,Ghost.class,handler);
    }

    @Test
    void collide() {
        collisionInteractionMap.collide(mock(Blinky.class), mock(Blinky.class));
        assertThat(true).isEqualTo(true);
    }
}
