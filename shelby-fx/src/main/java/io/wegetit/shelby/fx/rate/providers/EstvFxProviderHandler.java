package io.wegetit.shelby.fx.rate.providers;

import io.wegetit.shelby.fx.rate.FXRateEntity;
import io.wegetit.shelby.fx.rate.FXRateEntityService;
import io.wegetit.shelby.fx.rate.FxProvider;
import io.wegetit.shelby.fx.rate.FxProviderHandler;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstvFxProviderHandler extends FxProviderHandler {

    public EstvFxProviderHandler(FXRateEntityService service) {
        super(service);
    }

    @Override
    public FxProvider getType() {
        return FxProvider.ESTV;
    }

    @Override
    public List<FXRateEntity> fetch(LocalDate date) throws Exception {
        List<FXRateEntity> rates = new ArrayList<>();
        URL url = new URL("http://www.pwebapps.ezv.admin.ch/apps/rates/estv/getavgxml?m=" + date.getMonth().getValue() + "&j=" + date.getYear());
        URLConnection con = url.openConnection();
        Document document = new SAXReader().read(con.getInputStream());

        XPath path = DocumentHelper.createXPath("//*[local-name()='devise']");
        List devises = path.selectNodes(document);

        for (int i=0; i<devises.size() ; i++) {
            Element devise = (Element)devises.get(i);
            BigDecimal multiplayer = new BigDecimal(devise.elementText("waehrung").split(" ")[0]);
            BigDecimal kurs = new BigDecimal(devise.elementText("kurs"));
            rates.addAll(buildMonthlyRates(date, devise.attributeValue("code").toUpperCase(), kurs.divide(multiplayer)));
        }
        return rates;
    }

    private List<FXRateEntity> buildMonthlyRates(LocalDate date, String source, BigDecimal rate) {
        List<FXRateEntity> rates = new ArrayList<>();
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = start.plusMonths(1);
        while (start.isBefore(end)) {
            rates.add(FXRateEntity.of(getType(), start, source, "CHF", rate));
            start = start.plusDays(1);
        }
        return rates;
    }
}
