package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.quality.StringUtil;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.metricengine.BasicItem;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * AbstractLinearScoreCalculator.
 * 
 * @author xxd
 *
 */
public abstract class AbstractLinearScoreCalculator extends AbstractCalculator {
    /**
     * logic for linear score calculate.
     * 
     * 
     * @param srcData
     * @param leftVal
     *            (zero score value)
     * @param rightVal
     *            (full score value)
     * @return
     */
    protected int linearScoreMethod(double srcData, double leftVal, double rightVal) {
        getLogger().debug("srcData : " + srcData + " leftVal : " + leftVal + " rightVal : " + rightVal);

        if (rightVal >= leftVal) {
            if (srcData >= rightVal) {
                return FULL_SCORE;
            } else if (srcData < leftVal) {
                return 0;
            } else {
                return (int) ((srcData - leftVal) * FULL_SCORE / (rightVal - leftVal));
            }
        } else {
            if (srcData <= rightVal) {
                return FULL_SCORE;
            } else if (srcData > leftVal) {
                return 0;
            } else {
                return FULL_SCORE - (int) ((srcData - rightVal) * FULL_SCORE / (leftVal - rightVal));
            }
        }
    }

    /**
     * Set the link of the parentItem to the childItem link when the parent item
     * link is null.
     * 
     * @param basicItem
     * @param subItem
     */
    protected void setItemLink(BasicItem parentItem, BasicItem childItem) {
        if (StringUtil.isEmpty(parentItem.getLink())) {
            parentItem.setLink(childItem.getLink());
        }
    }

    protected ExtendItem linearScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        getLogger().debug("in linearScore method ");
        if (scoreItem == null) {
            return null;
        }
        final int paramSzie = 3;
        List<ExtendItem> params = scoreItem.getItemList();
        if (params != null && !params.isEmpty() && params.size() == paramSzie) {
            ExtendItem result = new ExtendItem();
            result.setBasicItem(scoreItem);
            try {
                getLogger().debug("doing calculate ..");
                ExtendItem dataItem = params.get(0);

                setItemLink(scoreItem, dataItem.getBasicItem());
                scoreItem.setUnit(dataItem.getBasicItem().getUnit());

                String calDataStr = getOneValueFromItem(dataItem, profile, cache);
                getLogger().debug("calDataStr :" + calDataStr);
                if (calDataStr == null) {
                    scoreItem.setData(Constants.NO_DATA);
                    result.setData(Constants.NO_DATA);
                    result.setScore(0);
                    return result;
                }

                double calData = Double.parseDouble(calDataStr);
                scoreItem.setData(dnf.format(calData));

                String leftValueStr = getOneValueFromItem(params.get(1), profile, cache);
                getLogger().debug("leftValueStr :" + leftValueStr);
                double leftValue = Double.parseDouble(leftValueStr);

                String rightValueStr = getOneValueFromItem(params.get(2), profile, cache);
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
}
