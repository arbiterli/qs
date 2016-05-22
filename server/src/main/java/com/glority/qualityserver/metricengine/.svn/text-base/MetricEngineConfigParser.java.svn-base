package com.glority.qualityserver.metricengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.glority.qualityserver.ServerErrorCollector;
import com.glority.qualityserver.UserRole;

/**
 * Metric engine config parser. this class parse the config file and based on
 * the config, form all the items: MetricItem, ScoreItem, DataItem and
 * ExtendItem.
 * 
 * @author liheping
 * 
 */
public class MetricEngineConfigParser {
    private static final String SCORE = "score";
    private static final String DATA = "data";
    private static final String ID = "id";
    private static final String VALUE = "value";
    private static final String TYPE = "type";
    private static final String POWER = "power";
    private static final String REF = "ref";
    private static final String NAME = "name";
    private static final String CALCULATE_METHOD = "calculatemethod";
    private static final String METRIC = "metric";
    private static final String DISPLAY = "display";
    private static final String LANG = "lang";
    private static final String ROLE = "role";
    private static final String LINK = "link";
    private static final String DOC = "doc";
    private static final String GETSCORE = "getscore";
    private static final String UNIT = "unit";
    private static final String EXPECTED = "expected";
    private static final String EXISTS = "exists";
    private static final String DATATYPE = "datatype";

    private static final Logger LOGGER = Logger.getLogger(MetricEngineConfigParser.class);
    private static final String ENGINE_CONFIG = "metricEngine.xml";
    private Map<String, BasicItem> items;
    private List<Element> scoreElementList = null;

    public Map<String, BasicItem> parse() {
        this.items = new HashMap<String, BasicItem>();

        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(MetricEngine.class.getClassLoader().getResourceAsStream(ENGINE_CONFIG));
            Element root = doc.getRootElement();

            this.formEngine(root);

            checkItems();

            LOGGER.debug("init score engine finished.");
        } catch (Exception e) {
            ServerErrorCollector.getInstance().collectError(e.getStackTrace().toString(), "init score engine failed!");
            LOGGER.error(e.getMessage(), e);
        }

        return this.items;
    }

    /**
     * Check if duplicate item is exist in items.
     * 
     * @throws Exception
     */
    private void checkItems() throws Exception {
        Iterator<String> keyIterator = items.keySet().iterator();
        while (keyIterator.hasNext()) {
            String scoreName = keyIterator.next();
            BasicItem item = items.get(scoreName);
            List<String> socreItemNames = new ArrayList<String>();
            List<String> metricItemNames = new ArrayList<String>();
            String itemName = item.getName();
            if (item instanceof ScoreItem) {
                checkTheDuplicateItemName(socreItemNames, itemName);
            } else if (item instanceof MetricItem) {
                checkTheDuplicateItemName(metricItemNames, itemName);
            }
        }
    }

    /**
     * Check if duplicate itemName is exist in itemNames.
     * 
     * @param itemNames
     *            Item name list
     * @param itemName
     *            Single item name
     * @throws Exception
     */
    private void checkTheDuplicateItemName(List<String> itemNames, String itemName) throws Exception {
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).equals(itemName)) {
                String errorMessage = "Item Name: " + itemName + "had already been exist in quality system.";
                LOGGER.error(errorMessage);
                throw new Exception(errorMessage);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void formEngine(Element root) {
        LOGGER.debug("load configed data ");
        List<Element> dataList = root.elements(DATA);
        if (dataList != null && !dataList.isEmpty()) {
            LOGGER.debug("load data ");
            this.initDataItem(dataList);
        }

        List<Element> metricList = root.elements(METRIC);
        if (metricList != null && !metricList.isEmpty()) {
            LOGGER.debug("load metric");
            this.initMetricItem(metricList);
        }

        this.scoreElementList = root.elements(SCORE);
        if (this.scoreElementList != null && !this.scoreElementList.isEmpty()) {
            LOGGER.debug("load score ");
            this.initScoreItem(this.scoreElementList);
        }
    }

    private void initDataItem(List<Element> dataList) {
        for (Element data : dataList) {
            BasicItem dataItem = this.parseDataItem(data);

            addItem(dataItem);
        }
    }

    private void initMetricItem(List<Element> metricList) {
        for (Element metric : metricList) {
            BasicItem metricItem = this.parseMetricItem(metric);
            addItem(metricItem);
        }

    }

    private void initScoreItem(List<Element> scoreList) {
        for (Element score : scoreList) {
            ScoreItem scoreItem = this.parseScoreItem(score);
            addItem(scoreItem);
        }
    }

    @SuppressWarnings("unchecked")
    private DataItem parseDataItem(Element element) {
        if (element == null || !DATA.equals(element.getName())) {
            return null;
        }

        BasicItem item = this.parseBasicItem(element);

        String type = null;
        Attribute typeAttr = element.attribute(TYPE);
        if (typeAttr != null) {
            type = typeAttr.getText();
        }

        String value = null;
        Attribute valueAttr = element.attribute(VALUE);
        if (valueAttr != null) {
            value = valueAttr.getText();
        }

        double getScore = 0.0;
        Attribute getScoreAttr = element.attribute(GETSCORE);
        if (getScoreAttr != null) {
            String scoreStr = getScoreAttr.getText();
            try {
                getScore = Double.parseDouble(scoreStr);
            } catch (Exception e) {
                LOGGER.error("config file may have wrong config on getScore!");
            }
        }

        // TODO these code put here to suport data item contains method. now
        // this is not used.
        List<ExtendItem> extendItemList = new ArrayList<ExtendItem>();
        // get all the data elements
        List<Element> extendElementList = element.elements();
        if (extendElementList != null && !extendElementList.isEmpty()) {
            for (Element extendElement : extendElementList) {
                ExtendItem extendItem = this.parseExtendItem(extendElement);
                extendItemList.add(extendItem);
            }
        }
        DataItem dataItem = new DataItem(item, type, value, getScore, extendItemList);

        return dataItem;
    }

    private MetricItem parseMetricItem(Element element) {
        if (element == null || !METRIC.equals(element.getName())) {
            return null;
        }

        BasicItem item = this.parseBasicItem(element);

        String metricType = null;
        Attribute typeAttr = element.attribute(TYPE);
        if (typeAttr != null) {
            metricType = typeAttr.getText();
        }

        Attribute unitAttr = element.attribute(UNIT);
        if (unitAttr != null) {
            item.setUnit(unitAttr.getText());
        }

        MetricItem metricItem = new MetricItem(item, metricType, item.getName());

        return metricItem;
    }

    @SuppressWarnings("unchecked")
    private ScoreItem parseScoreItem(Element element) {
        if (element == null || !SCORE.equals(element.getName())) {
            return null;
        }

        BasicItem item = this.parseBasicItem(element);

        List<ExtendItem> extendItemList = new ArrayList<ExtendItem>();
        // get all the data elements
        List<Element> extendElementList = element.elements();
        if (extendElementList != null && !extendElementList.isEmpty()) {
            for (Element extendElement : extendElementList) {
                ExtendItem extendItem = this.parseExtendItem(extendElement);
                extendItemList.add(extendItem);
            }
        }

        Attribute expectedAttr = element.attribute(EXPECTED);
        if (expectedAttr != null) {
            item.setExpected(expectedAttr.getText());
        }

        String dataType = null;
        Attribute dataTypeAttr = element.attribute(DATATYPE);
        if (dataTypeAttr != null) {
            dataType = dataTypeAttr.getText();
        }

        ScoreItem scoreItem = new ScoreItem(item, dataType, extendItemList);

        return scoreItem;
    }

    private ExtendItem parseExtendItem(Element element) {
        if (element == null) {
            return null;
        }
        ExtendItem extendItem = new ExtendItem();

        Attribute powerAttr = element.attribute(POWER);
        if (powerAttr != null && powerAttr.getText() != null) {
            try {
                double power = Double.parseDouble(powerAttr.getText());
                extendItem.setPower(power);
            } catch (Exception e) {
                extendItem.setPower(0);
            }
        }

        Attribute existsAttr = element.attribute(EXISTS);
        if (existsAttr != null && existsAttr.getText() != null) {
            extendItem.setExists(existsAttr.getText());
        }

        Attribute displayAttr = element.attribute(DISPLAY);
        if (displayAttr != null) {
            DisplayType display = DisplayType.getValueOf(displayAttr.getText());

            extendItem.setDisplay(display);
        }

        Attribute refAttr = element.attribute(REF);
        if (refAttr != null) {
            // this is a ref element
            BasicItem item = getItem(refAttr.getText());
            if (item == null) {
                // this must be a scoreItem;
                Element referedScoreElement = this.getReferedScoreElement(refAttr.getText());
                LOGGER.debug("find ref id :" + refAttr.getText() + " result :" + (referedScoreElement != null));

                item = this.parseScoreItem(referedScoreElement);
                LOGGER.debug("ref : " + item.getName() + " " + item.getDisplay());
                addItem(item);
            }

            extendItem.setBasicItem(item);
        } else {
            BasicItem item = null;
            if (SCORE.equals(element.getName())) {
                item = this.parseScoreItem(element);
            } else if (DATA.equals(element.getName())) {
                item = this.parseDataItem(element);
            } else if (METRIC.equals(element.getName())) {
                item = this.parseMetricItem(element);
            }

            extendItem.setBasicItem(item);
            try {
                addItem(item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return extendItem;
    }

    private Element getReferedScoreElement(String id) {
        if (id == null) {
            return null;
        }

        for (Element element : this.scoreElementList) {
            Attribute idAttr = element.attribute(ID);
            if (idAttr != null) {
                if (id.equals(idAttr.getText())) {
                    return element;
                }
            }

        }
        return null;
    }

    private BasicItem parseBasicItem(Element element) {

        BasicItem item = new BasicItem();

        Attribute idAttr = element.attribute(ID);
        if (idAttr != null) {
            item.setId(idAttr.getText());
        }

        Attribute nameAttr = element.attribute(NAME);
        if (nameAttr != null) {
            item.setName(nameAttr.getText());
        }

        Attribute displayAttr = element.attribute(DISPLAY);
        if (displayAttr != null) {
            DisplayType display = DisplayType.getValueOf(displayAttr.getText());
            LOGGER.debug(item.getName() + " : " + display);
            item.setDisplay(display);
        }

        Attribute methodAttr = element.attribute(CALCULATE_METHOD);
        if (methodAttr != null) {
            LOGGER.debug("method - " + methodAttr.getText() + " in item : " + item.getName());
            item.setMethod(methodAttr.getText());
        }

        Attribute linkAttr = element.attribute(LINK);
        if (linkAttr != null) {
            item.setLink(linkAttr.getText());
        }

        Attribute docAttr = element.attribute(DOC);
        if (docAttr != null) {
            item.setDoc(docAttr.getText());
        }

        Attribute langAttr = element.attribute(LANG);
        if (langAttr != null) {
            item.setLang(langAttr.getText());
        }

        Attribute roleAttr = element.attribute(ROLE);
        if (roleAttr != null) {
            item.setRole(roleAttr.getText());
        } else if (roleAttr == null && SCORE.equals(element.getName())) {
            item.setRole(UserRole.ROLE_TECHNICALMANAGER.toString());
        }
        return item;
    }

    private void addItem(BasicItem item) {
        if (item == null) {
            return;
        }

        if (item.getId() != null) {
            BasicItem existItem = this.items.get(item.getId());
            if (existItem == null) {
                this.items.put(item.getId(), item);
            }
        }
    }

    private BasicItem getItem(String key) {
        return this.items.get(key);
    }

}
