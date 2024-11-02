package asset;

import java.util.ArrayList;
import java.util.List;
import finance.FinanceData;

public class TotalAsset {

    private List<FixedAsset> fixedAssets =new ArrayList<>();//固定产列表

    public double totalFixAsset(){
        double fixtotal = 0;
        for(FixedAsset asset:fixedAssets ){
            fixtotal += asset.getValue();
        }
        return fixtotal;
    }

}
