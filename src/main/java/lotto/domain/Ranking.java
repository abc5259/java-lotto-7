package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Ranking {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false);

    private final int prize;
    private final int matchCount;
    private final boolean isRequireMatchBonus;

    Ranking(int prize, int matchCount, boolean isRequireMatchBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isRequireMatchBonus = isRequireMatchBonus;
    }

    public static Optional<Ranking> findBy(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchCount == matchCount &&
                        (!ranking.isRequireMatchBonus || isMatchBonus))
                .findFirst();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequireMatchBonus() {
        return isRequireMatchBonus;
    }
}