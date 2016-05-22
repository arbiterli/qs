package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * combination logic for calculate per 1000 rate and linear score.
 * 
 * @author xxd
 *
 */
public class Per1000RateLinearScoreCalculator extends AbstractLinearScoreCalculator {
    private static final String PER_THOUAND_FOR_UNIT = "/1k ";
    @Override
    public String getName() {
        return "per1000RateLinearScore";
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        if (scoreItem == null) {
            return null;
        }
        final int valueIndex = 1;
        final int leftValueIndex = 2;
        final int rightValueIndex = 3;
        final int paramSize = 4;
        final int oneThousand = 1000;
        List<ExtendItem> params = scoreItem.getItemList();
        getLogger().debug("in rateLinearScore method ");
        if (params != null && !params.isEmpty() && params.size() == paramSize) {
            try {
                ExtendItem result = new ExtendItem();
                result.setBasicItem(scoreItem);

                getLogger().debug("doing calculate ..");
                ExtendItem dataNumItem = params.get(0);
                ExtendItem dataDenItem = params.get(valueIndex);

                setItemLink(scoreItem, dataNumItem.getBasicItem());
                scoreItem.setUnit(dataNumItem.getBasicItem().getUnit() + PER_THOUAND_FOR_UNIT
                        + dataDenItem.getBasicItem().getUnit());

                String numeratorStr = getOneValueFromItem(dataNumItem, profile, cache);
                String denominatorStr = getOneValueFromItem(dataDenItem, profile, cache);

                getLogger().debug("in rateLinearScore method : score item :" + scoreItem.getName() + " numeratorStr :"
                        + numeratorStr + " denominatorStr :" + denominatorStr);
                if (numeratorStr == null || denominatorStr == null) {
                    scoreItem.setData(Constants.NO_DATA);
                    result.setData(Constants.NO_DATA);
                    result.setScore(0);
                    return result;
                }

                double numerator = Double.parseDouble(numeratorStr);
                double denominator = Double.parseDouble(denominatorStr);

                double rate = numerator / denominator * oneThousand;
                scoreItem.setData(dnf.format(rate));

                String leftValueStr = getOneValueFromItem(params.get(leftValueIndex), profile, cache);
                getLogger().debug("leftValueStr :" + leftValueStr);
                double leftValue = Double.parseDouble(leftValueStr);

                String rightValueStr = getOneValueFromItem(params.get(rightValueIndex), profile, cache);
                getLogger().debug("rightValueStr :" + rightValueStr);
                double rightValue = Double.parseDouble(rightValueStr);

                result.setScore(linearScoreMethod(rate, leftValue, rightValue));
                result.setData(scoreItem.getData());
                return result;
            } catch (Exception e) {
                super.getLogger().info(e.getMessage(), e);
               return null;
            }
        }
        return null;
    }
}
