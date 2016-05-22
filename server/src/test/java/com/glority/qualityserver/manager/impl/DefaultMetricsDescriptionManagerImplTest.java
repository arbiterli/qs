package com.glority.qualityserver.manager.impl;

import org.junit.Test;

import com.glority.qualityserver.AbstractBaseTest;

/**
 * Junit test for XMLMetricsDescriptionManagerImpl instance.
 * 
 * @author Chenhong
 * 
 */
public class DefaultMetricsDescriptionManagerImplTest extends AbstractBaseTest {
    @Test
    public void test(){
        
    }
//since the formula is not used now
    
//    @Autowired
//    private BuildMetricDao metricDao;
//
//    @Autowired
//    private VersionDao versionDao;
//
//    @Autowired
//    private ProductDao productDao;
//    @Autowired
//    private BuildDao buildDao;
//
//    @Autowired
//    private ScoreOwnerMappingManager scoreOwnerManager;
//
//    private Product product;
//    private Build build;
//
//    private static final String CHECKSTYLE = "JAVA_CHECKSTYLE";
//
//    private long productId;
//    private String configFile;
//
//    private DefaultMetricsDescriptionManagerImpl instance;
//
//    /**
//     * Setup.
//     * 
//     * @throws Exception
//     *             to junit
//     */
//    @Before
//    public void setUp() throws Exception {
//        instance = new DefaultMetricsDescriptionManagerImpl();
//
//        prepareLatestBuild();
//
//        configFile = "test.xml";
//        File file = new File(configFile);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//        writer.append("<metricdescriptions>\n");
//        writer.append("  <metric name=\"JAVA_CHECKSTYLE\">\n");
//        writer.append("     <overview>      PMD scans Java source code and looks for potential problems like:");
//        writer.append("      <ul>");
//        writer.append("<li> Possible bugs - empty try/catch/finally/switch statements </li>");
//        writer.append("<li> Dead code - unused local variables, parameters and private methods </li>");
//        writer.append("<li> Suboptimal code - wasteful String/StringBuffer usage   </li>");
//        writer.append("<li> Overcomplicated expressions - unnecessary if statements,"
//                + " for loops that could be while loops </li>");
//        writer.append("<li> Duplicate code - copied/pasted code means copied/pasted bugs </li>");
//        writer.append("</ul>");
//        writer.append("</overview>\n");
//        writer.append("     <QuestionAndAnswers>\n");
//        writer.append("         <QuestionAndAnswer>\n");
//        writer.append("            <Question>Question for testing</Question>\n");
//        writer.append("            <Answer>Answer For testing</Answer>\n");
//        writer.append("         </QuestionAndAnswer>\n");
//        writer.append("     </QuestionAndAnswers>\n");
//        writer.append("     <ReferenceLinks>\n");
//        writer.append("         <URL>http://en.wikipedia.org/wiki/Checkstyle</URL>\n");
//        writer.append("     </ReferenceLinks>");
//        writer.append("     <PossibleFailures>\n");
//        writer.append("        <PossibleFailure>Test failure1</PossibleFailure>\n");
//        writer.append("     </PossibleFailures>\n");
//        writer.append("  </metric>\n");
//        writer.append("</metricdescriptions>\n");
//        writer.close();
//
//        instance.setConfigFile(file.getCanonicalPath());
//        TestUtil.injectObject(instance, metricDao, "metricDao");
//        TestUtil.injectObject(instance, scoreOwnerManager, "scoreOwnerManager");
//    }
//
//    /**
//     * Prepare the latest build.
//     */
//    private void prepareLatestBuild() {
//        product = productDao.getProduct("QualitySystem");
//        productId = product.getId();
//
//        Version version = versionDao.getVersions(product.getId()).get(0);
//
//        build = new Build();
//        build.setCreatedAt(new Timestamp(System.currentTimeMillis()));
//        build.setProducts(product);
//        build.setJenkinsBuildeid(100L);
//        build.setJenkinsJobname("latest_build_job");
//        build.setDuration(100L);
//        build.setVersion(version);
//
//        buildDao.save(build);
//        build = buildDao.getBuild(product.getId(), "latest_build_job", 100L);
//    }
//
//    /**
//     * Tear down.
//     * 
//     * @throws IOException
//     *             to junit
//     */
//    @After
//    public void tearDown() throws IOException {
//        instance = null;
//
//        File file = new File(configFile);
//        if (file.exists()) {
//            file.delete();
//        }
//    }
//
//    /**
//     * Test with valid setting.
//     */
//    @Test
//    public void testGetMetricsDesciption() {
//        MetricsDescription description = instance.getMetricsDesciption(CHECKSTYLE, productId);
//
//        assertEquals(1, description.getReferenceLinks().size());
//        assertEquals("http://en.wikipedia.org/wiki/Checkstyle", description.getReferenceLinks().get(0));
//
//        assertEquals(1, description.getqAndAList().size());
//        assertEquals("Question for testing", description.getqAndAList().get(0).getQuestion());
//        assertEquals("Answer For testing", description.getqAndAList().get(0).getAnswer());
//
//        assertEquals(1, description.getPossibleFailures().size());
//        assertEquals("Test failure1", description.getPossibleFailures().get(0));
//
//        assertTrue(description.getOverview().contains(
//                "<li> Possible bugs - empty try/catch/finally/switch statements </li>"));
//    }
//
//    @Test
//    public void testGetMetricsDescriptionForBuildScoreWithTwoScore() {
//        // prepare metrics.
//        Timestamp createTime = new Timestamp(System.currentTimeMillis());
//        BuildMetric testCompleteMetric = new BuildMetric();
//        testCompleteMetric.setBuilds(build);
//        testCompleteMetric.setCreatedAt(createTime);
//        testCompleteMetric.setName("TESTCOMPLETE_TEST_SUCCESS_RATE");
//        testCompleteMetric.setProdutId(product.getId());
//        testCompleteMetric.setType("testComplete");
//
//        BuildMetric javaMetric = new BuildMetric();
//        javaMetric.setBuilds(build);
//        javaMetric.setCreatedAt(createTime);
//        javaMetric.setName("JUNIT_TEST_SUCCESS_RATE");
//        javaMetric.setProdutId(product.getId());
//        javaMetric.setType("java build score");
//
//        this.metricDao.save(testCompleteMetric);
//        this.metricDao.save(javaMetric);
//
//        MetricsDescription description = instance.getMetricsDesciption("BUILD SCORE", productId);
//
//        ComplexMetricScoreFormula formula = (ComplexMetricScoreFormula) description.getMetricFormula();
//        assertTrue(formula.isComplexMetricScore());
//        assertTrue(formula.isProductBased());
//
//        Map<String, String> powerMap = formula.getPowerMap();
//        assertEquals(2, powerMap.size());
//        assertTrue(powerMap.keySet().contains("TEST COMPLETE SCORE"));
//        assertTrue(powerMap.keySet().contains("JAVA BUILD SCORE"));
//
//        assertEquals(30, Double.parseDouble(powerMap.get("TEST COMPLETE SCORE")), 0.000001);
//        assertEquals(70, Double.parseDouble(powerMap.get("JAVA BUILD SCORE")), 0.000001);
//
//        List<MetricScoreFormula> subFormulas = formula.getScoreFormulaList();
//        assertEquals(2, subFormulas.size());
//    }
//
//    @Test
//    public void testGetMetricsDescriptionForBuildScoreWithOneScore() {
//        // prepare metrics.
//        Timestamp createTime = new Timestamp(System.currentTimeMillis());
//
//        BuildMetric javaMetric = new BuildMetric();
//        javaMetric.setBuilds(build);
//        javaMetric.setCreatedAt(createTime);
//        javaMetric.setName("JUNIT_TEST_SUCCESS_RATE");
//        javaMetric.setProdutId(product.getId());
//        javaMetric.setType("java build score");
//
//        this.metricDao.save(javaMetric);
//
//        MetricsDescription description = instance.getMetricsDesciption("BUILD SCORE", productId);
//
//        ComplexMetricScoreFormula formula = (ComplexMetricScoreFormula) description.getMetricFormula();
//        assertTrue(formula.isComplexMetricScore());
//        assertTrue(formula.isProductBased());
//
//        Map<String, String> powerMap = formula.getPowerMap();
//        assertEquals(1, powerMap.size());
//        assertTrue(powerMap.keySet().contains("JAVA BUILD SCORE"));
//
//        assertEquals(100, Double.parseDouble(powerMap.get("JAVA BUILD SCORE")), 0.000001);
//
//        List<MetricScoreFormula> subFormulas = formula.getScoreFormulaList();
//        assertEquals(1, subFormulas.size());
//    }
//
//    @Test
//    public void testGetMetricsDescriptionForBuildScoreWithThreeScore() {
//        // prepare metrics.
//        Timestamp createTime = new Timestamp(System.currentTimeMillis());
//        BuildMetric testCompleteMetric = new BuildMetric();
//        testCompleteMetric.setBuilds(build);
//        testCompleteMetric.setCreatedAt(createTime);
//        testCompleteMetric.setName("TESTCOMPLETE_TEST_SUCCESS_RATE");
//        testCompleteMetric.setProdutId(product.getId());
//        testCompleteMetric.setType("testComplete");
//
//        BuildMetric javaMetric = new BuildMetric();
//        javaMetric.setBuilds(build);
//        javaMetric.setCreatedAt(createTime);
//        javaMetric.setName("JUNIT_TEST_SUCCESS_RATE");
//        javaMetric.setProdutId(product.getId());
//        javaMetric.setType("java build score");
//
//        BuildMetric cppMetric = new BuildMetric();
//        cppMetric.setBuilds(build);
//        cppMetric.setCreatedAt(createTime);
//        cppMetric.setName("CPPUNIT_TEST_SUCCESS_RATE");
//        cppMetric.setProdutId(product.getId());
//        cppMetric.setType("cpp build score");
//
//        this.metricDao.save(testCompleteMetric);
//        this.metricDao.save(javaMetric);
//        this.metricDao.save(cppMetric);
//
//        MetricsDescription description = instance.getMetricsDesciption("BUILD SCORE", productId);
//
//        ComplexMetricScoreFormula formula = (ComplexMetricScoreFormula) description.getMetricFormula();
//        assertTrue(formula.isComplexMetricScore());
//        assertTrue(formula.isProductBased());
//
//        Map<String, String> powerMap = formula.getPowerMap();
//        assertEquals(3, powerMap.size());
//        assertTrue(powerMap.keySet().contains("TEST COMPLETE SCORE"));
//        assertTrue(powerMap.keySet().contains("JAVA BUILD SCORE"));
//        assertTrue(powerMap.keySet().contains("CPP BUILD SCORE"));
//
//        assertEquals(30, Double.parseDouble(powerMap.get("TEST COMPLETE SCORE")), 0.000001);
//        assertEquals(35, Double.parseDouble(powerMap.get("CPP BUILD SCORE")), 0.000001);
//        assertEquals(35, Double.parseDouble(powerMap.get("JAVA BUILD SCORE")), 0.000001);
//
//        List<MetricScoreFormula> subFormulas = formula.getScoreFormulaList();
//        assertEquals(3, subFormulas.size());
//    }
//
//    @Test
//    public void testGetMetricsDescriptionForBuildScoreWithAllFourScore() {
//        // prepare metrics.
//        Timestamp createTime = new Timestamp(System.currentTimeMillis());
//        BuildMetric testCompleteMetric = new BuildMetric();
//        testCompleteMetric.setBuilds(build);
//        testCompleteMetric.setCreatedAt(createTime);
//        testCompleteMetric.setName("TESTCOMPLETE_TEST_SUCCESS_RATE");
//        testCompleteMetric.setProdutId(product.getId());
//        testCompleteMetric.setType("testComplete");
//
//        BuildMetric javaMetric = new BuildMetric();
//        javaMetric.setBuilds(build);
//        javaMetric.setCreatedAt(createTime);
//        javaMetric.setName("JUNIT_TEST_SUCCESS_RATE");
//        javaMetric.setProdutId(product.getId());
//        javaMetric.setType("java build score");
//
//        BuildMetric cppMetric = new BuildMetric();
//        cppMetric.setBuilds(build);
//        cppMetric.setCreatedAt(createTime);
//        cppMetric.setName("CPPUNIT_TEST_SUCCESS_RATE");
//        cppMetric.setProdutId(product.getId());
//        cppMetric.setType("cpp build score");
//
//        BuildMetric csMetric = new BuildMetric();
//        csMetric.setBuilds(build);
//        csMetric.setCreatedAt(createTime);
//        csMetric.setName("MSTESTING_TEST_SUCCESS_RATE");
//        csMetric.setProdutId(product.getId());
//        csMetric.setType("cs build score");
//
//        BuildMetric jsMetric = new BuildMetric();
//        jsMetric.setBuilds(build);
//        jsMetric.setCreatedAt(createTime);
//        jsMetric.setName("JS_LINES_OF_CODE");
//        jsMetric.setType("javascript build type");
//        jsMetric.setProdutId(product.getId());
//
//        this.metricDao.save(testCompleteMetric);
//        this.metricDao.save(javaMetric);
//        this.metricDao.save(cppMetric);
//        this.metricDao.save(csMetric);
//        this.metricDao.save(jsMetric);
//
//        MetricsDescription description = instance.getMetricsDesciption("BUILD SCORE", productId);
//
//        ComplexMetricScoreFormula formula = (ComplexMetricScoreFormula) description.getMetricFormula();
//        assertTrue(formula.isComplexMetricScore());
//        assertTrue(formula.isProductBased());
//
//        Map<String, String> powerMap = formula.getPowerMap();
//        assertEquals(5, powerMap.size());
//        assertTrue(powerMap.keySet().contains("TEST COMPLETE SCORE"));
//        assertTrue(powerMap.keySet().contains("JAVA BUILD SCORE"));
//        assertTrue(powerMap.keySet().contains("CPP BUILD SCORE"));
//        assertTrue(powerMap.keySet().contains("JAVASCRIPT BUILD SCORE"));
//        assertTrue(powerMap.keySet().contains("CS BUILD SCORE"));
//
//        assertEquals(30, Double.parseDouble(powerMap.get("TEST COMPLETE SCORE")), 0.000001);
//
//        assertEquals(17.5, Double.parseDouble(powerMap.get("CPP BUILD SCORE")), 0.0001);
//        assertEquals(17.5, Double.parseDouble(powerMap.get("JAVA BUILD SCORE")), 0.000001);
//        assertEquals(17.5, Double.parseDouble(powerMap.get("JAVASCRIPT BUILD SCORE")), 0.0001);
//        assertEquals(17.5, Double.parseDouble(powerMap.get("CS BUILD SCORE")), 0.000001);
//
//        List<MetricScoreFormula> subFormulas = formula.getScoreFormulaList();
//        assertEquals(5, subFormulas.size());
//    }
}
