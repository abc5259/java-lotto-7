package lotto.domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 로또_결과를_계산한다() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto6 = new Lotto(List.of(1, 2, 9, 10, 11, 12));
        Lotto lotto7 = new Lotto(List.of(1, 13, 9, 10, 11, 12));
        Lottos lottos = Lottos.from(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
        WinningLotto winningLotto = new WinningLotto(lotto1, new Bonus(7));

        //when
        Map<Ranking, Integer> lottoResult = lottos.calculateLottoResult(winningLotto);

        //then
        Map<Ranking, Integer> expectedResults = Map.of(
                Ranking.FIRST, 1,
                Ranking.SECOND, 1,
                Ranking.THIRD, 1,
                Ranking.FOURTH, 1,
                Ranking.FIFTH, 1,
                Ranking.MISS, 2
        );
        Assertions.assertThat(lottoResult).isEqualTo(expectedResults);
    }
}