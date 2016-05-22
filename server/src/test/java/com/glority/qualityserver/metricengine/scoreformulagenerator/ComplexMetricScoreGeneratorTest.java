package com.glority.qualityserver.metricengine.scoreformulagenerator;


/**
 * Unit test for verify if the Complex Metric score formula could be generated
 * and all its child items can be retrieved or not.
 * 
 * @author Chen.hong
 * 
 */
public class ComplexMetricScoreGeneratorTest {
//since the formula is not used now
    
    
//    private static final int SIZE_6 = 6;
//    private static final int SIZE_3 = 3;
//
//    /**
//     * test with Java build score. Java build score includes MI,
//     * DUPLICATION,javaDeffectsScore. The test case is written according to
//     * metricEngine.xml. If metricEngine.xml changes, this test case might
//     * failed.
//     */
//    @Test
//    public void testJAVABuildScore() {
//        String metricName = "JAVA BUILD SCORE";
//
//        MetricScoreFormula formula = MetricEngine.getScoreItemFormula(metricName);
//
//        assertTrue(formula instanceof ComplexMetricScoreFormula);
//        ComplexMetricScoreFormula complexFormula = (ComplexMetricScoreFormula) formula;
//        assertEquals(SIZE_6, complexFormula.getScoreFormulaList().size());
//
//        assertEquals("5.0", complexFormula.getPowerMap().get("JAVA MI"));
//        assertEquals("5.0", complexFormula.getPowerMap().get("JAVA DUPLICATION"));
//        assertEquals("5.0", complexFormula.getPowerMap().get("JAVA LINT"));
//        assertEquals("10.0", complexFormula.getPowerMap().get("JAVA DEFFECTS"));
//        assertEquals("50.0", complexFormula.getPowerMap().get("JAVA TEST SUMMERY"));
//        assertEquals("25.0", complexFormula.getPowerMap().get("JAVA COVERAGE"));
//
//        for (MetricScoreFormula metricScoreFormula : complexFormula.getScoreFormulaList()) {
//            SimpleMetricScoreFormula simple = (SimpleMetricScoreFormula) metricScoreFormula;
//
//            String id = simple.getID();
//            assertNotNull(id);
//            assertEquals(SIZE_3, simple.getScoreFormulas().size());
//        }
//    }
//
//    @Test
//    public void testProductBuildScore() {
//        String metricName = "BUILD SCORE";
//
//        MetricScoreFormula formula = MetricEngine.getScoreItemFormula(metricName);
//
//        assertTrue(formula instanceof ComplexMetricScoreFormula);
//        ComplexMetricScoreFormula complexFormula = (ComplexMetricScoreFormula) formula;
//        assertTrue(complexFormula.isProductBased());
//    }
//
//    @Test(expected = IllegalStateException.class)
//    public void testRemoveSubMetricScoreFormulaFailure() {
//        ComplexMetricScoreFormula formula = new ComplexMetricScoreFormula("test");
//        formula.setComplexMetricScore(true);
//        formula.setID("test");
//        formula.setMetricScoreFormulaList(new ArrayList<MetricScoreFormula>());
//        formula.setProductBased(false);
//        formula.removeSubMetricScoreFormula("test");
//    }
//
//    @Test
//    public void testRemoveSubMetricScoreFormula() {
//        ComplexMetricScoreFormula formula = new ComplexMetricScoreFormula("test");
//        formula.setComplexMetricScore(true);
//        formula.setID("test");
//        SimpleMetricScoreFormula subFormula = new SimpleMetricScoreFormula("simple_metric");
//        subFormula.setID("simple_metric");
//        List<MetricScoreFormula> list = new ArrayList<MetricScoreFormula>();
//        list.add(subFormula);
//        formula.setMetricScoreFormulaList(list);
//        formula.setProductBased(true);
//        assertEquals(1, formula.getScoreFormulaList().size());
//
//        formula.removeSubMetricScoreFormula("simple_metric");
//        assertTrue(formula.getScoreFormulaList().isEmpty());
//    }
}
