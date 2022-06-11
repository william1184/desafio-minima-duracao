package br.com.teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class DuracoesFilmesTest {

    @ParameterizedTest
    @ValueSource(floats = {2.01F, 2.5F, 3.0F })
    void deveRetonarQuantidadeMinimaDeDiasComoUm(float duracao) {
        int dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Collections.singletonList(duracao))
        );

        Assertions.assertEquals(1, dias);
    }

    @Test
    void deveRetonarQuantidadeMinimaDeDiasComoUmcomMultiplosFilmes() {
        int dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.0F, 1.0F, 1.0F))
        );

        Assertions.assertEquals(1, dias);

        dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.0F, 1.0F))
        );

        Assertions.assertEquals(1, dias);

        dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.0F, 2.0F))
        );

        Assertions.assertEquals(1, dias);
    }

    @Test
    void deveRetonarQuantidadeMinimaDeDiasComoDoiscomMultiplosFilmes() {
        int dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.0F, 1.0F, 1.0F,1.0F, 1.0F, 1.0F))
        );

        Assertions.assertEquals(2, dias);

        dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.0F, 1.0F, 2.0F, 2.0F))
        );

        Assertions.assertEquals(2, dias);

        dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.0F, 2.0F, 3.0F))
        );

        Assertions.assertEquals(2, dias);
    }

    @Test
    void deveRetonarQuantidadeMinimaDeDiasComoTres() {
        int dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.10F, 1.10F, 1.10F, 2.400F, 1.90F))
        );

        Assertions.assertEquals(3, dias);

        dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.10F, 1.10F, 1.10F, 2.400F))
        );

        Assertions.assertEquals(3, dias);
    }

    @Test
    void deveRetonarQuantidadeMinimaDeDiasComoQuatro() {
        int dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.10F, 2.400F, 1.90F, 1.90F, 1.10F, 1.10F))
        );

        Assertions.assertEquals(4, dias);

        dias = DuracoesFilmes.tempoMinimoDias(
                new ArrayList<>(Arrays.asList(1.10F, 1.10F, 1.10F, 2.400F, 1.90F, 1.90F))
        );

        Assertions.assertEquals(4, dias);
    }

    @Test
    void deveRetonarQuantidadeMinimaDeDiasComoCinco() {
        int dias = DuracoesFilmes.tempoMinimoDias(
            new ArrayList<>(Arrays.asList(1.0F, 1.0F, 1.0F, 1.1F, 1.1F, 2.0F, 2.0F, 2.0F, 2.50F))
        );

        Assertions.assertEquals(5, dias);
    }
}