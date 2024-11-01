package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Ranking;

public class OutputView {

    public void printPurchaseLottos(List<Lotto> lottos) {
        printEmptyLine();
        printPurchaseCount(lottos.size());
        lottos.forEach(this::printLotto);
        printEmptyLine();
    }

    private void printPurchaseCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);

        String outputNumbers = numbers.stream()
                .map(String::valueOf) // 각 숫자를 문자열로 변환
                .collect(Collectors.joining(", "));
        System.out.printf("[%s]\n", outputNumbers);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printLottoResults(LottoResult lottoResult) {
        printEmptyLine();
        printLottoResultsNoticeMessage();
        printLottoResult(lottoResult);
        printRevenue(lottoResult);
    }

    private void printLottoResultsNoticeMessage() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printLottoResult(LottoResult lottoResult) {
        Arrays.stream(Ranking.values()).sorted(Comparator.comparingInt(Ranking::getMatchCount))
                .forEach(ranking -> printLottoResult(lottoResult.getLottoResults(), ranking));
    }

    public void printLottoResult(Map<Ranking, Integer> lottoResults, Ranking ranking) {
        int count = lottoResults.getOrDefault(ranking, 0);
        if (ranking.isRequireMatchBonus()) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", ranking.getMatchCount(), ranking.getPrize(), count);
        } else {
            System.out.printf("%d개 일치 (%,d원) - %d개\n", ranking.getMatchCount(), ranking.getPrize(), count);
        }
    }

    private void printRevenue(LottoResult lottoResult) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoResult.getRevenue());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

}
