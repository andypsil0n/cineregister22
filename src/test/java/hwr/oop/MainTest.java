package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class MainTest {

    @Test
    void main_manualTest() {
        Main.main();
    }

    @Test
    void main_checkIfMoreMoviesWanted_yReturnsTrue() {
        assertThat(Main.checkIfMoreMoviesWanted("y")).isTrue();
    }

    @Test
    void main_checkIfMoreMoviesWanted_nReturnsFalse() {
        assertThat(Main.checkIfMoreMoviesWanted("n")).isFalse();
    }

    @Test
    void main_checkIfMoreMoviesWanted_nothingTHrowsException() {
        //when
        Throwable thrown = catchThrowable(() -> Main.checkIfMoreMoviesWanted("x"));

        //then
        assertThat(thrown).hasMessageContaining("Wrong input. Please only use 'y' or 'n'");
    }


}
