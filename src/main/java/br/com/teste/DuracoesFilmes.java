package br.com.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuracoesFilmes {

    public static final float MAXIMO_PARA_MULTIPLOS_FILMES = 2.000F;

    public static int tempoMinimoDias(List<Float> duracoes) {
        Collections.sort(duracoes, Collections.reverseOrder());

        float somarDuracoes = 0F;
        float maiorDuracao = 0F;
        float menorDuracao = 0F;

        List<Float> duracoesSomadas = new ArrayList<>();

        for (int idx = 0; idx < duracoes.size(); idx++) {
            maiorDuracao = duracoes.get(idx);
            somarDuracoes = maiorDuracao;

            if(maiorDuracao > MAXIMO_PARA_MULTIPLOS_FILMES) {
                duracoes.remove(maiorDuracao);
                duracoesSomadas.add(maiorDuracao);
                idx--;
                continue;
            }

            for (int idx2 = duracoes.size()-1; idx2 > 0; idx2--) {

                if(idx == idx2){
                    continue;
                }

                menorDuracao = duracoes.get(idx2);
                somarDuracoes = somarDuracoes + menorDuracao;

                if(somarDuracoes <= MAXIMO_PARA_MULTIPLOS_FILMES ) {
                    duracoes.remove(menorDuracao);
                    idx2 = duracoes.size();
                    continue;
                }

                duracoes.remove(menorDuracao);
                break;

            }

            duracoes.remove(maiorDuracao);
            duracoesSomadas.add(somarDuracoes);
            idx--;

        }

        return duracoesSomadas.size() + duracoes.size();
    }

}

