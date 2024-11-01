package lotto.domain;

import java.util.Optional;

public class WinningLotto {
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (lotto.contains(bonus.getNumber())) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    public Optional<Ranking> calculateRanking(Lotto lotto) {
        int count = this.lotto.countCommonElements(lotto);
        return Ranking.findBy(count, lotto.contains(bonus.getNumber()));
    }
}
