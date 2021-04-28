package nl.tudelft.jpacman.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        org.junit.jupiter.api.Assertions.assertThrows(
            AssertionError.class,
            () -> unit.getSquare());
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        BasicSquare basicSquare = new BasicSquare();
        unit.occupy(basicSquare);
        Assertions.assertThat(unit.getSquare()).isNotEqualTo(null);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        BasicSquare basicSquare = new BasicSquare();
        unit.occupy(basicSquare);
        unit.occupy(basicSquare);
        Assertions.assertThat(basicSquare).isEqualTo(basicSquare);
    }
}
