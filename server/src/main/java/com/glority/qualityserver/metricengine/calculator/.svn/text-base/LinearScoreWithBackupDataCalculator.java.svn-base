package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * the latest 2 item are left value(zero score) and right value(full score).
 * 
 * the rule for backup data choose : if this item value is null or zero, choose
 * next one
 * 
 * @author xxd
 * 
 */
public class LinearScoreWithBackupDataCalculator extends AbstractLinearScoreCalculator {

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        getLogger().debug("in linearScore method ");
        if (scoreItem == null) {
            return null;
        }
        final int paramSize = 3;
        List<ExtendItem> params = scoreItem.getItemList();
        if (params != null && !params.isEmpty() && params.size() >= paramSize) {
            try {
                int paramsSize = params.size();
                getLogger().debug("doing calculate ..");

                String calDataStr = null;
                for (int i = 0; i < paramsSize - 2; i++) {
                    ExtendItem dataItem = params.get(i);
                    calDataStr = getOneValueFromItem(dataItem, profile, cache);
                    if (calDataStr != null) {
                        try {
                            double value = Double.parseDouble(calDataStr);
                            if (value > 0) {
                                setItemLink(scoreItem, dataItem.getBasicItem());
                                scoreItem.setUnit(dataItem.getBasicItem().getUnit());
                                break;
                            }
                        } catch (Exception e) {
                            getLogger().error("config for item : " + dataItem + " may wrong");
                        }
                    }
                }

                ExtendItem result = new ExtendItem();
                result.setBasicItem(scoreItem);

                getLogger().debug("calDataStr :" + calDataStr);
                if (calDataStr == null) {
                    scoreItem.setData(Constants.NO_DATA);
                    result.setScore(0);
                    return result;
                }

                double calData = Double.parseDouble(calDataStr);
                scoreItem.setData(dnf.format(calData));

                String leftValueStr = getOneValueFromItem(params.get(paramsSize - 2), profile, cache);
                getLogger().debug("leftValueStr :" + leftValueStr);
                double leftValue = Double.parseDouble(leftValueStr);

                String rightValueStr = getOneValueFromItem(params.get(paramsSize - 1), profile, cache);
                getLogger().debug("rightValueStr :" + rightValueStr);
                double rightValue = Double.parseDouble(rightValueStr);

                result.setData(scoreItem.getData());
                result.setScore(linearScoreMethod(calData, leftValue, rightValue));
                return result;
            } catch (Exception e) {
                super.getLogger().info(e.getMessage(), e);
                return null;
            }
        }
        return null;

    }

    @Override
    public String getName() {
        return "linearScoreWithBackupData";
    }

}
