package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private final Lottos lottos;


    public LottoFactory(final AutoLottoFactory autoLottoFactory, final ManualLottoFactory manualLottoFactory) {

        lottos = new Lottos(addLottoList(autoLottoFactory, manualLottoFactory));
    }

    private List<Lotto> addLottoList(AutoLottoFactory autoLottoFactory, ManualLottoFactory manualLottoFactory) {
        List<Lotto> lottoList = new ArrayList<>();
        manualLottoFactory.addList(lottoList);
        autoLottoFactory.addList(lottoList);
        return lottoList;
    }

    public LottoMatcher matchNumbers(Lotto lastWeekLottoNums, LottoNumber bonusCount) {
        return LottoMatcher.ofMatch(lottos, LastWeekLotto.of(lastWeekLottoNums, bonusCount));
    }


    public int getLottoCount() {
        return lottos.getLottoCount();
    }


    public List<String> getLottoNumbersListToString() {
        return lottos.lottoNumbersToStringList();
    }

    public double getLottoRatio(LottoMatcher lottoMatcher, int lottoInvestMoney) {
        return lottoMatcher.getLottoRatio(new GameMoney(lottoInvestMoney));

    }
}